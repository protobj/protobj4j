package io.protobj.generator.java.writer.dft.map;

public record MapFieldParam(String entrySetType, String entrySetValue, String keyValue, String valueValue) {
    public static MapFieldParam of(String entrySetType, String entrySetValue, String keyValue, String valueValue) {
        return new MapFieldParam(entrySetType, entrySetValue, keyValue, valueValue);
    }
}
