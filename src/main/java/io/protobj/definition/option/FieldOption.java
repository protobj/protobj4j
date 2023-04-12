package io.protobj.definition.option;

public enum FieldOption {
    polymorphic {
        @Override
        public FieldOptionValue parse(String optionValue) {
            return new BoolFieldOptionValue(Boolean.parseBoolean(optionValue));
        }
    },
    deprecated {
        @Override
        public FieldOptionValue parse(String optionValue) {
            return new BoolFieldOptionValue(Boolean.parseBoolean(optionValue));
        }
    },
    ;

    public abstract FieldOptionValue parse(String optionValue);
}
