package io.protobj.generator.java.writer.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.java.writer.set.SetMessageFieldWriter;

public class LstMessageFieldWriter extends SetMessageFieldWriter {

    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

}
