package io.protobj.generator.java.writer.arr;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.JavaCodeUtil;
import io.protobj.generator.java.writer.set.SetPrimitiveFieldWriter;

public class ArrPrimitiveFieldWriter extends SetPrimitiveFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.ARR;
    }

    @Override
    protected String suffix() {
        return "Array";
    }
    protected String notNull(String value) {
        return JavaCodeUtil.arrayNotEmpty(value);
    }
}
