package io.protobj.generator.java.writer.dft;

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
import static io.protobj.generator.java.JavaCodeUtil.*;
import static java.util.Map.of;

public class DftMessageFieldWriter implements IFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.DFT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.MESSAGE
        );
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {

        writeBody.add(notNull(value)).add(LC).newLine();

        MessageConfig messageField = generator.findMessage(sourceMessage, fieldConfig.getTypeFullName());
        if (fieldConfig.isPolymorphic()) {
            int index = 0;
            for (MessageConfig field : messageField.getChildMessageConfigMap().values()) {
                writeBody.addImportMessage(field.getFullName());
                writeBody.addImportMessage(field.getFullName() + "Schema");
                String ifstr = index == 0 ? IF : ELSE_IF;
                index++;
                writeBody.add(ifstr).add(classEquals(value, field.getName())).add(LC).newLine();
                Map<String, ?> params = of("fieldNum", fieldConfig.getFieldNum(), "typeName", field.getName(), "value", value);
                if (field.getName().equals(fieldConfig.getTypeName())) {
                    writeBody.add(n("output.writeMessage(${fieldNum}, () -> ${typeName}Schema.writeTo(output, ${value}, true));"
                            , params)).newLine();
                } else {
                    writeBody.add(n("output.writeMessage(${fieldNum}, () -> ${typeName}Schema.writeTo(output, (${typeName})${value}, true));"
                            , params)).newLine();
                }
            }
            writeBody.add(ELSE).newLine();
            writeBody.add(i("throw new RuntimeException(\"undefine message\"+ ${0}.getClass().getName());", value));
            writeBody.add(RC).newLine();
        } else {
            writeBody.addImportMessage(fieldConfig.getTypeFullName());
            writeBody.addImportMessage(fieldConfig.getTypeFullName() + "Schema");
            writeBody.add(i("output.writeMessage(${0}, () -> ${1}Schema.writeTo(output, ${2}, false));"
                    , fieldConfig.getFieldNum(), fieldConfig.getTypeName(), value)).newLine();
        }

        writeBody.add(RC).newLine();
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value) {


        MessageConfig messageField = generator.findMessage(sourceMessage, fieldConfig.getMessageFullName());
        if (fieldConfig.isPolymorphic()) {
            int index = 0;
            for (MessageConfig field : messageField.getChildMessageConfigMap().values()) {
                writeBody.addImportMessage(field.getFullName());
                writeBody.addImportMessage(field.getFullName() + "Schema");
                String ifstr = index == 0 ? IF : ELSE_IF;
                index++;
                writeBody.add(ifstr).add(classEquals(value, field.getName())).add(LC).newLine();
                Map<String, String> params = of("typeName", field.getName(), "value", value);
                if (field.getName().equals(fieldConfig.getMessageName())) {
                    writeBody.add(n("${typeName}Schema.writeTo(output, ${value},true);"
                            , params)).newLine();
                } else {
                    writeBody.add(n("${typeName}Schema.writeTo(output, (${typeName})${value}, true);"
                            , params)).newLine();
                }
            }
            writeBody.add(ELSE).newLine();
            writeBody.add(i("throw new RuntimeException(\"undefine message\"+ ${0}.getClass().getName());", value));
            writeBody.add(RC).newLine();
        } else {
            writeBody.addImportMessage(messageField.getFullName());
            writeBody.addImportMessage(messageField.getFullName() + "Schema");
            writeBody.add(i("${0}Schema.writeTo(output, ${1}, false);"
                    , fieldConfig.getMessageName(), value)).newLine();
        }

    }
}
