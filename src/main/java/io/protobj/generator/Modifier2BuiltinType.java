package io.protobj.generator;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;

public record Modifier2BuiltinType(Modifier modifier, FieldType fieldType) {

    public static Modifier2BuiltinType of(Modifier modifier, FieldType fieldType) {
        return new Modifier2BuiltinType(modifier, fieldType);
    }
}
