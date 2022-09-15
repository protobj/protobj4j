package io.protobj.generator.java;

import io.protobj.definition.FieldType;
import io.protobj.generator.CodeStringBuilder;

import static io.protobj.generator.GeneratorUtils.firstUpper;

/**
 * @auther chenqiang
 * @date 2022/8/29
 */
class BuiltinTypeLibGenerator {

    public static void main(String[] args) {
//        createMapWriteInterface();
//        createMapWriteImpl();
//        createMapReadInterface();
        createMapReadImpl();
    }

    private static void createMapReadImpl() {
        String template = "public %s read%s%sMap() throws IOException {";
        for (FieldType keyType : FieldType.values()) {
            if (keyType == FieldType.MAP || keyType == FieldType.BOOL || keyType == FieldType.ENUM || keyType == FieldType.MESSAGE) {
                continue;
            }
            for (FieldType valueType : FieldType.values()) {
                if (valueType == FieldType.MAP || valueType == FieldType.ENUM || valueType == FieldType.MESSAGE) {
                    continue;
                }
                CodeStringBuilder stringBuilder = new CodeStringBuilder();
                stringBuilder.setCurrent(1);

                String keyJavaTypeUpper = firstUpper(keyType.javaType);
                String valueJavaTypeUpper = firstUpper(valueType.javaType);
                if (keyType == FieldType.STRING && valueType != FieldType.STRING) {
                    String mapType = "Object2%sMap<String>".formatted(firstUpper(valueType.javaType));
                    stringBuilder.add(template.formatted(mapType, keyType.name(), valueType.name())).newLine();
                    stringBuilder.add("checkIfPackedField();").newLine();
                    stringBuilder.add("%s value = new Object2%sOpenHashMap<String>();".formatted(mapType, valueJavaTypeUpper)).newLine();
                } else if (keyType == FieldType.STRING) {
                    stringBuilder.add(template.formatted("Map<String,String>", keyType.name(), valueType.name())).newLine();
                    stringBuilder.add("checkIfPackedField();").newLine();
                    stringBuilder.add("%s value = new HashMap<String,String>();".formatted("Map<String,String>")).newLine();
                } else if (valueType == FieldType.STRING) {
                    String mapType = "%s2ObjectMap<String>".formatted(firstUpper(keyType.javaType));
                    stringBuilder.add(template.formatted(mapType, keyType.name(), valueType.name())).newLine();
                    stringBuilder.add("checkIfPackedField();").newLine();
                    stringBuilder.add("%s value = new %s2ObjectOpenHashMap<String>();".formatted(mapType, keyJavaTypeUpper)).newLine();
                } else {
                    stringBuilder.add(template.formatted("%s2%sMap".formatted(firstUpper(keyType.javaType), firstUpper(valueType.javaType)), keyType.name(), valueType.name())).newLine();
                    stringBuilder.add("checkIfPackedField();").newLine();
                    stringBuilder.add("%s2%sMap value = new %s2%sOpenHashMap();".formatted(keyJavaTypeUpper, valueJavaTypeUpper, keyJavaTypeUpper, valueJavaTypeUpper)).newLine();
                }
                stringBuilder.add("do ").add(JavaCodeUtil.LC).newLine();
                stringBuilder.add("value.put(read%s_NoCheck(),read%s_NoCheck());".formatted(keyType.name(), valueType.name())).newLine();
                stringBuilder.add(JavaCodeUtil.RC).add(" while(offset < packedLimit);").newLine();
                stringBuilder.add("return value;").newLine();
                stringBuilder.add(JavaCodeUtil.RC).newLine();
                System.err.println(stringBuilder.toString());
            }
        }
    }

    private static void createMapReadInterface() {
        String template = "%s read%s%sMap() throws IOException;%n";
        for (FieldType keyType : FieldType.values()) {
            if (keyType == FieldType.MAP || keyType == FieldType.BOOL) {
                continue;
            }
            for (FieldType valueType : FieldType.values()) {
                if (valueType == FieldType.MAP) {
                    continue;
                }

                if (keyType == FieldType.STRING && valueType != FieldType.STRING) {
                    System.out.printf(template, "Object2%sMap<String>".formatted(firstUpper(valueType.javaType)), keyType.name(), valueType.name());
                } else if (keyType == FieldType.STRING) {
                    System.out.printf(template, "Map<String,String>", keyType.name(), valueType.name());
                } else if (valueType == FieldType.STRING) {
                    System.out.printf(template, "%s2ObjectMap<String>".formatted(firstUpper(keyType.javaType)), keyType.name(), valueType.name());
                } else {
                    System.out.printf(template, "%s2%sMap".formatted(firstUpper(keyType.javaType), firstUpper(valueType.javaType)), keyType.name(), valueType.name());
                }


            }
        }
    }

