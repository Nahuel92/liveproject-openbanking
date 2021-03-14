package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the status of the direct debit in code form.
 */
public enum OBExternalDirectDebitStatus1Code {

    ACTIVE("Active"),

    INACTIVE("Inactive");

    private final String value;

    OBExternalDirectDebitStatus1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBExternalDirectDebitStatus1Code fromValue(String value) {
        for (OBExternalDirectDebitStatus1Code b : OBExternalDirectDebitStatus1Code.values()) {
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

