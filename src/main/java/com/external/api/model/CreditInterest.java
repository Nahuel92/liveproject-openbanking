package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details about the interest that may be payable to the BCA account holders
 */
@ApiModel(description = "Details about the interest that may be payable to the BCA account holders")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class CreditInterest {
    @JsonProperty("TierBandSet")
    @Valid
    private List<CreditInterestTierBandSet> tierBandSet = new ArrayList<>();

    public CreditInterest tierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
        this.tierBandSet = tierBandSet;
        return this;
    }

    public CreditInterest addTierBandSetItem(CreditInterestTierBandSet tierBandSetItem) {
        this.tierBandSet.add(tierBandSetItem);
        return this;
    }

    /**
     * The group of tiers or bands for which credit interest can be applied.
     *
     * @return tierBandSet
     */
    @ApiModelProperty(required = true, value = "The group of tiers or bands for which credit interest can be applied.")
    @NotNull

    @Valid
    @Size(min = 1)
    public List<CreditInterestTierBandSet> getTierBandSet() {
        return tierBandSet;
    }

    public void setTierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
        this.tierBandSet = tierBandSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreditInterest creditInterest = (CreditInterest) o;
        return Objects.equals(this.tierBandSet, creditInterest.tierBandSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tierBandSet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreditInterest {\n");

        sb.append("    tierBandSet: ").append(toIndentedString(tierBandSet)).append("\n");
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
