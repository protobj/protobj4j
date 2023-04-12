package io.protobj.generator.java.reader.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.*;

import java.util.HashSet;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.*;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class Primitive2MessageMapFieldReader implements IMapFieldReader {
    @Override
    public Set<MapKeyValueBuiltinType> focusTypes() {
        Set<MapKeyValueBuiltinType> focusTypes = new HashSet<>();
        for (FieldType keyType : FieldType.values()) {
            if (unsupportedKeyType().contains(keyType)) {
                continue;
            }
            focusTypes.add(MapKeyValueBuiltinType.of(keyType, FieldType.MESSAGE));
            focusTypes.add(MapKeyValueBuiltinType.of(keyType, FieldType.ENUM));
        }
        return focusTypes;
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueBuiltinType, String getValue, String setValue) {
        MessageConfig fieldMessage = generator.findMessage(sourceMessage, fieldConfig.getValueTypeFullName());

        readBody.add(isNull(getValue)).add(LC).newLine();
        FieldType keyType = keyValueBuiltinType.keyType();
        String newMap;
        if (keyType != FieldType.STRING) {
            readBody.addImportMessage(n("it.unimi.dsi.fastutil.${keyType}s.${KeyType}2ObjectOpenHashMap",
                    "keyType", keyType.getJavaType(), "KeyType", firstUpper(keyType.getJavaType())));
            newMap = n("new ${KeyType}2ObjectOpenHashMap<>()", "KeyType", firstUpper(keyType.getJavaType()));
        } else {
            readBody.addImportMessage("java.util.HashMap");
            newMap = "new HashMap<>()";
        }
        readBody.add(n(setValue, "value", newMap)).add(";").newLine();
        readBody.add(RC).newLine();

        readBody.add(readMessageStart()).newLine();
        IFieldReader keyReader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, keyType));
        String keyValue = keyReader.readPacked(generator, readBody, sourceMessage, fieldConfig, keyType);
        readBody.add(n("${keyType} key = ", "keyType", keyType.getJavaType())).add(keyValue).add(";").newLine();
        FieldType valueFieldType = fieldMessage.getType().toFieldType();
        IFieldReader valueReader = generator.getReader(Modifier2BuiltinType.of(Modifier.DFT, valueFieldType));
        String mapValueValue = valueReader.readPacked(generator, readBody, fieldMessage, fieldConfig, valueFieldType);
        readBody.add(getValue).add(i(".put(key, ${0});", mapValueValue)).newLine();
        readBody.add(readMessageStop()).newLine();
    }
}
