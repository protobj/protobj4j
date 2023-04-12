package io.protobj.generator.java.reader.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.java.reader.set.SetMessageFieldReader;

public class LstMessageFieldReader extends SetMessageFieldReader {

    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

    @Override
    protected String New(CodeStringBuilder readBody) {
        readBody.addImportMessage("java.util.ArrayList");
        return "new ArrayList<>()";
    }
}
