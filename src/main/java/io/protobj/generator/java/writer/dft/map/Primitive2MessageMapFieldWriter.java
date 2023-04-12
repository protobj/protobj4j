package io.protobj.generator.java.writer.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.firstUpper;
import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;
import static java.util.Map.of;

public class Primitive2MessageMapFieldWriter implements IMapFieldWriter {
    @Override
    public Set<MapKeyValueBuiltinType> focusTypes() {
        Set<MapKeyValueBuiltinType> focusTypes = new HashSet<>();
        for (FieldType keyType : FieldType.values()) {

            if (unsupportedKeyType().contains(keyType)) {
                continue;
            }
            if (keyType == FieldType.STRING) {
                continue;
            }
            focusTypes.add(MapKeyValueBuiltinType.of(keyType, FieldType.MESSAGE));
            focusTypes.add(MapKeyValueBuiltinType.of(keyType, FieldType.ENUM));
        }
        return focusTypes;
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueType, String value) {

        writeBody.add(collectionNotEmpty(value)).add(LC).newLine();
        FieldType keyType = keyValueType.keyType();
        MapFieldParam mapFieldParam = getMapFieldParam(writeBody, fieldConfig, value, keyType);
        Map<String, String> params = of(
                "entrySetType", mapFieldParam.entrySetType(),
                "entrySetValue", mapFieldParam.entrySetValue()
        );
        writeBody.add(n("for(${entrySetType} entry : ${entrySetValue})", params)).add(LC).newLine();
        if (keyType == FieldType.STRING) {
            writeBody.add(isNull(mapFieldParam.keyValue(), mapFieldParam.valueValue())).add(LC).newLine();
        } else {
            writeBody.add(isNull(mapFieldParam.valueValue())).add(LC).newLine();
        }
        writeBody.add(CONTINUE).newLine();
        writeBody.add(RC).newLine();
        writeBody.add(n("output.writeMessage(${fieldNum},", of("fieldNum", fieldConfig.getFieldNum()))).add(LAMBDA).add(LC).newLine();

        IFieldWriter keyWriter = generator.getWriter(Modifier2BuiltinType.of(Modifier.DFT, keyType));
        keyWriter.writePacked(generator, writeBody, sourceMessage, fieldConfig, keyType, mapFieldParam.keyValue());

        IFieldWriter valueWriter = generator.getWriter(Modifier2BuiltinType.of(Modifier.DFT, keyValueType.valueType()));
        valueWriter.writePacked(generator, writeBody, sourceMessage, fieldConfig, keyValueType.valueType(), mapFieldParam.valueValue());
        writeBody.add(RC).add(");").newLine();
        writeBody.add(RC).newLine();
        writeBody.add(RC).newLine();
    }

    protected MapFieldParam getMapFieldParam(CodeStringBuilder writeBody, FieldConfig fieldConfig, String value, FieldType keyType) {
        writeBody.addImportMessage("it.unimi.dsi.fastutil.%ss.%s2ObjectMap".formatted(keyType.getJavaType(), firstUpper(keyType.getJavaType())));
        String keyJavaType = keyType.getJavaType();
        String KeyJavaType = firstUpper(keyJavaType);
        Map<String, ?> params = of(
                "KeyJavaType", KeyJavaType,
                "keyJavaType", keyJavaType,
                "valueType", fieldConfig.getValueTypeName(),
                "value", value
        );
        return MapFieldParam.of(
                n("${KeyJavaType}2ObjectMap.Entry<${valueType}>", params),
                n("${value}.${keyJavaType}2ObjectEntrySet()", params),
                n("entry.get${KeyJavaType}Key()", params),
                "entry.getValue()"
        );
    }
}
