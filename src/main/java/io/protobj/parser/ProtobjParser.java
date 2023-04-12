package io.protobj.parser;

import io.protobj.antlr.ProtobjBaseListener;
import io.protobj.definition.FieldType;
import io.protobj.definition.MessageType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.definition.option.BoolFieldOptionValue;
import io.protobj.definition.option.FieldOption;
import io.protobj.definition.option.FieldOptionValue;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.*;

public class ProtobjParser extends ProtobjBaseListener {
    private final String fileName;

    private String pkg;
    private final Set<String> importMessages;

    private final Map<String, MessageConfig> messageConfigMap;

    CommonTokenStream commonTokenStream;

    public ProtobjParser(String fileName, CommonTokenStream commonTokenStream) {
        this.fileName = fileName;
        this.commonTokenStream = commonTokenStream;
        this.messageConfigMap = new HashMap<>();
        this.importMessages = new HashSet<>();
    }

    @Override
    public void enterImportStatement(io.protobj.antlr.ProtobjParser.ImportStatementContext ctx) {
        String importMessage = ctx.getChild(1).getText();
        importMessages.add(importMessage);
    }

    @Override
    public void enterPackageStatement(io.protobj.antlr.ProtobjParser.PackageStatementContext ctx) {
        super.enterPackageStatement(ctx);
        pkg = ctx.getChild(1).getText();
    }

    @Override
    public void enterMessageDef(io.protobj.antlr.ProtobjParser.MessageDefContext ctx) {
        super.enterMessageDef(ctx);
        String messageName = ctx.messageName().getText();
        checkMessageName(ctx.messageName().start, messageName);
        MessageConfig messageConfig = new MessageConfig(fileName, this.importMessages, pkg,//
                MessageType.MESSAGE, messageName);

        String desc = getLeftDesc(ctx.getStart());
        messageConfig.setNote(desc);
        io.protobj.antlr.ProtobjParser.MessageIndexContext messageIndexContext = ctx.messageIndex();

        if (messageIndexContext != null) {
            String messageId = messageIndexContext.getText();
            try {
                int messageIndex = Integer.parseInt(messageId);
                messageConfig.setMessageIndex(messageIndex);
            } catch (NumberFormatException e) {
                printErrorAndExit(messageIndexContext.start, "message index not number :%s ".formatted(messageConfig.getFullName()));
            }
            if (messageConfig.getMessageIndex() < 0) {
                printErrorAndExit(messageIndexContext.start, "message index must gt 0 :%s".formatted(messageConfig.getFullName()));
            }
        }

        io.protobj.antlr.ProtobjParser.MessageBodyContext messageBodyContext = ctx.messageBody();
        for (io.protobj.antlr.ProtobjParser.MessageElementContext messageElementContext : messageBodyContext.messageElement()) {

            FieldConfig fieldConfig = null;
            if (messageElementContext.field() != null) {
                fieldConfig = parseField(messageConfig, messageElementContext.field());
            }
            if (messageElementContext.mapField() != null) {
                fieldConfig = parseMapField(messageConfig, messageElementContext.mapField());
            }
            if (messageElementContext.extendsField() != null) {
                fieldConfig = parseExtendField(messageConfig, messageElementContext.extendsField());
            }
            if (fieldConfig == null) {
                continue;
            }
            Token start = messageElementContext.start;
            putField(messageConfig, fieldConfig, start);
        }
        putMessage(messageConfig, ctx.start);
        exitsExtendField = null;
    }

    private void checkMessageName(Token token, String messageName) {
        if (FieldType.getBuiltinType(messageName) != null) {
            printErrorAndExit(token, "message name is builtin type");
        }
    }

    private void putField(MessageConfig messageConfig, FieldConfig fieldConfig, Token start) {
        long count = messageConfig.getFieldConfigMap().values().stream().filter(it -> //
                it.getFieldName().equals(fieldConfig.getFieldName())).count();
        if (count > 0) {
            printErrorAndExit(start, "field name duplicate :%s".formatted(fieldConfig.getFieldName()));
        }
        FieldConfig oldField = messageConfig.getFieldConfigMap().put(fieldConfig.getFieldNum(), fieldConfig);
        if (oldField != null) {
            printErrorAndExit(start, "field num duplicate: %d".formatted(fieldConfig.getFieldNum()));
        }
    }

