package io.protobj.generator.java;

import io.protobj.config.LanguageType;
import io.protobj.config.OutputType;
import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.*;
import io.protobj.generator.java.reader.arr.ArrEnumFieldReader;
import io.protobj.generator.java.reader.arr.ArrMessageFieldReader;
import io.protobj.generator.java.reader.arr.ArrPrimitiveFieldReader;
import io.protobj.generator.java.reader.dft.DftEnumFieldReader;
import io.protobj.generator.java.reader.dft.DftMapFieldReader;
import io.protobj.generator.java.reader.dft.DftMessageFieldReader;
import io.protobj.generator.java.reader.dft.DftPrimitiveFieldReader;
import io.protobj.generator.java.reader.ext.ExtMessageFieldReader;
import io.protobj.generator.java.reader.lst.LstEnumFieldReader;
import io.protobj.generator.java.reader.lst.LstMessageFieldReader;
import io.protobj.generator.java.reader.lst.LstPrimitiveFieldReader;
import io.protobj.generator.java.reader.set.SetEnumFieldReader;
import io.protobj.generator.java.reader.set.SetMessageFieldReader;
import io.protobj.generator.java.reader.set.SetPrimitiveFieldReader;
import io.protobj.generator.java.writer.arr.ArrEnumFieldWriter;
import io.protobj.generator.java.writer.arr.ArrMessageFieldWriter;
import io.protobj.generator.java.writer.arr.ArrPrimitiveFieldWriter;
import io.protobj.generator.java.writer.ext.ExtMessageFieldWriter;
import io.protobj.generator.java.writer.lst.LstEnumFieldWriter;
import io.protobj.generator.java.writer.lst.LstMessageFieldWriter;
import io.protobj.generator.java.writer.lst.LstPrimitiveFieldWriter;
import io.protobj.generator.java.writer.set.SetEnumFieldWriter;
import io.protobj.generator.java.writer.set.SetMessageFieldWriter;
import io.protobj.generator.java.writer.set.SetPrimitiveFieldWriter;
import io.protobj.config.Config;
import io.protobj.generator.java.writer.dft.DftEnumFieldWriter;
import io.protobj.generator.java.writer.dft.DftMapFieldWriter;
import io.protobj.generator.java.writer.dft.DftMessageFieldWriter;
import io.protobj.generator.java.writer.dft.DftPrimitiveFieldWriter;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

import static io.protobj.generator.GeneratorUtils.*;
import static java.util.Map.of;

public class JavaGenerator extends AGenerator {
    private final Map<Modifier2BuiltinType, IFieldWriter> fieldWriterMap = new HashMap<>();
    private final Map<Modifier2BuiltinType, IFieldReader> fieldReaderMap = new HashMap<>();

    @Override
    public LanguageType type() {
        return LanguageType.java;
    }

    public JavaGenerator(Map<String, MessageConfig> messageConfigMap, Config config) {
        super(messageConfigMap, config);
        //setup writer
        addFieldWriter(new ArrEnumFieldWriter());
        addFieldWriter(new ArrMessageFieldWriter());
        addFieldWriter(new ArrPrimitiveFieldWriter());

        addFieldWriter(new DftEnumFieldWriter());
        addFieldWriter(new DftMapFieldWriter());
        addFieldWriter(new DftMessageFieldWriter());
        addFieldWriter(new DftPrimitiveFieldWriter());

        addFieldWriter(new ExtMessageFieldWriter());

        addFieldWriter(new LstEnumFieldWriter());
        addFieldWriter(new LstMessageFieldWriter());
        addFieldWriter(new LstPrimitiveFieldWriter());


        addFieldWriter(new SetEnumFieldWriter());
        addFieldWriter(new SetMessageFieldWriter());
        addFieldWriter(new SetPrimitiveFieldWriter());


        //setup reader
        addFieldReader(new ArrEnumFieldReader());
        addFieldReader(new ArrMessageFieldReader());
        addFieldReader(new ArrPrimitiveFieldReader());

        addFieldReader(new DftEnumFieldReader());
        addFieldReader(new DftMapFieldReader());
        addFieldReader(new DftMessageFieldReader());
        addFieldReader(new DftPrimitiveFieldReader());

        addFieldReader(new ExtMessageFieldReader());


        addFieldReader(new LstEnumFieldReader());
        addFieldReader(new LstMessageFieldReader());
        addFieldReader(new LstPrimitiveFieldReader());

        addFieldReader(new SetEnumFieldReader());
        addFieldReader(new SetMessageFieldReader());
        addFieldReader(new SetPrimitiveFieldReader());


    }


