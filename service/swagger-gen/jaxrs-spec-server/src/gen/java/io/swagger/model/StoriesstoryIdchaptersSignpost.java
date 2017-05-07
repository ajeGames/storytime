package io.swagger.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class StoriesstoryIdchaptersSignpost   {
  
  private String destinationId = null;
  private String teaser = null;

  /**
   **/
  public StoriesstoryIdchaptersSignpost destinationId(String destinationId) {
    this.destinationId = destinationId;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getDestinationId() {
    return destinationId;
  }
  public void setDestinationId(String destinationId) {
    this.destinationId = destinationId;
  }

  /**
   **/
  public StoriesstoryIdchaptersSignpost teaser(String teaser) {
    this.teaser = teaser;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getTeaser() {
    return teaser;
  }
  public void setTeaser(String teaser) {
    this.teaser = teaser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoriesstoryIdchaptersSignpost storiesstoryIdchaptersSignpost = (StoriesstoryIdchaptersSignpost) o;
    return Objects.equals(destinationId, storiesstoryIdchaptersSignpost.destinationId) &&
        Objects.equals(teaser, storiesstoryIdchaptersSignpost.teaser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationId, teaser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoriesstoryIdchaptersSignpost {\n");
    
    sb.append("    destinationId: ").append(toIndentedString(destinationId)).append("\n");
    sb.append("    teaser: ").append(toIndentedString(teaser)).append("\n");
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
