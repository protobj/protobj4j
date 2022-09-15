package io.protobj.generator.java.writer.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.writer.set.SetPrimitiveFieldWriter;

public class LstPrimitiveFieldWriter extends SetPrimitiveFieldWriter {
    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

    @Override
    protected String suffix() {
        return "List";
    }
}
