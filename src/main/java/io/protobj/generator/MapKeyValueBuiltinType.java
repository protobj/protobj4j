package io.protobj.generator;

import io.protobj.definition.FieldType;

public record MapKeyValueBuiltinType(FieldType keyType, FieldType valueType) {


    public static MapKeyValueBuiltinType of(FieldType keyType, FieldType valueType) {
        return new MapKeyValueBuiltinType(keyType, valueType);
    }

}
