package io.protobj.generator;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;

import java.util.Set;

public interface IFieldReader {

    Modifier modifier();

    Set<FieldType> focusTypes();


    void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage,
              FieldConfig fieldConfig, String getValue, String setValue);

    default String readPacked(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage,
                    FieldConfig fieldConfig, FieldType fieldType){
        throw new UnsupportedOperationException();
    }
}
