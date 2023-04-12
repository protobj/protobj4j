package io.protobj.definition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ForbiddenFieldName {

    public static Set<String> forbiddenWords = new HashSet<>();


    static {
//        String[] protobj = new String[]{"message", "enum", "arr", "set", "ext", "lst", "true", "false", "bool", "package", "import", "i8", "u8",
//                "i16", "u16", "s16", "f16", "sf16"};
//
//        String[] java = new String[]{"boolean", "byte", "char", "double", //
//                "false", "float", "int", "long", "new", "short", "true", "void", //
//                "instanceof", "break", "case", " catch", "continue", "default ", "do", //
//                " else", "for", "if", "return", "switch", "try", "while", " finally", //
//                "throw", "this", "super ", "abstract", "final", "native", "private", "protected", //
//                "public", "static", "synchronized", "transient", "volatile", "class", " extends",//
//                " implements", "interface", "package", "import", "throws"};
//        forbiddenWords.addAll(Arrays.stream(java).map(String::trim).toList());
//
//        String typescript = "break\tas\tcatch\tswitch\n" + "case\tif\tthrow\telse\n" + "var\tnumber\tstring\tget\n" + "module\ttype\tinstanceof\ttypeof\n" + "public\tprivate\tenum\texport\n" + "finally\tfor\twhile\tvoid\n" + "null\tsuper\tthis\tnew\n" + "in\treturn\ttrue\tfalse\n" + "any\textends\tstatic\tlet\n" + "package\timplements\tinterface\tfunction\n" + "new\ttry\tyield\tconst\n" + "continue\tdo\n";
//        forbiddenWords.addAll(Arrays.stream(typescript.replaceAll("\n", "").split("\t")).map(String::trim).toList());

    }
}
