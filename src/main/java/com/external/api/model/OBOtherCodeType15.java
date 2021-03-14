package com.external.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Other fee rate type which is not in the standard rate type list
 */
@ApiModel(description = "Other fee rate type which is not in the standard rate type list")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-14T10:41:38.949471-03:00[America/Argentina/Buenos_Aires]")
public class OBOtherCodeType15 {
    @JsonProperty("Code")
    private String code;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    public OBOtherCodeType15 code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The four letter Mnemonic used within an XML file to identify a code
     *
     * @return code
     */
    @ApiModelProperty(value = "The four letter Mnemonic used within an XML file to identify a code")

    @Pattern(regexp = "^\\\\w{0,4}$")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OBOtherCodeType15 name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Long name associated with the code
     *
     * @return name
     */
    @ApiModelProperty(required = true, value = "Long name associated with the code")
    @NotNull

    @Size(min = 1, max = 70)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OBOtherCodeType15 description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description to describe the purpose of the code
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "Description to describe the purpose of the code")
    @NotNull

    @Size(min = 1, max = 350)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OBOtherCodeType15 obOtherCodeType15 = (OBOtherCodeType15) o;
        return Objects.equals(this.code, obOtherCodeType15.code) &&
                Objects.equals(this.name, obOtherCodeType15.name) &&
                Objects.equals(this.description, obOtherCodeType15.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OBOtherCodeType15 {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

