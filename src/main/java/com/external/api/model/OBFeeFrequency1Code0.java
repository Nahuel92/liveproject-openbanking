package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Frequency at which the overdraft charge is applied to the account
 */
public enum OBFeeFrequency1Code0 {

    FEAC("FEAC"),

    FEAO("FEAO"),

    FECP("FECP"),

    FEDA("FEDA"),

    FEHO("FEHO"),

    FEI("FEI"),

    FEMO("FEMO"),

    FEOA("FEOA"),

    FEOT("FEOT"),

    FEPC("FEPC"),

    FEPH("FEPH"),

    FEPO("FEPO"),

    FEPS("FEPS"),

    FEPT("FEPT"),

    FEPTA("FEPTA"),

    FEPTP("FEPTP"),

    FEQU("FEQU"),

    FESM("FESM"),

    FEST("FEST"),

    FEWE("FEWE"),

    FEYE("FEYE");

    private final String value;

    OBFeeFrequency1Code0(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBFeeFrequency1Code0 fromValue(String value) {
        for (OBFeeFrequency1Code0 b : OBFeeFrequency1Code0.values()) {
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

