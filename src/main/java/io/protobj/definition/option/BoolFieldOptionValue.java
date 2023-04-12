package io.protobj.definition.option;

public class BoolFieldOptionValue implements FieldOptionValue {
    boolean value;


    public BoolFieldOptionValue(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
