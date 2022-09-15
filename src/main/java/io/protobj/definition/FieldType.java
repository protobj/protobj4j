package io.protobj.definition;

import java.util.HashMap;
import java.util.Map;

public enum FieldType {
    BOOL("boolean"),
    I8("byte"),
    U8("byte"),
    I16("short"),
    U16("short"),
    I32("int"),
    U32("int"),
    S32("int"),
    F32("int"),
    SF32("int"),
    I64("long"),
    U64("long"),
    S64("long"),
    F64("long"),
    SF64("long"),
    STRING("String"),
    DOUBLE("double"),
    FLOAT("float"),
    MAP,
    ENUM,
    MESSAGE;

    public String javaType;


    FieldType(String javaType) {
        this.javaType = javaType;
    }

    FieldType() {
    }

    public String getJavaType() {
        return javaType;
    }

    public String getType(){
        return this.name().toLowerCase();
    }

    final static Map<String, FieldType> typeStringMap = new HashMap<>();

    static {
        for (FieldType value : values()) {
            typeStringMap.put(value.name().toLowerCase(), value);
        }
    }

    public static FieldType getBuiltinType(String typeName) {
        return typeStringMap.get(typeName);
    }

    public static void main(String[] args) {
        for (FieldType value : FieldType.values()) {
            String name = value.name();
            String javaType = value.javaType;
            System.err.println("FieldTypeMap[\"%s\"] = FieldType{\"%s\", \"%s\", \"%s\"}".formatted(name,name,javaType,javaType));
        }
    }
}
