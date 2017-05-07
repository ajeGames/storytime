package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class ToAddRemove   {
  
  private List<String> toAdd = new ArrayList<String>();
  private List<String> toRemove = new ArrayList<String>();

  /**
   **/
  public ToAddRemove toAdd(List<String> toAdd) {
    this.toAdd = toAdd;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public List<String> getToAdd() {
    return toAdd;
  }
  public void setToAdd(List<String> toAdd) {
    this.toAdd = toAdd;
  }

  /**
   **/
  public ToAddRemove toRemove(List<String> toRemove) {
    this.toRemove = toRemove;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
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
    return Objects.equals(toAdd, toAddRemove.toAdd) &&
        Objects.equals(toRemove, toAddRemove.toRemove);
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
