package io.protobj.generator.java.reader.arr;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.reader.set.SetPrimitiveFieldReader;

public class ArrPrimitiveFieldReader extends SetPrimitiveFieldReader {


    @Override
    public Modifier modifier() {
        return Modifier.ARR;
    }

    @Override
    protected String readSuffix() {
        return "Array";
    }
}
