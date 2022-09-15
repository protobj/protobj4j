package io.protobj.generator.java.reader.ext;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldReader;

import java.util.Set;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class ExtMessageFieldReader implements IFieldReader {
    @Override
    public Modifier modifier() {
        return Modifier.EXT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(FieldType.MESSAGE);
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        readBody.addImportMessage(sourceMessage.getFullName());
        readBody.addImportMessage("%sSchema".formatted(sourceMessage.getFullName()));
        readBody.add(readMessageStart()).newLine();
        readBody.add(i("${0}Schema.mergeFrom(input,message)", fieldConfig.getTypeName())).add(";").newLine();
        readBody.add(readMessageStop()).newLine();
    }
}
