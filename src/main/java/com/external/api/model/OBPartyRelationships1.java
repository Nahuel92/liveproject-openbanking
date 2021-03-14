package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * The Party&#39;s relationships with other resources.
 */
@ApiModel(description = "The Party's relationships with other resources.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBPartyRelationships1 {
    @JsonProperty("Account")
    private OBPartyRelationships1Account account;

    public OBPartyRelationships1 account(OBPartyRelationships1Account account) {
        this.account = account;
        return this;
    }

    /**
     * Get account
     *
     * @return account
     */
    @ApiModelProperty(value = "")

    @Valid

    public OBPartyRelationships1Account getAccount() {
        return account;
    }

    public void setAccount(OBPartyRelationships1Account account) {
        this.account = account;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBPartyRelationships1 obPartyRelationships1 = (OBPartyRelationships1) o;
        return Objects.equals(this.account, obPartyRelationships1.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBPartyRelationships1 {\n");

        sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

