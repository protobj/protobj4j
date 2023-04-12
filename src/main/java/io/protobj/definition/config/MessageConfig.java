package io.protobj.definition.config;

import io.protobj.definition.MessageType;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.Set;

/**
 * @auther chenqiang
 * @date 2022/8/12
 */
public class MessageConfig {

    //消息所在文件
    private final String fileName;
    private final String pkg;
    private final Set<String> importMessages;
    private final MessageType type;
    private final String name;
    private String note;
    private int messageIndex = 0;
    private Int2ObjectMap<FieldConfig> fieldConfigMap = new Int2ObjectLinkedOpenHashMap<>();
    private Int2ObjectMap<MessageConfig> childMessageConfigMap;
    private MessageConfig extMessage;
    private FieldConfig extField;

    public MessageConfig(String fileName, Set<String> importMessages, String pkg//
            , MessageType type, String name
    ) {
        this.fileName = fileName;
        this.importMessages = importMessages;
        this.pkg = pkg;
        this.type = type;
        this.name = name;
    }

    public MessageType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(int messageIndex) {
        this.messageIndex = messageIndex;
    }

    public Int2ObjectMap<FieldConfig> getFieldConfigMap() {
        return fieldConfigMap;
    }

    public void setFieldConfigMap(Int2ObjectMap<FieldConfig> fieldConfigMap) {
        this.fieldConfigMap = fieldConfigMap;
    }


    public synchronized void addSelfToChildMap() {
        if (childMessageConfigMap == null) {
            childMessageConfigMap = new Int2ObjectOpenHashMap<>();
        }
        childMessageConfigMap.put(getMessageIndex(), this);
    }

    public synchronized void addChild(MessageConfig message) {

        if (messageIndex < 0) {
            throw new RuntimeException("parent message index must > 0 :%s".formatted(getFullName()));
        }

        if (childMessageConfigMap == null) {
            childMessageConfigMap = new Int2ObjectOpenHashMap<>();
        }
        if (message.getMessageIndex() <= messageIndex) {
            throw new RuntimeException("child index must gt parent index parent:%s child:%s".formatted(getMessageIndex(), message.getMessageIndex()));
        }
        MessageConfig old = childMessageConfigMap.put(message.getMessageIndex(), message);
        if (old != null) {
            throw new RuntimeException(" %s child has same index %s : %s".formatted(getFullName(), old.getFullName(), message.getMessageIndex()));
        }
        for (FieldConfig value : message.getFieldConfigMap().values()) {
            for (FieldConfig fieldConfig : fieldConfigMap.values()) {
                if (value.getFieldName().equals(fieldConfig.getFieldName())) {
                    throw new RuntimeException("same fieldName in child:%s".formatted(value.getFieldName()));
                }
            }
        }
        if (extMessage != null) {
            extMessage.addChild(message);
        }
    }

    public Int2ObjectMap<MessageConfig> getChildMessageConfigMap() {
        return childMessageConfigMap;
    }

    public void setChildMessageConfigMap(Int2ObjectMap<MessageConfig> childMessageConfigMap) {
        this.childMessageConfigMap = childMessageConfigMap;
    }

    public MessageConfig getExtMessage() {
        return extMessage;
    }

    public void setParent(MessageConfig parent, FieldConfig fieldConfig) {
        if (this.extMessage != null) {
            throw new RuntimeException(" modifier:[ext]  only has one in message: %s".formatted(getFullName()));
        }
        this.extMessage = parent;
        this.extField = fieldConfig;
        if (childMessageConfigMap != null) {
            for (MessageConfig value : childMessageConfigMap.values()) {
                this.extMessage.addChild(value);
            }
        }
    }

    public FieldConfig getExtField() {
        return extField;
    }

    public String getPkg() {
        return pkg;
    }

    public String getFullName() {
        return "%s.%s".formatted(pkg, name);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<String> getImportMessages() {
        return importMessages;
    }


    public String getFileName() {
        return fileName;
    }

}