    private static void createMapWriteImpl() {

        String template = "public void write%s%sMap(int fieldNumber, %s value) throws IOException {";
        for (FieldType keyType : FieldType.values()) {
            if (keyType == FieldType.MAP || keyType == FieldType.BOOL) {
                continue;
            }
            for (FieldType valueType : FieldType.values()) {
                if (valueType == FieldType.MAP) {
                    continue;
                }
                CodeStringBuilder stringBuilder = new CodeStringBuilder();
                stringBuilder.setCurrent(1);
                String keyJavaTypeUpper = firstUpper(keyType.javaType);
                String valueJavaTypeUpper = firstUpper(valueType.javaType);
                if (keyType == FieldType.STRING && valueType != FieldType.STRING) {
                    stringBuilder.add(template.formatted(keyType.name(), valueType.name(), "Object2%sMap<String>".formatted(valueJavaTypeUpper))).newLine();
                    stringBuilder.add("writeMessage(fieldNumber, ").add(JavaCodeUtil.LAMBDA).add(JavaCodeUtil.LC).newLine();
                    stringBuilder.add("for (Object2%sMap.Entry<String> entry : value.object2%sEntrySet()) {".formatted(valueJavaTypeUpper, valueJavaTypeUpper)).newLine();
                    stringBuilder.add("write%s(entry.getKey());".formatted(keyType.name())).newLine();
                    stringBuilder.add("write%s(entry.get%sValue());".formatted(valueType.name(), valueJavaTypeUpper)).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                } else if (keyType == FieldType.STRING) {
                    stringBuilder.add(template.formatted(keyType.name(), valueType.name(), "Map<String,String>")).newLine();
                    stringBuilder.add("writeMessage(fieldNumber, ").add(JavaCodeUtil.LAMBDA).add(JavaCodeUtil.LC).newLine();
                    stringBuilder.add("for (Map.Entry<String,String> entry : value.entrySet()) {").newLine();
                    stringBuilder.add("write%s(entry.getKey());".formatted(keyType.name())).newLine();
                    stringBuilder.add("write%s(entry.getValue());".formatted(valueType.name())).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                } else if (valueType == FieldType.STRING) {
                    stringBuilder.add(template.formatted(keyType.name(), valueType.name(), "%s2ObjectMap<String>".formatted(keyJavaTypeUpper))).newLine();
                    stringBuilder.add("writeMessage(fieldNumber, ").add(JavaCodeUtil.LAMBDA).add(JavaCodeUtil.LC).newLine();
                    stringBuilder.add("for (%s2ObjectMap.Entry<String> entry : value.%s2ObjectEntrySet()) {".formatted(keyJavaTypeUpper, keyType.javaType)).newLine();
                    stringBuilder.add("write%s(entry.get%sKey());".formatted(keyType.name(), keyJavaTypeUpper)).newLine();
                    stringBuilder.add("write%s(entry.getValue());".formatted(valueType.name())).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                } else {
                    stringBuilder.add(template.formatted(keyType.name(), valueType.name(), "%s2%sMap".formatted(keyJavaTypeUpper, valueJavaTypeUpper))).newLine();
                    stringBuilder.add("writeMessage(fieldNumber, ").add(JavaCodeUtil.LAMBDA).add(JavaCodeUtil.LC).newLine();
                    stringBuilder.add("for (%s2%sMap.Entry entry : value.%s2%sEntrySet()) ".formatted(keyJavaTypeUpper, valueJavaTypeUpper, keyType.javaType, valueJavaTypeUpper)).add(JavaCodeUtil.LC).newLine();
                    stringBuilder.add("write%s(entry.get%sKey());".formatted(keyType.name(), keyJavaTypeUpper)).newLine();
                    stringBuilder.add("write%s(entry.get%sValue());".formatted(valueType.name(), valueJavaTypeUpper)).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                    stringBuilder.add(JavaCodeUtil.RC).newLine();
                }
                stringBuilder.add("}%n").newLine();
                System.err.println(stringBuilder.toString());
            }
        }
    }

    private static void createMapWriteInterface() {
        String template = "void write%s%sMap(int fieldNumber, %s value) throws IOException;%n";
        for (FieldType keyType : FieldType.values()) {
            if (keyType == FieldType.MAP || keyType == FieldType.BOOL) {
                continue;
            }
            for (FieldType valueType : FieldType.values()) {
                if (valueType == FieldType.MAP) {
                    continue;
                }
                if (keyType == FieldType.STRING && valueType != FieldType.STRING) {
                    System.out.printf(template, keyType.name(), valueType.name(), "Object2%sMap<String>".formatted(firstUpper(valueType.javaType)));
                } else if (keyType == FieldType.STRING) {
                    System.out.printf(template, keyType.name(), valueType.name(), "Map<String,String>");
                } else if (valueType == FieldType.STRING) {
                    System.out.printf(template, keyType.name(), valueType.name(), "%s2ObjectMap<String>".formatted(firstUpper(keyType.javaType)));
                } else {
                    System.out.printf(template, keyType.name(), valueType.name(), "%s2%sMap".formatted(firstUpper(keyType.javaType), firstUpper(valueType.javaType)));
                }
            }
        }
    }
}