    FieldConfig exitsExtendField;

    private FieldConfig parseExtendField(MessageConfig messageConfig, io.protobj.antlr.ProtobjParser.ExtendsFieldContext ctx) {
        if (ctx == null) {
            return null;
        }
        if (exitsExtendField != null) {
            printErrorAndExit(ctx.messageType().start, "[%s]消息体中存在多个extend字段[%s,%s]".formatted(messageConfig.getFullName(), exitsExtendField.getTypeName(), ctx.messageType().getText()));
            return null;
        }
        FieldConfig fieldConfig = new FieldConfig();
        boolean deprecated = parseOption(fieldConfig, ctx.fieldOptions());
        if (deprecated) {
            return null;
        }

        String desc = getRightDesc(ctx.SEMI().getSymbol());
        fieldConfig.setDescription(desc);
        fieldConfig.initDefinition(ctx);
        exitsExtendField = fieldConfig;
        fieldConfig.setModifier(Modifier.EXT);
        String messageType = ctx.messageType().getText();
        fieldConfig.setTypeName(messageType);
        fieldConfig.setFieldName(ctx.fieldName().getText());
        setFieldNum(ctx.fieldNumber().getStart(), ctx.fieldNumber().getText(), messageConfig, fieldConfig);

        return fieldConfig;
    }


    private void printErrorAndExit(Token start, String err) {
        int line = start.getLine();
        int charPositionInLine = start.getCharPositionInLine();
        System.err.printf("%s line[%d:%d] %s \n", fileName, line, charPositionInLine, err);
        System.exit(-1);
    }

    private FieldConfig parseMapField(MessageConfig messageConfig, io.protobj.antlr.ProtobjParser.MapFieldContext mapField) {
        if (mapField == null) {
            return null;
        }
        FieldConfig fieldConfig = new FieldConfig();
        boolean deprecated = parseOption(fieldConfig, mapField.fieldOptions());
        if (deprecated) {
            return null;
        }
        fieldConfig.setDescription(getRightDesc(mapField.SEMI().getSymbol()));
        fieldConfig.initDefinition(mapField);
        String keyType = mapField.mapType().keyType().getText();
        fieldConfig.setTypeName(FieldType.MAP.name().toLowerCase());
        fieldConfig.setKeyType(keyType);
        fieldConfig.setValueTypeName(mapField.mapType().type_().getText());
        fieldConfig.setFieldName(mapField.mapName().getText());
        setFieldNum(mapField.fieldNumber().getStart(), mapField.fieldNumber().getText(), messageConfig, fieldConfig);
        return fieldConfig;
    }

    private boolean parseOption(FieldConfig fieldConfig, io.protobj.antlr.ProtobjParser.FieldOptionsContext fieldOptionsContext) {
        if (fieldOptionsContext == null) {
            return false;
        }
        for (io.protobj.antlr.ProtobjParser.FieldOptionContext fieldOptionContext : fieldOptionsContext.fieldOption()) {
            String optionName = fieldOptionContext.optionName().getText();
            String optionValue = fieldOptionContext.constant().getText();
            try {
                FieldOption fieldOption = FieldOption.valueOf(optionName);
                FieldOptionValue parseValue = fieldOption.parse(optionValue);
                if (fieldOption == FieldOption.deprecated && ((BoolFieldOptionValue) parseValue).isValue()) {
                    return true;
                }
                if (fieldOption == FieldOption.polymorphic && !((BoolFieldOptionValue) parseValue).isValue()) {
                    continue;
                }
                fieldConfig.getOptions().put(fieldOption, parseValue);
            } catch (IllegalArgumentException e) {
                printErrorAndExit(fieldOptionContext.start, "err option :%s".formatted(optionName));
            }
        }
        return false;
    }

