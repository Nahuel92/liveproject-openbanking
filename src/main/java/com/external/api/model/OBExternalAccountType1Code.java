package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the type of account (personal or business).
 */
public enum OBExternalAccountType1Code {

    BUSINESS("Business"),

    PERSONAL("Personal");

    private final String value;

    OBExternalAccountType1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBExternalAccountType1Code fromValue(String value) {
        for (OBExternalAccountType1Code b : OBExternalAccountType1Code.values()) {
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

