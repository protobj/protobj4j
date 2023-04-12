package io.protobj.generator.java.reader.dft;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.IFieldReader;
import io.protobj.generator.MapKeyValueBuiltinType;
import io.protobj.generator.java.reader.dft.map.IMapFieldReader;
import io.protobj.generator.java.reader.dft.map.Primitive2MessageMapFieldReader;
import io.protobj.generator.java.reader.dft.map.Primitive2PrimitiveMapFieldReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DftMapFieldReader implements IFieldReader {


    private final Map<MapKeyValueBuiltinType, IMapFieldReader> mapFieldReaderMap = new HashMap<>();

    public DftMapFieldReader() {

        addFieldWriterReader(new Primitive2MessageMapFieldReader());
        addFieldWriterReader(new Primitive2PrimitiveMapFieldReader());
    }


    private void addFieldWriterReader(IMapFieldReader mapFieldReader) {
        for (MapKeyValueBuiltinType focusType : mapFieldReader.focusTypes()) {
            IMapFieldReader mapFieldWriter = mapFieldReaderMap.put(focusType, mapFieldReader);
            if (mapFieldWriter != null) {
                throw new RuntimeException(" mapFieldReader duplicated %s".formatted(focusType));
            }
        }
    }

    @Override
    public Modifier modifier() {
        return Modifier.DFT;
    }

    @Override
    public Set<FieldType> focusTypes() {
        return Set.of(
                FieldType.MAP
        );
    }

    @Override
    public void read(AGenerator generator, CodeStringBuilder readBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String getValue, String setValue) {
        FieldType keyType = generator.getFieldType(sourceMessage, fieldConfig.getKeyType(), fieldConfig.getKeyType());
        FieldType valueType = generator.getFieldType(sourceMessage, fieldConfig.getValueTypeName(), fieldConfig.getValueTypeFullName());
        MapKeyValueBuiltinType keyValueBuiltinType = MapKeyValueBuiltinType.of(keyType, valueType);
        IMapFieldReader mapFieldWriter = mapFieldReaderMap.get(keyValueBuiltinType);
        if (mapFieldWriter == null) {
            throw new UnsupportedOperationException("unsupported Map<%s,%s>".formatted(keyType, valueType));
        }
        mapFieldWriter.read(generator, readBody, sourceMessage, fieldConfig, keyValueBuiltinType, getValue, setValue);
    }

}
