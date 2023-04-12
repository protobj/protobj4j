package io.protobj.generator.java.writer.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;

import java.util.Set;

public interface IMapFieldWriter {

    Set<MapKeyValueBuiltinType> focusTypes();

    void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, MapKeyValueBuiltinType keyValueType, String value);

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
}
