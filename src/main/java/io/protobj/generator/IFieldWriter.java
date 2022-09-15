package io.protobj.generator;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;

import java.util.Set;

public interface IFieldWriter {
    Modifier modifier();

    Set<FieldType> focusTypes();

    void write(AGenerator generator, CodeStringBuilder writeBody,
               MessageConfig sourceMessage, FieldConfig fieldConfig, String value);

    void writePacked(AGenerator generator, CodeStringBuilder writeBody,
                     MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value);


}
