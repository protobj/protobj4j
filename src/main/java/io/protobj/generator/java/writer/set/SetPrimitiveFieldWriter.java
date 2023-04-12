package io.protobj.generator.java.writer.set;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldWriter;
import io.protobj.generator.java.JavaCodeUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static io.protobj.generator.GeneratorUtils.n;
import static java.util.Map.of;

public class SetPrimitiveFieldWriter implements IFieldWriter {
    @Override
    public Modifier modifier() {
        return Modifier.SET;
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
                      MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {
        writeBody.add(notNull(value)).add(JavaCodeUtil.LC).newLine();
        FieldType fieldType = generator.getFieldType(sourceMessage, fieldConfig.getTypeName(), fieldConfig.getTypeName());
        Map<String, ?> params = of("type", fieldType.name(), "suffix", suffix(),
                "fieldNum", fieldConfig.getFieldNum(), "value", value);
        writeBody.add(n("output.write${type}${suffix}(${fieldNum}, ${value});", params)).newLine();//
        writeBody.add(JavaCodeUtil.RC).newLine();
    }

    protected String notNull(String value) {
        return JavaCodeUtil.collectionNotEmpty(value);
    }

    protected String suffix() {
        return "Set";
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value) {
        throw new UnsupportedOperationException();
    }
}
