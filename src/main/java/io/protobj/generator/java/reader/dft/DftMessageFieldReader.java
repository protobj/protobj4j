package io.protobj.generator.java.reader.dft;

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

public class DftMessageFieldReader implements IFieldReader {
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
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        readBody.add(readMessageStart()).newLine();
        String packValue = readPacked(generator, readBody, sourceMessage, fieldConfig, null);
        readBody.add(n(setValue, "value", packValue)).add(";").newLine();
        readBody.add(readMessageStop()).newLine();
    }

    @Override
    public String readPacked(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType) {
        String messageName = fieldConfig.getMessageName();
        String messageFullName = fieldConfig.getMessageFullName();
        boolean polymorphic = fieldConfig.isPolymorphic();
        if (polymorphic) {
            IFieldReader reader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, FieldType.I32));
            readBody.add("int msgIndex = ").add(reader.readPacked(generator, readBody, sourceMessage, fieldConfig, FieldType.I32)).add(";").newLine();
            readBody.add(i("${0} packValue = null;", messageName)).newLine();
            readBody.add("switch(msgIndex) ").add(LC).newLine();
            for (MessageConfig polyMessage : sourceMessage.getChildMessageConfigMap().values()) {
                readBody.add(i("case ${0} :", polyMessage.getMessageIndex())).add(LC).newLine();
                readBody.add("packValue = ").add(readPacked0(readBody, polyMessage.getName(), polyMessage.getFullName())).add(";").newLine();
                readBody.add("break;").newLine();
                readBody.add(RC).newLine();
            }
            readBody.add("default: ").add(LC).newLine();
            readBody.add("input.handleUnknownPolymorphicField(msgIndex);").newLine();
            readBody.add("break;").newLine();
            readBody.add(RC).newLine();

            readBody.add(RC).newLine();
            return "packValue";
        } else {
            return readPacked0(readBody, messageName, messageFullName);
        }
    }

    protected String readPacked0(CodeStringBuilder readBody, String messageName, String messageFullName) {
        readBody.addImportMessage(messageFullName);
        readBody.addImportMessage(messageFullName + "Schema");
        return i("${0}Schema.mergeFrom(input,null)", messageName);
    }
}
