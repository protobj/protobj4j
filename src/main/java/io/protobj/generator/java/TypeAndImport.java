package io.protobj.generator.java;

public class TypeAndImport {

    private String type;

    private String[] imports;

    public static TypeAndImport of(String type, String... imports) {
        TypeAndImport typeAndImport = new TypeAndImport();
        typeAndImport.type = type;
        typeAndImport.imports = imports;
        return typeAndImport;
    }

    public static TypeAndImport of(String type) {
        TypeAndImport typeAndImport = new TypeAndImport();
        typeAndImport.type = type;
        return typeAndImport;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getImports() {
        return imports;
    }

    public void setImports(String[] imports) {
        this.imports = imports;
    }
}
