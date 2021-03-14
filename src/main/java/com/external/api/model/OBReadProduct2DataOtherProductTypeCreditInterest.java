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
 * Details about the interest that may be payable to the Account holders
 */
@ApiModel(description = "Details about the interest that may be payable to the Account holders")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBReadProduct2DataOtherProductTypeCreditInterest {
    @JsonProperty("TierBandSet")
    @Valid
    private List<OBReadProduct2DataOtherProductTypeCreditInterestTierBandSet> tierBandSet = new ArrayList<>();

    public OBReadProduct2DataOtherProductTypeCreditInterest tierBandSet(List<OBReadProduct2DataOtherProductTypeCreditInterestTierBandSet> tierBandSet) {
        this.tierBandSet = tierBandSet;
        return this;
    }

    public OBReadProduct2DataOtherProductTypeCreditInterest addTierBandSetItem(OBReadProduct2DataOtherProductTypeCreditInterestTierBandSet tierBandSetItem) {
        this.tierBandSet.add(tierBandSetItem);
        return this;
    }

    /**
     * Get tierBandSet
     *
     * @return tierBandSet
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid
    @Size(min = 1)
    public List<OBReadProduct2DataOtherProductTypeCreditInterestTierBandSet> getTierBandSet() {
        return tierBandSet;
    }

    public void setTierBandSet(List<OBReadProduct2DataOtherProductTypeCreditInterestTierBandSet> tierBandSet) {
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
        OBReadProduct2DataOtherProductTypeCreditInterest obReadProduct2DataOtherProductTypeCreditInterest = (OBReadProduct2DataOtherProductTypeCreditInterest) o;
        return Objects.equals(this.tierBandSet, obReadProduct2DataOtherProductTypeCreditInterest.tierBandSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tierBandSet);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBReadProduct2DataOtherProductTypeCreditInterest {\n");

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

