package io.protobj.config;

public enum LanguageType {
    java("java"),
    ;

    private final String fileSuffix;

    LanguageType(String fileSuffix) {
    this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }
}
