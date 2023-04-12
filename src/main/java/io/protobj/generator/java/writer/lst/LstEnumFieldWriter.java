package io.protobj.generator.java.writer.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.writer.set.SetEnumFieldWriter;

public class LstEnumFieldWriter extends SetEnumFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

}
