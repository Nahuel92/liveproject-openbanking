package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Categorisation of fees and charges into standard categories.
 */
public enum OBFeeCategory1Code {

    FCOT("FCOT"),

    FCRE("FCRE"),

    FCSV("FCSV");

    private final String value;

    OBFeeCategory1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBFeeCategory1Code fromValue(String value) {
        for (OBFeeCategory1Code b : OBFeeCategory1Code.values()) {
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

