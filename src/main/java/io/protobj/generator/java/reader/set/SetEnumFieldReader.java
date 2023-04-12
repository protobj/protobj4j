package io.protobj.generator.java.reader.set;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldReader;
import io.protobj.generator.Modifier2BuiltinType;

import java.util.Set;

import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class SetEnumFieldReader implements IFieldReader {


    @Override
    public Modifier modifier() {
        return Modifier.SET;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.ENUM
        );
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        readBody.add(isNull(getValue)).add(LC).newLine();
        readBody.add(n(setValue, "value", New(readBody, fieldConfig.getTypeName()))).add(";").newLine();
        readBody.add(RC).newLine();
        IFieldReader reader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, FieldType.ENUM));
        String value = reader.readPacked(generator, readBody, sourceMessage, fieldConfig, FieldType.ENUM);
        readBody.add(n("${getValue}.add(${value});", "getValue", getValue, "value", value)).add(";").newLine();

    }

    protected String New(CodeStringBuilder readBody, String fieldTypeName) {
        readBody.addImportMessage("java.util.EnumSet");
        return "EnumSet.noneOf(%s.class)".formatted(fieldTypeName);
    }
}
