package io.protobj.generator.java.reader.lst;

import io.protobj.definition.Modifier;
import io.protobj.generator.CodeStringBuilder;
import io.protobj.generator.java.reader.set.SetEnumFieldReader;

public class LstEnumFieldReader extends SetEnumFieldReader {

    @Override
    public Modifier modifier() {
        return Modifier.LST;
    }

    @Override
    protected String New(CodeStringBuilder readBody, String fieldTypeName) {
        readBody.addImportMessage("java.util.ArrayList");
        return "new ArrayList<>()";
    }
}
