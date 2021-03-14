package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Party type, in a coded form.
 */
public enum OBExternalPartyType1Code {

    DELEGATE("Delegate"),

    JOINT("Joint"),

    SOLE("Sole");

    private final String value;

    OBExternalPartyType1Code(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBExternalPartyType1Code fromValue(String value) {
        for (OBExternalPartyType1Code b : OBExternalPartyType1Code.values()) {
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

