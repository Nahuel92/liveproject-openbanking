package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Status of a transaction entry on the books of the account servicer.
 */
public enum OBEntryStatus1Code {

  BOOKED("Booked"),

  PENDING("Pending");

  private final String value;

  OBEntryStatus1Code(String value) {
    this.value = value;
  }

  @JsonCreator
  public static OBEntryStatus1Code fromValue(String value) {
    for (OBEntryStatus1Code b : OBEntryStatus1Code.values()) {
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

