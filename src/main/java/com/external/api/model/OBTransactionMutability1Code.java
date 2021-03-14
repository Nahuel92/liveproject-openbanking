package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the Mutability of the Transaction record.
 */
public enum OBTransactionMutability1Code {

    MUTABLE("Mutable"),

    IMMUTABLE("Immutable");

    private final String value;

    OBTransactionMutability1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBTransactionMutability1Code fromValue(String value) {
        for (OBTransactionMutability1Code b : OBTransactionMutability1Code.values()) {
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

