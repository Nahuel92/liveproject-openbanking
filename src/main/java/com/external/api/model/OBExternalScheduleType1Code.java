package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Specifies the scheduled payment date type requested
 */
public enum OBExternalScheduleType1Code {

  ARRIVAL("Arrival"),

  EXECUTION("Execution");

  private final String value;

  OBExternalScheduleType1Code(String value) {
    this.value = value;
  }

  @JsonCreator
  public static OBExternalScheduleType1Code fromValue(String value) {
    for (OBExternalScheduleType1Code b : OBExternalScheduleType1Code.values()) {
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

