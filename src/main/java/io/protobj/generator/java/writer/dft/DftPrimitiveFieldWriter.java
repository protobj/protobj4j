package io.protobj.generator.java.writer.dft;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;
import static java.util.Map.of;

public class DftPrimitiveFieldWriter implements IFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.DFT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Arrays.stream(FieldType.values())
                .filter(it -> it != FieldType.ENUM)
                .filter(it -> it != FieldType.MESSAGE)
                .filter(it -> it != FieldType.MAP)
                .collect(Collectors.toSet());
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody,
                      MessageConfig sourceMessage, FieldConfig fieldConfig,
                      String value) {
        FieldType fieldType = generator.getFieldType(sourceMessage, fieldConfig.getTypeName(), fieldConfig.getTypeName());
        if (fieldType == FieldType.BOOL) {
            value = i("message.is${0}()", fieldConfig.getFirstUpperFieldName());
        }
        Map<String, ?> params = of("type", fieldType.name(), "fieldNum", fieldConfig.getFieldNum(), "value", value);
        writeBody.add(isNotDefault(value, fieldType)).add(LC).newLine();
        writeBody.add(n("output.write${type}(${fieldNum}, ${value});", params)).newLine();
        writeBody.add(RC).newLine();

    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage,
                            FieldConfig fieldConfig, FieldType fieldType, String value) {
        Map<String, ?> params = of("type", fieldType.name(), "value", value);
        writeBody.add(n("output.write${type}(${value});", params)).newLine();
    }
}
