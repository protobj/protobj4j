package io.protobj.generator.java;

import io.protobj.definition.FieldType;
import io.protobj.definition.MessageType;
import io.protobj.definition.Modifier;
import io.protobj.definition.config.FieldConfig;
import io.protobj.definition.config.MessageConfig;
import io.protobj.generator.CodeStringBuilder;

import java.io.IOException;
import java.util.Objects;

import static io.protobj.generator.GeneratorUtils.firstUpper;
import static io.protobj.generator.GeneratorUtils.i;
import static io.protobj.generator.GeneratorUtils.writeFile;

public class JavaMessageGenerator {

    public void createEnumClass(JavaGenerator generator, MessageConfig messageConfig, String outputDir) throws IOException {
        String pkg = messageConfig.getPkg();
        CodeStringBuilder header = new CodeStringBuilder();

        header.add(JavaCodeUtil.Package(pkg)).newLine(2);
        if (messageConfig.getNote() != null) {
            header.add(i("//${0}", messageConfig.getNote())).newLine();
        }
        header.add(i("public enum ${0} {", messageConfig.getName())).newLine();
        for (FieldConfig field : messageConfig.getFieldConfigMap().values()) {
            header.add(i("//${0} = ${1};", field.getFieldName(), field.getFieldNum()));
            if (field.getDescription() != null) {
                header.add(field.getDescription());
            }
            header.newLine();
            header.add(i("${0},", field.getFieldName())).newLine();
        }
        header.add(";").newLine();
        header.add("}").newLine();
        writeFile(generator.type(),messageConfig.getName(), outputDir, pkg, header.toString());
    }


