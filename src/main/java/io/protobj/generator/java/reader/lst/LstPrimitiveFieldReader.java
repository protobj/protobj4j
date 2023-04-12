package io.protobj.generator.java.reader.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.reader.set.SetPrimitiveFieldReader;

public class LstPrimitiveFieldReader extends SetPrimitiveFieldReader {

    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

    @Override
    protected String readSuffix() {
        return "List";
    }
}
