package io.protobj.generator.java;

import io.protobj.definition.FieldType;
import io.protobj.generator.CodeStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.n;

public class JavaCodeUtil {

    public static final String LC = "{";
    public static final String RC = "}";
    public static final String IF = "if ";
    public static final String ELSE_IF = "} else if ";
    public static final String ELSE = "} else { ";
    public static final String CONTINUE = "continue;";

    public static final String LAMBDA = "() -> ";

    public static String notNull(String value) {
        return i("if (${0} != null) ", value);
    }

    public static String isNull(String value) {
        return i("if (${0} == null) ", value);
    }

    public static String collectionNotEmpty(String value) {
        return n("if (${value} != null && ${value}.size() > 0) ", "value", value);
    }

    public static String arrayNotEmpty(String value) {
        return n("if (${value} != null && ${value}.length > 0) ", "value", value);
    }

    public static String stringNotEmpty(String value) {
        return n("if (${value} != null && ${value}.length() > 0) ", "value", value);
    }

    public static String isNull(String value1, String value2) {
        return i("if (${0} == null || ${1} == null)", value1, value2);
    }

    public static String classEquals(String object, String Class) {
        return i("(${0}.getClass() == ${1}.class) ", object, Class);
    }

    public static String Package(String pkg) {
        return i("package ${0};", pkg);
    }

    public static void appendImportMessagesForJava(String sourcePackage, CodeStringBuilder header) {
        List<String> importList = distinctPackageForJava(sourcePackage, header.getImportMessages());
        String javaCoreLibPrefix = "java.";
        importList.sort((o1, o2) -> {
            if (o1.startsWith(javaCoreLibPrefix) && !o2.startsWith(javaCoreLibPrefix)) {
                return 1;
            }
            if (o2.startsWith(javaCoreLibPrefix) && !o1.startsWith(javaCoreLibPrefix)) {
                return -1;
            }
            return o1.compareToIgnoreCase(o2);
        });
        boolean importCoreLib = false;

        for (int i = 0; i < importList.size(); i++) {
            if (importList.get(i).startsWith(javaCoreLibPrefix) && !importCoreLib) {
                if (i != 0) {
                    header.newLine();
                }
                importCoreLib = true;
            }
            header.add(i("import ${0};", importList.get(i))).newLine();
        }
        header.newLine();
    }

    private static List<String> distinctPackageForJava(String pkg, Set<String> importMessages) {
        List<String> importList = new ArrayList<>();
        for (String importMessage : importMessages) {
            int i = importMessage.lastIndexOf(".");
            if (i < 0) {
                importList.add(importMessage);
                continue;
            }
            if (!importMessage.substring(0, i).equals(pkg)) {
                importList.add(importMessage);
            }

        }
        return importList;
    }

    public static String readMessageStart() {
        return "final int oldLimit = input.readMessageStart();";
    }

    public static String readMessageStop() {
        return "input.readMessageStop(oldLimit);";
    }

    public static String isNotDefault(String value, FieldType fieldFieldType) {
        return switch (fieldFieldType) {
            case BOOL -> n("if (${value} != false) ", "value", value);
            case STRING -> notNull(value);
            default -> n("if (${value} != 0) ", "value", value);
        };
    }
}
