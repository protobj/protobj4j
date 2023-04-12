package io.protobj.generator.java.writer.set;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.Modifier2BuiltinType;
import io.protobj.generator.IFieldWriter;
import io.protobj.generator.java.JavaCodeUtil;

import java.util.Map;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.n;
import static java.util.Map.of;

public class SetMessageFieldWriter implements IFieldWriter {


    @Override
    public Modifier modifier() {
        return Modifier.SET;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(getBuiltinType());
    }

    public FieldType getBuiltinType(){
        return FieldType.MESSAGE;
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage,
                      FieldConfig fieldConfig, String value) {
        writeBody.add(JavaCodeUtil.collectionNotEmpty(value)).add(JavaCodeUtil.LC).newLine();
        Map<String, String> params = of("typeName", fieldConfig.getTypeName(), "fieldName", fieldConfig.getFieldName(), "value", value);
        writeBody.add(n("for(${typeName} ${fieldName}Unit : ${value}){",
                params)).newLine();
        value = n("${fieldName}Unit", params);
        IFieldWriter writer = generator.getWriter(Modifier2BuiltinType.of(Modifier.DFT, getBuiltinType()));
        writer.write(generator, writeBody, sourceMessage, fieldConfig, value);
        writeBody.add(JavaCodeUtil.RC).newLine();
        writeBody.add(JavaCodeUtil.RC).newLine();
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage,
                            FieldConfig fieldConfig, FieldType fieldType, String value) {
        throw new UnsupportedOperationException();
    }
}
