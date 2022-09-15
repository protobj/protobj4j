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

public class SetMessageFieldReader implements IFieldReader {
    @Override
    public Modifier modifier() {
        return Modifier.SET;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.MESSAGE
        );
    }

    protected String New(CodeStringBuilder readBody) {
        readBody.addImportMessage("java.util.HashSet");
        return "new HashSet<>()";
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        readBody.add(isNull(getValue)).add(LC).newLine();
        readBody.add(n(setValue, "value", New(readBody))).add(";").newLine();
        readBody.add(RC).newLine();

        readBody.add(readMessageStart()).newLine();
        IFieldReader reader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, FieldType.MESSAGE));
        MessageConfig message = generator.findMessage(sourceMessage, fieldConfig.getMessageFullName());
        String value = reader.readPacked(generator, readBody, message, fieldConfig, null);
        setValue = n("${getValue}.add(${value})", "getValue", getValue, "value", value);
        readBody.add(setValue).add(";").newLine();
        readBody.add(readMessageStop()).newLine();
    }

}
