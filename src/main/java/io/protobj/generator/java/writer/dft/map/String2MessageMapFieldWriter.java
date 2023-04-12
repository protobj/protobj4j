package io.protobj.generator.java.writer.dft.map;

import io.protobj.definition.FieldType;
import io.protobj.definition.config.FieldConfig;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.MapKeyValueBuiltinType;

import java.util.Map;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.firstUpper;
import static io.protobj.generator.GeneratorUtils.n;
import static java.util.Map.of;

public class String2MessageMapFieldWriter extends Primitive2MessageMapFieldWriter {

    @Override
    public Set<MapKeyValueBuiltinType> focusTypes() {
        return Set.of(
                MapKeyValueBuiltinType.of(FieldType.STRING, FieldType.MESSAGE),
                MapKeyValueBuiltinType.of(FieldType.STRING, FieldType.ENUM)
        );
    }

    @Override
    protected MapFieldParam getMapFieldParam(CodeStringBuilder writeBody, FieldConfig fieldConfig, String value, FieldType keyType) {
        writeBody.addImportMessage("java.util.Map");
        String keyJavaType = keyType.getJavaType();
        String KeyJavaType = firstUpper(keyJavaType);
        Map<String, ?> params = of(
                "KeyJavaType", KeyJavaType,
                "keyJavaType", keyJavaType,
                "valueType", fieldConfig.getValueTypeName(),
                "value", value
        );
        return MapFieldParam.of(
                n("Map.Entry<${KeyJavaType},${valueType}>", params),
                n("${value}.entrySet()", params),
                "entry.getKey()",
                "entry.getValue()"
        );
    }
}