    public void createMessageClass(JavaGenerator generator, MessageConfig messageConfig, String outputDir) throws IOException {
        CodeStringBuilder header = new CodeStringBuilder();

        header.add(JavaCodeUtil.Package(messageConfig.getPkg())).newLine(2);

        CodeStringBuilder fields = new CodeStringBuilder();
        CodeStringBuilder methods = new CodeStringBuilder();
        methods.setCurrent(1);

        if (messageConfig.getNote() != null) {
            fields.add(i("//${0}", messageConfig.getNote())).newLine();
        }

        MessageConfig parent = messageConfig.getExtMessage();
        if (parent != null) {
            FieldConfig extField = messageConfig.getExtField();
            fields.add(extField.getDefinition()).newLine();
            fields.add(i("public class ${0} extends ${1} {", messageConfig.getName(), parent.getName())).newLine(2);
            fields.addImportMessage(parent.getFullName());
        } else {
            if (messageConfig.getNote() != null) {
                fields.add(i("//{0}", messageConfig.getNote())).newLine();
            }
            fields.add(i("public class ${0} {", messageConfig.getName())).newLine(2);
        }
        for (FieldConfig field : messageConfig.getFieldConfigMap().values()) {
            Modifier modifier = field.getModifier();
            String typeName = field.getTypeName();
            FieldType fieldType = FieldType.getBuiltinType(typeName);
            TypeAndImport type;
            if (fieldType != null) {
                type = getTypeAndImportFromBuiltinType(modifier, fieldType);
                if (type == null && fieldType == FieldType.MAP) {
                    //key必须是 内置类型
                    FieldType keyFieldType = Objects.requireNonNull(FieldType.getBuiltinType(field.getKeyType()));
                    FieldType valueFieldType = FieldType.getBuiltinType(field.getValueTypeName());
                    if (valueFieldType != null) {
                        if (keyFieldType == FieldType.STRING && valueFieldType == FieldType.STRING) {
                            type = TypeAndImport.of("Map<String,String>", "java.util.Map");
                        } else if (keyFieldType == FieldType.STRING) {
                            String mapType = i("Object2${0}Map<String>", firstUpper(valueFieldType.javaType));
                            type = TypeAndImport.of(mapType, i("it.unimi.dsi.fastutil.objects.Object2${0}Map", firstUpper(valueFieldType.javaType)));
                        } else if (valueFieldType == FieldType.STRING) {
                            String mapType = i("${0}2ObjectMap<String>", firstUpper(keyFieldType.javaType));
                            type = TypeAndImport.of(mapType, i("it.unimi.dsi.fastutil.${0}s.${1}2ObjectMap", keyFieldType.javaType, firstUpper(keyFieldType.javaType)));
                        } else {
                            String mapType = firstUpper(keyFieldType.javaType) + "2" + firstUpper(valueFieldType.javaType) + "Map";
                            type = TypeAndImport.of(mapType, i("it.unimi.dsi.fastutil.${0}s.${1}", keyFieldType.javaType, mapType));
                        }
                    } else {
                        if (keyFieldType == FieldType.STRING) {
                            String mapType = i("Map<String,${0}>", field.getValueTypeName());
                            type = TypeAndImport.of(mapType, "java.util.Map", field.getValueTypeFullName());
                        } else {
                            String mapType = i("${0}2ObjectMap<${1}>", firstUpper(keyFieldType.javaType), field.getValueTypeName());
                            String mapType0 = i("${0}2ObjectMap", firstUpper(keyFieldType.javaType));
                            type = TypeAndImport.of(mapType, i("it.unimi.dsi.fastutil.${0}s.${1}", keyFieldType.javaType, mapType0), field.getValueTypeFullName());
                        }
                    }
                }
            } else {
                String typeFullName = field.getTypeFullName();
                MessageConfig message = generator.findMessage(messageConfig, typeFullName);
                type = switch (modifier) {
                    case DFT -> TypeAndImport.of(field.getTypeName(), field.getTypeFullName());
                    case SET -> switch (message.getType()) {
                        case ENUM ->
                                TypeAndImport.of(i("EnumSet<${0}>", field.getTypeName()), field.getTypeFullName(), "java.util.EnumSet");
                        case MESSAGE ->
                                TypeAndImport.of(i("Set<${0}>", field.getTypeName()), field.getTypeFullName(), "java.util.Set");
                    };
                    case LST ->
                            TypeAndImport.of(i("List<${0}>", field.getTypeName()), field.getTypeFullName(), "java.util.List");
                    case ARR -> TypeAndImport.of(i("${0}[]", field.getTypeName()), field.getTypeFullName());
                    case EXT -> null;
                };
                if (message.getType() == MessageType.MESSAGE && modifier == Modifier.EXT) {
                    continue;
                }
            }
            if (type == null) {

                throw new RuntimeException(i("field type not found ${0} ${1}", messageConfig.getFullName(), field.getTypeFullName()));
            }
            createField(messageConfig, fields, methods, field, type);
        }
        header.addImportMessages(fields.getImportMessages());
        header.addImportMessages(methods.getImportMessages());
        JavaCodeUtil.appendImportMessagesForJava(messageConfig.getPkg(), header);
        header.add(fields).add(methods).add("}").newLine();
        writeFile(generator.type(),messageConfig.getName(), outputDir, messageConfig.getPkg(), header.toString());
    }

    private void createField(MessageConfig messageConfig, CodeStringBuilder fields, CodeStringBuilder methods, FieldConfig fieldConfig, TypeAndImport type) {
        //同名不同包的类，需使用全限定名
        if (type.getImports() != null) {
            for (String anImport : type.getImports()) {
                if (anImport.equals(type.getType())) {
                    continue;
                }
                fields.addImportMessage(anImport);
            }
        }

        fields.add(fieldConfig.getDefinition()).newLine();

        fields.add(i("private ${0} ${1};", type.getType(), fieldConfig.getFieldName())).newLine(2);
        String firstUpper = firstUpper(fieldConfig.getFieldName());
        methods.add(i("public void set${0}(${1} ${2}) {", firstUpper, type.getType(), fieldConfig.getFieldName())).newLine();
        methods.add(i("this.${0} = ${1};", fieldConfig.getFieldName(), fieldConfig.getFieldName())).newLine();
        methods.add("}").newLine(2);

        methods.add(i("public ${0} ${1}${2}() {", type.getType(), type.getType().equals("boolean") ? "is" : "get", firstUpper)).newLine();
        methods.add(i("return ${0};", fieldConfig.getFieldName())).newLine();
        methods.add("}").newLine(2);
    }

