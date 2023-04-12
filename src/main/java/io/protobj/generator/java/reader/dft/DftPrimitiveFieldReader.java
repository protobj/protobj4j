package io.protobj.generator.java.reader.dft;

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

public class DftPrimitiveFieldReader implements IFieldReader {
    @Override
    public Modifier modifier() {
        return Modifier.DFT;
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
        String value = readPacked(generator, readBody, sourceMessage, fieldConfig, fieldType);
        readBody.add(n(setValue, "value", value)).add(";").newLine();
    }

    @Override
    public String readPacked(AGenerator generator, CodeStringBuilder readBody,
                             MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType) {
        return i("input.read${0}()", fieldType.name());
    }
}
