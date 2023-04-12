package io.protobj.generator.java.reader.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;

import java.util.Set;

public interface IMapFieldReader {

    Set<MapKeyValueBuiltinType> focusTypes();

    default Set<FieldType> unsupportedKeyType() {
        return Set.of(FieldType.MAP,
                FieldType.BOOL,
                FieldType.ENUM,
                FieldType.MESSAGE
        );
    }

    default Set<FieldType> unsupportedValueType() {
        return Set.of(FieldType.MAP);
    }

    void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage,
              FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueBuiltinType, String getValue, String setValue);
}
