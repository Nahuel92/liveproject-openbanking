package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Rate type for Fee/Charge (where it is charged in terms of a rate rather than an amount)
 */
public enum OBInterestRateType1Code1 {

    INBB("INBB"),

    INFR("INFR"),

    INGR("INGR"),

    INLR("INLR"),

    INNE("INNE"),

    INOT("INOT");

    private final String value;

    OBInterestRateType1Code1(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBInterestRateType1Code1 fromValue(String value) {
        for (OBInterestRateType1Code1 b : OBInterestRateType1Code1.values()) {
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