    private static TypeAndImport getTypeAndImportFromBuiltinType(Modifier modifier, FieldType fieldType) {
        return switch (fieldType) {
            case BOOL -> switch (modifier) {
                case DFT -> TypeAndImport.of("boolean");
                case LST -> TypeAndImport.of("BooleanList", "it.unimi.dsi.fastutil.booleans.BooleanList");
                case SET -> TypeAndImport.of("BooleanSet", "it.unimi.dsi.fastutil.booleans.BooleanSet");
                case ARR -> TypeAndImport.of("boolean[]");
                default -> null;
            };
            case I8, U8 -> switch (modifier) {
                case DFT -> TypeAndImport.of("byte");
                case LST -> TypeAndImport.of("ByteList", "it.unimi.dsi.fastutil.bytes.ByteList");
                case SET -> TypeAndImport.of("ByteSet", "it.unimi.dsi.fastutil.bytes.ByteSet");
                case ARR -> TypeAndImport.of("byte[]");
                default -> null;
            };
            case I16, U16 -> switch (modifier) {
                case DFT -> TypeAndImport.of("short");
                case LST -> TypeAndImport.of("ShortList", "it.unimi.dsi.fastutil.shorts.ShortList");
                case SET -> TypeAndImport.of("ShortSet", "it.unimi.dsi.fastutil.shorts.ShortSet");
                case ARR -> TypeAndImport.of("short[]");
                default -> null;
            };
            case I32, U32, S32, F32, SF32 -> switch (modifier) {
                case DFT -> TypeAndImport.of("int");
                case LST -> TypeAndImport.of("IntList", "it.unimi.dsi.fastutil.ints.IntList");
                case SET -> TypeAndImport.of("IntSet", "it.unimi.dsi.fastutil.ints.IntSet");
                case ARR -> TypeAndImport.of("int[]");
                default -> null;
            };
            case I64, U64, S64, F64, SF64 -> switch (modifier) {
                case DFT -> TypeAndImport.of("long");
                case LST -> TypeAndImport.of("LongList", "it.unimi.dsi.fastutil.longs.LongList");
                case SET -> TypeAndImport.of("LongSet", "it.unimi.dsi.fastutil.longs.LongSet");
                case ARR -> TypeAndImport.of("long[]");
                default -> null;
            };
            case STRING -> switch (modifier) {
                case DFT -> TypeAndImport.of("String");
                case LST -> TypeAndImport.of("List<String>", "java.util.List");
                case SET -> TypeAndImport.of("Set<String>", "java.util.Set");
                case ARR -> TypeAndImport.of("String[]");
                default -> null;
            };
            case FLOAT -> switch (modifier) {
                case DFT -> TypeAndImport.of("float");
                case LST -> TypeAndImport.of("FloatList", "it.unimi.dsi.fastutil.floats.FloatList");
                case SET -> TypeAndImport.of("FloatSet", "it.unimi.dsi.fastutil.floats.FloatSet");
                case ARR -> TypeAndImport.of("float[]");
                default -> null;
            };
            case DOUBLE -> switch (modifier) {
                case DFT -> TypeAndImport.of("double");
                case LST -> TypeAndImport.of("DoubleList", "it.unimi.dsi.fastutil.doubles.DoubleList");
                case SET -> TypeAndImport.of("DoubleSet", "it.unimi.dsi.fastutil.doubles.DoubleSet");
                case ARR -> TypeAndImport.of("double[]");
                default -> null;
            };
            default -> null;
        };
    }
}
