package io.protobj.generator.java.reader.dft;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;

import java.util.Set;

import static io.protobj.generator.GeneratorUtils.n;

public class DftEnumFieldReader extends DftMessageFieldReader {

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.ENUM
        );
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        String value = readPacked0(readBody, fieldConfig.getTypeName(), fieldConfig.getTypeFullName());
        readBody.add(n(setValue, "value", value)).add(";").newLine();
    }

    @Override
    public String readPacked(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType) {
        return readPacked0(readBody, fieldConfig.getMessageName(), fieldConfig.getMessageFullName());
    }
}
