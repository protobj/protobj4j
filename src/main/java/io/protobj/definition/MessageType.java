package io.protobj.definition;

public enum MessageType {
    MESSAGE,
    ENUM,

    ;

    public FieldType toFieldType() {
        return switch (this) {
            case ENUM -> FieldType.ENUM;
            case MESSAGE -> FieldType.MESSAGE;
        };
    }
}
