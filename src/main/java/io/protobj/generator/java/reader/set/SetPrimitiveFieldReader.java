package io.protobj.generator.java.reader.set;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.n;

public class SetPrimitiveFieldReader implements IFieldReader {
    @Override
    public Modifier modifier() {
        return Modifier.SET;
    }

    protected String readSuffix() {
        return "Set";
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Arrays
                .stream(FieldType.values())
                .filter(it -> it != FieldType.MAP)
                .filter(it -> it != FieldType.ENUM)
                .filter(it -> it != FieldType.MESSAGE)
                .collect(Collectors.toSet());
    }


    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        FieldType fieldType = generator.getFieldType(sourceMessage, fieldConfig.getTypeName(), fieldConfig.getTypeName());
        String value = i("input.read${0}${1}()", fieldType.name(), readSuffix());
        readBody.add(n(setValue, "value", value)).add(";").newLine();
    }
}
