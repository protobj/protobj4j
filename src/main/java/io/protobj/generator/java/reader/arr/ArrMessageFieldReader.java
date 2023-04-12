package io.protobj.generator.java.reader.arr;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldReader;
import io.protobj.generator.Modifier2BuiltinType;

import java.util.Set;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class ArrMessageFieldReader implements IFieldReader {
    @Override
    public Modifier modifier() {
        return Modifier.ARR;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.MESSAGE
        );
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        readBody.add(readMessageStart()).newLine();
        read0(generator, readBody, sourceMessage, fieldConfig, getValue, setValue);
        readBody.add(readMessageStop()).newLine();
    }

    protected void read0(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage,
                         FieldConfig fieldConfig, String getValue, String setValue
    ) {
        IFieldReader indexReader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, FieldType.I32));
        String indexValue = indexReader.readPacked(generator, readBody, sourceMessage, fieldConfig, FieldType.I32);
        readBody.add("int index = ").add(indexValue).add(";").newLine();
        readBody.add(isNull(getValue)).add(LC).newLine();
        String instance = i("new ${0}[index + 1]", fieldConfig.getTypeName());
        readBody.add(n(setValue, "value", instance)).add(";").newLine();
        readBody.add(RC).newLine();
        String setArrValue = i("${0}[index] = ", getValue);

        IFieldReader reader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, FieldType.MESSAGE));
        MessageConfig message = generator.findMessage(sourceMessage, fieldConfig.getMessageFullName());
        String value = reader.readPacked(generator, readBody, message, fieldConfig, FieldType.MESSAGE);
        readBody.add(setArrValue).add(value).add(";").newLine();
    }

}
