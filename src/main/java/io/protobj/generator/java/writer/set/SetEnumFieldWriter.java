package io.protobj.generator.java.writer.set;

import io.protobj.definition.FieldType;


public class SetEnumFieldWriter extends SetMessageFieldWriter {

    @Override
    public FieldType getBuiltinType() {
        return FieldType.ENUM;
    }
}
