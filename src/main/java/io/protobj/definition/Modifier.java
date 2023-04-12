package io.protobj.definition;

public enum Modifier {
    DFT,//default
    LST,//list
    SET,//set
    ARR,//array
    EXT,//extend
    ;

    public String getName() {
        return name().toLowerCase();
    }
}
