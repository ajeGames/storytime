/*
 * StoryTime API
 * Backend for managing choose-your-own-destiny style stories.
 *
 * OpenAPI spec version: 0.2.0
 * Contact: saynotospam@ajegames.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 * ToAddRemove
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-05-06T21:27:25.790Z")
public class ToAddRemove   {
  @JsonProperty("toAdd")
  private List<String> toAdd = new ArrayList<String>();

  @JsonProperty("toRemove")
  private List<String> toRemove = new ArrayList<String>();

  public ToAddRemove toAdd(List<String> toAdd) {
    this.toAdd = toAdd;
    return this;
  }

  public ToAddRemove addToAddItem(String toAddItem) {
    this.toAdd.add(toAddItem);
    return this;
  }

   /**
   * Get toAdd
   * @return toAdd
  **/
  @JsonProperty("toAdd")
  @ApiModelProperty(value = "")
  public List<String> getToAdd() {
    return toAdd;
  }

  public void setToAdd(List<String> toAdd) {
    this.toAdd = toAdd;
  }

  public ToAddRemove toRemove(List<String> toRemove) {
    this.toRemove = toRemove;
    return this;
  }

  public ToAddRemove addToRemoveItem(String toRemoveItem) {
    this.toRemove.add(toRemoveItem);
    return this;
  }

   /**
   * Get toRemove
   * @return toRemove
  **/
  @JsonProperty("toRemove")
  @ApiModelProperty(value = "")
  public List<String> getToRemove() {
    return toRemove;
  }

  public void setToRemove(List<String> toRemove) {
    this.toRemove = toRemove;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ToAddRemove toAddRemove = (ToAddRemove) o;
    return Objects.equals(this.toAdd, toAddRemove.toAdd) &&
        Objects.equals(this.toRemove, toAddRemove.toRemove);
  }

  @Override
  public int hashCode() {
    return Objects.hash(toAdd, toRemove);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ToAddRemove {\n");
    
    sb.append("    toAdd: ").append(toIndentedString(toAdd)).append("\n");
    sb.append("    toRemove: ").append(toIndentedString(toRemove)).append("\n");
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

