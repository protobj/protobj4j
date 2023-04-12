package io.protobj.generator.java.writer.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.n;
import static io.protobj.generator.java.JavaCodeUtil.*;

public class Primitive2PrimitiveMapFieldWriter implements IMapFieldWriter {

    @Override
    public Set<MapKeyValueBuiltinType> focusTypes() {
        Set<MapKeyValueBuiltinType> focusTypes = new HashSet<>();
        for (FieldType keyType : FieldType.values()) {

            if (unsupportedKeyType().contains(keyType)) {
                continue;
            }
            for (FieldType valueType : FieldType.values()) {
                if (unsupportedValueType().contains(valueType)) {
                    continue;
                }
                if (valueType == FieldType.MESSAGE
                        || valueType == FieldType.ENUM
                ) {
                    continue;
                }
                focusTypes.add(MapKeyValueBuiltinType.of(keyType, valueType));
            }
        }
        return focusTypes;
    }

    @Override
    public void write(AGenerator generator, CodeStringBuilder writeBody,
                      MessageConfig sourceMessage, FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueType, String value) {
        writeBody.add(collectionNotEmpty(value)).add(LC).newLine();
        Map<String, ?> params = Map.of(
                "keyType", keyValueType.keyType().name(),
                "valueType", keyValueType.valueType().name(),
                "fieldNumber", fieldConfig.getFieldNum(),
                "value", value
        );
        writeBody.add(n("output.write${keyType}${valueType}Map(${fieldNumber}, ${value});", params)).newLine();
        writeBody.add(RC).newLine();
    }
}
