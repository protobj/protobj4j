package io.protobj.generator.java.writer.dft;

import io.protobj.definition.FieldType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.AGenerator;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;
import io.protobj.generator.IFieldWriter;
import io.protobj.generator.java.writer.dft.map.IMapFieldWriter;
import io.protobj.generator.java.writer.dft.map.Primitive2MessageMapFieldWriter;
import io.protobj.generator.java.writer.dft.map.Primitive2PrimitiveMapFieldWriter;
import io.protobj.generator.java.writer.dft.map.String2MessageMapFieldWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DftMapFieldWriter implements IFieldWriter {

    private final Map<MapKeyValueBuiltinType, IMapFieldWriter> mapFieldWriterMap = new HashMap<>();

    public DftMapFieldWriter() {
        addFieldWriterWriter(new Primitive2MessageMapFieldWriter());
        addFieldWriterWriter(new Primitive2PrimitiveMapFieldWriter());
        addFieldWriterWriter(new String2MessageMapFieldWriter());
    }

    private void addFieldWriterWriter(IMapFieldWriter fieldWriter) {
        for (MapKeyValueBuiltinType focusType : fieldWriter.focusTypes()) {
            IMapFieldWriter mapFieldWriter = mapFieldWriterMap.put(focusType, fieldWriter);
            if (mapFieldWriter != null) {
                throw new RuntimeException(" mapFieldWriter duplicated %s".formatted(focusType));
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
    public void write(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, String value) {
        FieldType keyType = generator.getFieldType(sourceMessage, fieldConfig.getKeyType(), fieldConfig.getKeyType());
        FieldType valueType = generator.getFieldType(sourceMessage, fieldConfig.getValueTypeName(), fieldConfig.getValueTypeFullName());
        MapKeyValueBuiltinType keyValueBuiltinType = MapKeyValueBuiltinType.of(keyType, valueType);
        IMapFieldWriter mapFieldWriter = mapFieldWriterMap.get(keyValueBuiltinType);
        if (mapFieldWriter == null) {
            throw new UnsupportedOperationException("unsupported Map<%s,%s>".formatted(keyType, valueType));
        }
        mapFieldWriter.write(generator, writeBody, sourceMessage, fieldConfig, keyValueBuiltinType, value);
    }

    @Override
    public void writePacked(AGenerator generator, CodeStringBuilder writeBody, MessageConfig sourceMessage, FieldConfig fieldConfig, FieldType fieldType, String value) {
        throw new UnsupportedOperationException();
    }
}
