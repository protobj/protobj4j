package io.protobj.generator;

import io.protobj.config.LanguageType;
import io.protobj.definition.FieldType;
import io.protobj.definition.config.MessageConfig;
import io.protobj.config.Config;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


public abstract class AGenerator {

    protected final Map<String, MessageConfig> messageConfigMap;

    protected final Config config;

    public AGenerator(Map<String, MessageConfig> messageConfigMap, Config config) {
        this.messageConfigMap = messageConfigMap;
        this.config = config;
    }

    public MessageConfig findMessage(MessageConfig source, String messageFullName) {
        if (messageFullName == null) {
            throw new RuntimeException("message not found:%s in %s:%s".formatted("null", source.getFileName(), source.getName()));
        }
        MessageConfig messageConfig = messageConfigMap.get(messageFullName);
        if (messageConfig == null) {
            throw new RuntimeException("message not found:%s in %s:%s".formatted(messageFullName, source.getFileName(), source.getName()));
        }
        return messageConfig;
    }

    public FieldType getFieldType(MessageConfig sourceMessage, String typeName, String typeFullName) {
        FieldType fieldType = FieldType.getBuiltinType(typeName);
        if (fieldType != null) {
            return fieldType;
        }
        return findMessage(sourceMessage, typeFullName).getType().toFieldType();
    }

    public abstract LanguageType type();

    public abstract CompletableFuture<?> generate() throws IOException;

    public abstract IFieldWriter getWriter(Modifier2BuiltinType modifier2BuiltinType);

    public abstract IFieldReader getReader(Modifier2BuiltinType modifier2BuiltinType);
}
