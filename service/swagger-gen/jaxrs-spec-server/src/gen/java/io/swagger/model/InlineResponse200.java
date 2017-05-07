package io.swagger.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class InlineResponse200   {
  
  private String salutation = null;
  private String status = null;
  private String version = null;

  /**
   **/
  public InlineResponse200 salutation(String salutation) {
    this.salutation = salutation;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getSalutation() {
    return salutation;
  }
  public void setSalutation(String salutation) {
    this.salutation = salutation;
  }

  /**
   **/
  public InlineResponse200 status(String status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   **/
  public InlineResponse200 version(String version) {
    this.version = version;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(salutation, inlineResponse200.salutation) &&
        Objects.equals(status, inlineResponse200.status) &&
        Objects.equals(version, inlineResponse200.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salutation, status, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
