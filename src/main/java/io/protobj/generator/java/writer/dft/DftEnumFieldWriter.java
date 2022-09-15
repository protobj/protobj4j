package io.protobj.generator.java.writer.dft;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldWriter;

import java.util.Set;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class DftEnumFieldWriter implements IFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.DFT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.ENUM
        );
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {
        writeBody.add(notNull(value)).add(LC).newLine();
        writeBody.addImportMessage(fieldConfig.getTypeFullName());
        writeBody.addImportMessage(fieldConfig.getTypeFullName() + "Schema");
        writeBody.add(i("${1}Schema.writeWithFieldNumber(${0}, output, ${2});"
                , fieldConfig.getFieldNum(), fieldConfig.getTypeName(), value)).newLine();
        writeBody.add(RC).newLine();
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value) {
        String messageName = fieldConfig.getMessageName();
        writeBody.addImportMessage(fieldConfig.getMessageFullName());
        writeBody.addImportMessage(fieldConfig.getMessageFullName() + "Schema");
        writeBody.add(i("${0}Schema.writeTo(output, ${1}, false);", messageName, value)).newLine();
    }
}
