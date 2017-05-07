package io.swagger.model;

import io.swagger.model.StoriesstoryIdchaptersSignpost;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Chapter2   {
  
  private String chapterId = null;
  private String title = null;
  private String prose = null;
  private List<StoriesstoryIdchaptersSignpost> signpost = new ArrayList<StoriesstoryIdchaptersSignpost>();

  /**
   **/
  public Chapter2 chapterId(String chapterId) {
    this.chapterId = chapterId;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getChapterId() {
    return chapterId;
  }
  public void setChapterId(String chapterId) {
    this.chapterId = chapterId;
  }

  /**
   **/
  public Chapter2 title(String title) {
    this.title = title;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   **/
  public Chapter2 prose(String prose) {
    this.prose = prose;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getProse() {
    return prose;
  }
  public void setProse(String prose) {
    this.prose = prose;
  }

  /**
   **/
  public Chapter2 signpost(List<StoriesstoryIdchaptersSignpost> signpost) {
    this.signpost = signpost;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public List<StoriesstoryIdchaptersSignpost> getSignpost() {
    return signpost;
  }
  public void setSignpost(List<StoriesstoryIdchaptersSignpost> signpost) {
    this.signpost = signpost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chapter2 chapter2 = (Chapter2) o;
    return Objects.equals(chapterId, chapter2.chapterId) &&
        Objects.equals(title, chapter2.title) &&
        Objects.equals(prose, chapter2.prose) &&
        Objects.equals(signpost, chapter2.signpost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chapterId, title, prose, signpost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Chapter2 {\n");
    
    sb.append("    chapterId: ").append(toIndentedString(chapterId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    prose: ").append(toIndentedString(prose)).append("\n");
    sb.append("    signpost: ").append(toIndentedString(signpost)).append("\n");
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
