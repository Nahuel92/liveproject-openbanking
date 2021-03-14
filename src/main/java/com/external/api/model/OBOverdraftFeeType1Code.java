package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Overdraft fee type
 */
public enum OBOverdraftFeeType1Code {

    FBAO("FBAO"),

    FBAR("FBAR"),

    FBEB("FBEB"),

    FBIT("FBIT"),

    FBOR("FBOR"),

    FBOS("FBOS"),

    FBSC("FBSC"),

    FBTO("FBTO"),

    FBUB("FBUB"),

    FBUT("FBUT"),

    FTOT("FTOT"),

    FTUT("FTUT");

    private final String value;

    OBOverdraftFeeType1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBOverdraftFeeType1Code fromValue(String value) {
        for (OBOverdraftFeeType1Code b : OBOverdraftFeeType1Code.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

