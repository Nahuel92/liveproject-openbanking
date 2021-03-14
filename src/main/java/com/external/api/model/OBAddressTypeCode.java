package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Identifies the nature of the postal address.
 */
public enum OBAddressTypeCode {

    BUSINESS("Business"),

    CORRESPONDENCE("Correspondence"),

    DELIVERYTO("DeliveryTo"),

    MAILTO("MailTo"),

    POBOX("POBox"),

    POSTAL("Postal"),

    RESIDENTIAL("Residential"),

    STATEMENT("Statement");

    private final String value;

    OBAddressTypeCode(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OBAddressTypeCode fromValue(String value) {
        for (OBAddressTypeCode b : OBAddressTypeCode.values()) {
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

