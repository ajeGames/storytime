package io.swagger.model;

import io.swagger.model.StoriesstoryIdchaptersSignpost;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class InlineResponse2001   {
  
  private String chapterId = null;
  private String title = null;
  private String prose = null;
  private List<StoriesstoryIdchaptersSignpost> signpost = new ArrayList<StoriesstoryIdchaptersSignpost>();

  /**
   **/
  public InlineResponse2001 chapterId(String chapterId) {
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
  public InlineResponse2001 title(String title) {
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
  public InlineResponse2001 prose(String prose) {
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
  public InlineResponse2001 signpost(List<StoriesstoryIdchaptersSignpost> signpost) {
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
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(chapterId, inlineResponse2001.chapterId) &&
        Objects.equals(title, inlineResponse2001.title) &&
        Objects.equals(prose, inlineResponse2001.prose) &&
        Objects.equals(signpost, inlineResponse2001.signpost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chapterId, title, prose, signpost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
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
