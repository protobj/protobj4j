package io.protobj.generator.java.writer.arr;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldWriter;
import io.protobj.generator.Modifier2BuiltinType;

import java.util.Map;

import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;
import static io.protobj.generator.java.JavaCodeUtil.RC;
import static java.util.Map.of;


public class ArrEnumFieldWriter extends ArrMessageFieldWriter {

    @Override
    protected FieldType getBuiltinType() {
        return FieldType.ENUM;
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {
        FieldType fieldType = generator.getFieldType(sourceMessage, fieldConfig.getTypeName(), fieldConfig.getTypeFullName());
        writeBody.add(arrayNotEmpty(value)).add(LC).newLine();
        Map<String, String> params = of(
                "typeName", fieldConfig.getTypeName(),
                "fieldName", fieldConfig.getFieldName(),
                "value", value
        );
        writeBody.add(n("${typeName}[] ${fieldName} = ${value};", params)).newLine();
        writeBody.add(n("output.writeMessage(${fieldNum}, ", of("fieldNum", fieldConfig.getFieldNum()))).add(LAMBDA).add(LC).newLine();
        writeBody.add(n("for (int i = ${value}.length-1; i >= 0; i--) ", params)).add(LC).newLine();
        value = n("${fieldName}[i]", params);
        writeBody.add(isNull(value)).add(LC).newLine();
        writeBody.add(CONTINUE).newLine();
        writeBody.add(RC).newLine();

        IFieldWriter fieldWriter = generator.getWriter(Modifier2BuiltinType.of(Modifier.DFT, FieldType.I32));
        fieldWriter.writePacked(generator, writeBody, sourceMessage, fieldConfig, FieldType.I32, "i");

        fieldWriter = generator.getWriter(Modifier2BuiltinType.of(Modifier.DFT, getBuiltinType()));
        fieldWriter.writePacked(generator, writeBody, sourceMessage, fieldConfig, fieldType, value);

        writeBody.add(RC).newLine();
        writeBody.add(RC).add(");").newLine();
        writeBody.add(RC).newLine();
    }
}