    private void addFieldWriter(IFieldWriter fieldWriter) {
        Modifier modifier = fieldWriter.modifier();
        for (FieldType focusType : fieldWriter.focusTypes()) {
            IFieldWriter old = fieldWriterMap.put(Modifier2BuiltinType.of(modifier, focusType), fieldWriter);
            if (old != null) {
                throw new RuntimeException("fieldWriter duplicated %s %s %s %s"
                        .formatted(fieldWriter.getClass().getSimpleName(), old.getClass().getSimpleName(), modifier, focusType));
            }
        }
    }

    private void addFieldReader(IFieldReader fieldReader) {
        Modifier modifier = fieldReader.modifier();
        for (FieldType focusType : fieldReader.focusTypes()) {
            IFieldReader old = fieldReaderMap.put(Modifier2BuiltinType.of(modifier, focusType), fieldReader);
            if (old != null) {
                throw new RuntimeException("fieldReader duplicated %s %s %s %s"
                        .formatted(fieldReader.getClass().getSimpleName(), old.getClass().getSimpleName(), modifier, focusType));
            }
        }
    }

    @Override
    public CompletableFuture<?> generate() throws IOException {
        String outputDir = config.getOutputDir();
        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (MessageConfig messageConfig : messageConfigMap.values()) {
            futures.add(asyncRun(() -> {
                try {
                    if (config.getOutputType() != OutputType.schema) {
                        createClass(messageConfig, outputDir);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
            futures.add(asyncRun(() -> {
                try {
                    if (config.getOutputType() != OutputType.message) {
                        createSchema(messageConfig, outputDir);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    public List<GeneratorResult> generateSchemaRuntime() throws Exception {
        List<GeneratorResult> resources = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(messageConfigMap.size());
        for (MessageConfig messageConfig : messageConfigMap.values()) {
            CompletableFuture.runAsync(() -> {
                try {
                    GeneratorResult schemaRuntime = createSchemaRuntime(messageConfig);
                    resources.add(schemaRuntime);
                    countDownLatch.countDown();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        countDownLatch.await();
        return resources;
    }

    @Override
    public IFieldWriter getWriter(Modifier2BuiltinType modifier2BuiltinType) {
        return Objects.requireNonNull(fieldWriterMap.get(modifier2BuiltinType), "fieldWriter not exists [%s]".formatted(modifier2BuiltinType));
    }

    @Override
    public IFieldReader getReader(Modifier2BuiltinType modifier2BuiltinType) {
        return Objects.requireNonNull(fieldReaderMap.get(modifier2BuiltinType), "fieldReader not exists [%s]".formatted(modifier2BuiltinType));
    }

    private CompletableFuture<?> asyncRun(Runnable createTask) {
        return CompletableFuture.runAsync(createTask).exceptionally((err) -> {
            err.printStackTrace();
            System.exit(-1);
            return null;
        });
    }

    private void createSchema(MessageConfig messageConfig, String outputDir) throws IOException {
        switch (messageConfig.getType()) {
            case MESSAGE -> createMessageSchema(messageConfig, outputDir);
            case ENUM -> createEnumSchema(messageConfig, outputDir);
        }
    }

    private GeneratorResult createSchemaRuntime(MessageConfig messageConfig) throws IOException {
        String content = switch (messageConfig.getType()) {
            case MESSAGE -> createMessageSchema(messageConfig, null);
            case ENUM -> createEnumSchema(messageConfig, null);
        };
        return new GeneratorResult(messageConfig.getFullName() + "Schema", content);
    }


    public String createMessageSchema(MessageConfig messageConfig, String outputDir) throws IOException {
        String pkg = messageConfig.getPkg();
        CodeStringBuilder header = new CodeStringBuilder();
        header.add(JavaCodeUtil.Package(pkg)).newLine(2);
        header.addImportMessage("io.protobj.core.Input");
        header.addImportMessage("io.protobj.core.Output");
        header.addImportMessage("io.protobj.core.Schema");
        header.addImportMessage("java.io.IOException");

        CodeStringBuilder writeBody = createWriteBody(messageConfig);

        CodeStringBuilder readBody = createReadBody(messageConfig);

        CodeStringBuilder body = new CodeStringBuilder();
        body.add(n(CodeTemplate.MESSAGE_SCHEMA, of(
                "class", messageConfig.getName(),
                "writeBody", writeBody.toString(),
                "readBody", readBody.toString(),
                "messageIndex", messageConfig.getMessageIndex()))
        ).newLine();

        header.addImportMessages(writeBody.getImportMessages());
        header.addImportMessages(readBody.getImportMessages());
        JavaCodeUtil.appendImportMessagesForJava(pkg, header);
        header.add(body);
        if (outputDir != null) {
            writeFile(type(), "%sSchema".formatted(messageConfig.getName()), outputDir, pkg, header.toString());
        }
        return header.toString();
    }

    private CodeStringBuilder createWriteBody(MessageConfig sourceMessage) {
        CodeStringBuilder writeBody = new CodeStringBuilder();
        writeBody.setCurrent(2);
        for (FieldConfig field : sourceMessage.getFieldConfigMap().values()) {
            Modifier modifier = field.getModifier();
            FieldType fieldFieldType = getFieldType(sourceMessage, field.getTypeName(), field.getTypeFullName());
            IFieldWriter fieldWriter = getWriter(Modifier2BuiltinType.of(modifier, fieldFieldType));
            writeBody.add(field.getDefinition()).newLine();
            String getValue = i("message.get${0}()", field.getFirstUpperFieldName());
            fieldWriter.write(this, writeBody, sourceMessage, field, getValue);
        }
        return writeBody;
    }


    private CodeStringBuilder createReadBody(MessageConfig messageConfig) {
        CodeStringBuilder readBody = new CodeStringBuilder();
        readBody.setCurrent(4);

        for (FieldConfig field : messageConfig.getFieldConfigMap().values()) {
            Modifier modifier = field.getModifier();
            FieldType fieldFieldType = getFieldType(messageConfig, field.getTypeName(), field.getTypeFullName());
            IFieldReader reader = getReader(Modifier2BuiltinType.of(modifier, fieldFieldType));
            String getValue = i("message.get${0}()", field.getFirstUpperFieldName());
            String setValue = "message.set%s(${value})".formatted(field.getFirstUpperFieldName());
            readBody.add(field.getDefinition()).newLine();
            readBody.add(i("case ${0}: ", field.getFieldNum())).add(JavaCodeUtil.LC).newLine();
            reader.read(this, readBody, messageConfig, field, getValue, setValue);
            readBody.add("break;").newLine();
            readBody.add(JavaCodeUtil.RC).newLine();
        }
        return readBody;
    }

    public String createEnumSchema(MessageConfig messageConfig, String outputDir) throws IOException {
        String pkg = messageConfig.getPkg();
        CodeStringBuilder header = new CodeStringBuilder();
        header.add(JavaCodeUtil.Package(pkg)).newLine(2);

        header.addImportMessage("io.protobj.core.Input");
        header.addImportMessage("io.protobj.core.Output");
        header.addImportMessage("io.protobj.core.Schema");
        header.addImportMessage("java.io.IOException");

        CodeStringBuilder writeBody = createEnumWriteBody(messageConfig, false);

        CodeStringBuilder writeWithFieldNumberBody = createEnumWriteBody(messageConfig, true);

        CodeStringBuilder readBody = createEnumReadBody(messageConfig);

        CodeStringBuilder body = new CodeStringBuilder();
        body.add(n(CodeTemplate.ENUM_SCHEMA, of(
                "class", messageConfig.getName(),
                "writeBody", writeBody.toString(),
                "writeWithFieldNumberBody", writeWithFieldNumberBody.toString(),
                "readBody", readBody.toString()
        ))).newLine();
        JavaCodeUtil.appendImportMessagesForJava(pkg, header);
        header.add(body);
        if (outputDir != null) {
            writeFile(type(), "%sSchema".formatted(messageConfig.getName()), outputDir, pkg, header.toString());
        }
        return header.toString();
    }

    private CodeStringBuilder createEnumReadBody(MessageConfig messageConfig) {
        CodeStringBuilder readBody = new CodeStringBuilder();
        readBody.setCurrent(2);
        readBody.add("int value = input.readI32();").newLine();
        readBody.add("switch (value) ").add(JavaCodeUtil.LC).newLine();
        for (FieldConfig value : messageConfig.getFieldConfigMap().values()) {
            readBody.add(i("case ${0}: ", value.getFieldNum())).add(JavaCodeUtil.LC).newLine();
            readBody.add(i("return ${0}.${1};", messageConfig.getName(), value.getFieldName())).newLine();
            readBody.add(JavaCodeUtil.RC).newLine();
        }
        readBody.add("default: ").add(JavaCodeUtil.LC).newLine();
        readBody.add("return null;").newLine();
        readBody.add(JavaCodeUtil.RC).newLine();
        readBody.add(JavaCodeUtil.RC).newLine();

        return readBody;
    }

    private CodeStringBuilder createEnumWriteBody(MessageConfig messageConfig, boolean withFieldNum) {
        CodeStringBuilder writeBody = new CodeStringBuilder();
        writeBody.setCurrent(2);
        writeBody.add(JavaCodeUtil.isNull("message")).add(JavaCodeUtil.LC).newLine();
        writeBody.add("output.writeI32(0);").newLine();
        writeBody.add("return;").newLine();
        writeBody.add(JavaCodeUtil.RC).newLine();
        writeBody.add("switch (message) ").add(JavaCodeUtil.LC).newLine();
        for (FieldConfig value : messageConfig.getFieldConfigMap().values()) {
            writeBody.add(i("case ${0}: ", value.getFieldName())).add(JavaCodeUtil.LC).newLine();
            if (withFieldNum) {
                writeBody.add(i("output.writeI32(fieldNum,${0});", value.getFieldNum())).newLine();
            } else {
                writeBody.add(i("output.writeI32(${0});", value.getFieldNum())).newLine();
            }
            writeBody.add("break;").newLine();
            writeBody.add(JavaCodeUtil.RC).newLine();
        }
        writeBody.add("default: ").add(JavaCodeUtil.LC).newLine();
        writeBody.add("throw new RuntimeException(\"undefine enum \" + message);").newLine();
        writeBody.add(JavaCodeUtil.RC).newLine();
        writeBody.add(JavaCodeUtil.RC).newLine();
        return writeBody;
    }

    private void createClass(MessageConfig messageConfig, String javaOutputDir) throws IOException {
        JavaMessageGenerator javaGenerator = new JavaMessageGenerator();
        switch (messageConfig.getType()) {
            case ENUM -> javaGenerator.createEnumClass(this, messageConfig, javaOutputDir);
            case MESSAGE -> javaGenerator.createMessageClass(this, messageConfig, javaOutputDir);
        }
    }


}
