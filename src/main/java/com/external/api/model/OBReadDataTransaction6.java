package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OBReadDataTransaction6
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBReadDataTransaction6 {
    @JsonProperty("Transaction")
    @Valid
    private List<OBTransaction6> transaction = null;

    public OBReadDataTransaction6 transaction(List<OBTransaction6> transaction) {
        this.transaction = transaction;
        return this;
    }

    public OBReadDataTransaction6 addTransactionItem(OBTransaction6 transactionItem) {
        if (this.transaction == null) {
            this.transaction = new ArrayList<>();
        }
        this.transaction.add(transactionItem);
        return this;
    }

    /**
     * Get transaction
     *
     * @return transaction
     */
    @ApiModelProperty(value = "")

    @Valid

    public List<OBTransaction6> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<OBTransaction6> transaction) {
        this.transaction = transaction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBReadDataTransaction6 obReadDataTransaction6 = (OBReadDataTransaction6) o;
        return Objects.equals(this.transaction, obReadDataTransaction6.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBReadDataTransaction6 {\n");

        sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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

