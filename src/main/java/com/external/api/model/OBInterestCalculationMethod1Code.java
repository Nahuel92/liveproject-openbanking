package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Methods of calculating interest
 */
public enum OBInterestCalculationMethod1Code {

    ITCO("ITCO"),

    ITOT("ITOT"),

    ITSI("ITSI");

    private final String value;

    OBInterestCalculationMethod1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBInterestCalculationMethod1Code fromValue(String value) {
        for (OBInterestCalculationMethod1Code b : OBInterestCalculationMethod1Code.values()) {
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

