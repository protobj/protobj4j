package io.protobj.parser;

import io.protobj.antlr.ProtobjLexer;
import io.protobj.definition.FieldType;
import io.protobj.definition.MessageType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.definition.option.BoolFieldOptionValue;
import io.protobj.definition.option.FieldOption;
import io.protobj.definition.option.FieldOptionValue;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ProtobjContext {


    private void printErrorAndExit(String error) {
        System.out.println(error);
        System.exit(-1);
    }


    public Map<String, MessageConfig> load(List<File> fileList) throws Exception {

        Map<String, MessageConfig> messageConfigMap = new ConcurrentHashMap<>();
        if (fileList.size() == 0) {
            return messageConfigMap;
        }
        CountDownLatch countDownLatch = new CountDownLatch(fileList.size());
        for (File file : fileList) {
            CompletableFuture.runAsync(() -> {

                CharStream charStream = null;
                try {
                    charStream = CharStreams.fromPath(file.toPath());
                } catch (IOException e) {
                    printErrorAndExit(e.getMessage());
                }
                ProtobjLexer protobjLexer = new ProtobjLexer(charStream);
                CommonTokenStream commonTokenStream = new CommonTokenStream(protobjLexer);
                io.protobj.antlr.ProtobjParser protobjParser = new io.protobj.antlr.ProtobjParser(commonTokenStream);
                ProtobjFileReader protobjFileReader = new ProtobjFileReader(file.getAbsolutePath(), commonTokenStream);
                protobjParser.addErrorListener(new ConsoleErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        printErrorAndExit("%s line %d:%d %s".formatted(file.getAbsolutePath(), line, charPositionInLine, msg));
                    }
                });
                ParseTreeWalker.DEFAULT.walk(protobjFileReader, protobjParser.protobj());
                Map<String, MessageConfig> configMap = protobjFileReader.getMessageConfigMap();
                for (Map.Entry<String, MessageConfig> entry : configMap.entrySet()) {
                    MessageConfig messageConfig = entry.getValue();

                    MessageConfig old = messageConfigMap.put(entry.getKey(), messageConfig);
                    if (old != null) {
                        printErrorAndExit("%s and %s duplicate message def :%s".formatted(old.getFileName(), messageConfig.getFileName(), messageConfig.getName()));
                    }
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();


        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (MessageConfig value : messageConfigMap.values()) {
            futures.add(CompletableFuture.runAsync(() -> {
                check(messageConfigMap, value);
                afterCheck(messageConfigMap, value);
            }));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return messageConfigMap;
    }

    private void afterCheck(Map<String, MessageConfig> messageConfigMap, MessageConfig messageConfig) {
        if (messageConfig.getMessageIndex() > -1) {
            messageConfig.addSelfToChildMap();
        }
    }

    private void check(Map<String, MessageConfig> messageConfigMap, MessageConfig messageConfig) {
        //导入的消息是否合法
        for (String importMessage : messageConfig.getImportMessages()) {
            if (messageConfigMap.get(importMessage) == null) {
                printErrorAndExit("import message not exists：%s in file:%s"
                        .formatted(importMessage, messageConfig.getFileName()));
            }
        }
        checkMessage(messageConfigMap, messageConfig);

    }

    private void checkMessage(Map<String, MessageConfig> messageConfigMap, MessageConfig messageConfig) {
        MessageType type = messageConfig.getType();
        if (type == MessageType.MESSAGE) {
            checkFieldInMessage(messageConfigMap, messageConfig);
        }
    }

    private void checkFieldInMessage(Map<String, MessageConfig> messageConfigMap, MessageConfig messageConfig) {
        for (FieldConfig fieldConfig : messageConfig.getFieldConfigMap().values()) {
            String typeName = fieldConfig.getTypeName();
            String messageFullName = null;
            if (FieldType.getBuiltinType(typeName) != null) {
                if (typeName.equals(FieldType.MAP.name().toLowerCase())) {
                    String valueType = fieldConfig.getValueTypeName();
                    messageFullName = checkMessageFieldExists(messageConfigMap, messageConfig, fieldConfig, valueType);
                    if (messageFullName != null) {
                        fieldConfig.setValueTypeFullName(messageFullName);
                    }
                }
            } else {
                messageFullName = checkMessageFieldExists(messageConfigMap, messageConfig, fieldConfig, typeName);
                if (messageFullName != null) {
                    fieldConfig.setTypeFullName(messageFullName);
                }
            }

            FieldOptionValue fieldOptionValue = fieldConfig.getOptions().get(FieldOption.polymorphic);
            if (fieldOptionValue != null && ((BoolFieldOptionValue) fieldOptionValue).isValue()) {
                if (messageFullName == null) {
                    throw new RuntimeException("field cant add option polymorphic %s in %s".formatted(fieldConfig.getFieldName(), messageConfig.getFullName()));
                }
                MessageConfig message = messageConfigMap.get(messageFullName);
                if (message != null && message.getMessageIndex() < 0) {
                    throw new RuntimeException("field cant add option polymorphic %s in %s".formatted(fieldConfig.getFieldName(), messageConfig.getFullName()));
                }
            }

            if (fieldConfig.getModifier() == Modifier.EXT) {//该元素的子类
                MessageConfig message = messageConfigMap.get(messageFullName);
                if (message == messageConfig) {
                    throw new RuntimeException("field is not parent %s %s".formatted(message.getFullName(), message.getFullName()));
                }
                if (message != null) {
                    messageConfig.setParent(message, fieldConfig);
                    message.addChild(messageConfig);
                }
            }
        }
    }

    private String checkMessageFieldExists(Map<String, MessageConfig> messageConfigMap, MessageConfig messageConfig, FieldConfig value, String valueType) {
        if (FieldType.getBuiltinType(valueType) == null) {
            //same package
            String fullName = messageConfig.getPkg() + "." + valueType;
            if (messageConfigMap.get(fullName) != null) {
                return fullName;
            }
            //import
            for (String importMessage : messageConfig.getImportMessages()) {
                if (importMessage.endsWith("." + valueType)) {
                    return importMessage;
                }
            }
            //fullName
            MessageConfig message = messageConfigMap.get(valueType);
            if (message != null) {
                return valueType;
            }
            String error = "file:%s message not exists in %s : %s ".formatted(messageConfig.getFileName(), messageConfig.getFullName(), value.getFieldName());
            printErrorAndExit(error);
        }
        return null;
    }

}
