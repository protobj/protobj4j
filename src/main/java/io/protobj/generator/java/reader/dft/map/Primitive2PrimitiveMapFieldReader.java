package io.protobj.generator.java.reader.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;

import java.util.HashSet;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.n;

public class Primitive2PrimitiveMapFieldReader implements IMapFieldReader {


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
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueBuiltinType, String getValue, String setValue) {
        FieldType keyType = keyValueBuiltinType.keyType();
        FieldType valueType = keyValueBuiltinType.valueType();
        String mapValue = n("input.read${keyType}${valueType}Map()", "keyType", keyType.name(), "valueType", valueType.name());
        readBody.add(n(setValue, "value", mapValue)).add(";").newLine();
    }
}
