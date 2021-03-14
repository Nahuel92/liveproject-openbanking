package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OBReadDirectDebit2Data
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBReadDirectDebit2Data {
    @JsonProperty("DirectDebit")
    @Valid
    private List<OBReadDirectDebit2DataDirectDebit> directDebit = null;

    public OBReadDirectDebit2Data directDebit(List<OBReadDirectDebit2DataDirectDebit> directDebit) {
        this.directDebit = directDebit;
        return this;
    }

    public OBReadDirectDebit2Data addDirectDebitItem(OBReadDirectDebit2DataDirectDebit directDebitItem) {
        if (this.directDebit == null) {
            this.directDebit = new ArrayList<>();
        }
        this.directDebit.add(directDebitItem);
        return this;
    }

    /**
     * Get directDebit
     *
     * @return directDebit
     */
    @ApiModelProperty(value = "")

    @Valid

    public List<OBReadDirectDebit2DataDirectDebit> getDirectDebit() {
        return directDebit;
    }

    public void setDirectDebit(List<OBReadDirectDebit2DataDirectDebit> directDebit) {
        this.directDebit = directDebit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBReadDirectDebit2Data obReadDirectDebit2Data = (OBReadDirectDebit2Data) o;
        return Objects.equals(this.directDebit, obReadDirectDebit2Data.directDebit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directDebit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBReadDirectDebit2Data {\n");

        sb.append("    directDebit: ").append(toIndentedString(directDebit)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

