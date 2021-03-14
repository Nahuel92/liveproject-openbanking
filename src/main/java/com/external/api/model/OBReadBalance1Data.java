package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OBReadBalance1Data
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBReadBalance1Data {
    @JsonProperty("Balance")
    @Valid
    private List<OBReadBalance1DataBalance> balance = new ArrayList<>();

    public OBReadBalance1Data balance(List<OBReadBalance1DataBalance> balance) {
        this.balance = balance;
        return this;
    }

    public OBReadBalance1Data addBalanceItem(OBReadBalance1DataBalance balanceItem) {
        this.balance.add(balanceItem);
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    @Size(min = 1)
    public List<OBReadBalance1DataBalance> getBalance() {
        return balance;
    }

    public void setBalance(List<OBReadBalance1DataBalance> balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBReadBalance1Data obReadBalance1Data = (OBReadBalance1Data) o;
        return Objects.equals(this.balance, obReadBalance1Data.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBReadBalance1Data {\n");

        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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
