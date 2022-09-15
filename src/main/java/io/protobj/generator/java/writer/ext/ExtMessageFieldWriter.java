package io.protobj.generator.java.writer.ext;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldWriter;

import java.util.Map;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.n;


public class ExtMessageFieldWriter implements IFieldWriter {
    @Override
    public Modifier modifier() {
        return Modifier.EXT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.MESSAGE
        );
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {
        writeBody.add(n("output.writeMessage(${fieldNum}, () -> ${typeName}Schema.writeTo(output, message,false));",
                Map.of("fieldNum", fieldConfig.getFieldNum(), "typeName", fieldConfig.getTypeName()))).newLine();
        String typeFullName = fieldConfig.getTypeFullName();
        writeBody.addImportMessage(i("${0}Schema", typeFullName));
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value) {
        throw new UnsupportedOperationException();
    }
}