    private FieldConfig parseField(MessageConfig messageConfig, io.protobj.antlr.ProtobjParser.FieldContext field) {
        if (field == null) {
            return null;
        }
        FieldConfig fieldConfig = new FieldConfig();
        boolean deprecated = parseOption(fieldConfig, field.fieldOptions());
        if (deprecated) {
            return null;
        }

        fieldConfig.setModifier(Modifier.DFT);
        if (field.modifier() != null) {
            String modifier = field.modifier().getText();
            if (!modifier.isBlank()) {
                fieldConfig.setModifier(Modifier.valueOf(modifier.toUpperCase()));
            }
        }
        fieldConfig.setDescription(getRightDesc(field.SEMI().getSymbol()));
        fieldConfig.initDefinition(field);
        String type = field.type_().getText();
        fieldConfig.setTypeName(type);
        String fieldName = field.fieldName().getText();
        fieldConfig.setFieldName(fieldName);
        String fieldNumber = field.fieldNumber().getText();
        setFieldNum(field.fieldNumber().start, fieldNumber, messageConfig, fieldConfig);

        return fieldConfig;
    }

    private void setFieldNum(Token token, String fieldNumber, MessageConfig messageConfig, FieldConfig fieldConfig) {
        try {
            fieldConfig.setFieldNum(fieldNumber);
        } catch (Exception e) {
            printErrorAndExit(token, "field num not number %s".formatted(messageConfig.getFullName()));
        }
        int lower = messageConfig.getType() == MessageType.MESSAGE ? 0 : -1;
        if (fieldConfig.getFieldNum() <= lower) {
            printErrorAndExit(token, "field num must > %d in %s".formatted(lower, messageConfig.getFullName()));
        }
    }

    @Override
    public void enterEnumDef(io.protobj.antlr.ProtobjParser.EnumDefContext ctx) {

        String enumName = ctx.enumName().getText();
        checkMessageName(ctx.enumName().start, enumName);
        MessageConfig messageConfig = new MessageConfig(fileName, importMessages, pkg,//
                MessageType.ENUM, enumName);
        String desc = getLeftDesc(ctx.getStart());
        messageConfig.setNote(desc);
        for (io.protobj.antlr.ProtobjParser.EnumElementContext enumElementContext : ctx.enumBody().enumElement()) {
            io.protobj.antlr.ProtobjParser.EnumFieldContext enumFieldContext = enumElementContext.enumField();
            FieldConfig fieldConfig = new FieldConfig();
            setFieldNum(enumFieldContext.ident().start, enumFieldContext.intLit().getText(), messageConfig, fieldConfig);
            fieldConfig.setDescription(getRightDesc(enumFieldContext.SEMI().getSymbol()));
            fieldConfig.initDefinition(ctx);
            fieldConfig.setFieldName(enumFieldContext.ident().getText());
            putField(messageConfig, fieldConfig, enumFieldContext.start);
        }
        putMessage(messageConfig, ctx.start);
    }

    private String getLeftDesc(Token token) {
        int tokenIndex = token.getTokenIndex();
        List<Token> hiddenTokensToLeft = commonTokenStream.getHiddenTokensToLeft(tokenIndex, 2);
        String desc = null;
        if (hiddenTokensToLeft != null && hiddenTokensToLeft.size() > 0) {
            desc = hiddenTokensToLeft.get(0).getText().substring(2);
        }
        return desc;
    }

    private void putMessage(MessageConfig messageConfig, Token token) {
        MessageConfig old = messageConfigMap.put(messageConfig.getFullName(), messageConfig);
        if (old != null) {
            printErrorAndExit(token, "message def duplicate %s".formatted(old.getFullName()));
        }
    }

    private String getRightDesc(Token token) {
        int tokenIndex = token.getTokenIndex();
        List<Token> hiddenTokensToRight = commonTokenStream.getHiddenTokensToRight(tokenIndex, 2);
        String desc = null;
        if (hiddenTokensToRight != null) {
            desc = hiddenTokensToRight.get(0).getText().substring(2);
        }
        return desc;
    }

    public Map<String, MessageConfig> getMessageConfigMap() {
        return messageConfigMap;
    }
}
