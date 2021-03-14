package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates whether the transaction is a credit or a debit entry.
 */
public enum OBCreditDebitCode1 {

    CREDIT("Credit"),

    DEBIT("Debit");

    private final String value;

    OBCreditDebitCode1(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBCreditDebitCode1 fromValue(String value) {
        for (OBCreditDebitCode1 b : OBCreditDebitCode1.values()) {
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

