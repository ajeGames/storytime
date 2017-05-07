package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Story1   {
  
  private String storyId = null;
  private String title = null;
  private String penName = null;
  private String tagLine = null;
  private String about = null;
  private String firstChapter = null;
  private Boolean draft = null;
  private List<String> genre = new ArrayList<String>();
  private List<String> category = new ArrayList<String>();

  /**
   **/
  public Story1 storyId(String storyId) {
    this.storyId = storyId;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getStoryId() {
    return storyId;
  }
  public void setStoryId(String storyId) {
    this.storyId = storyId;
  }

  /**
   **/
  public Story1 title(String title) {
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
  public Story1 penName(String penName) {
    this.penName = penName;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getPenName() {
    return penName;
  }
  public void setPenName(String penName) {
    this.penName = penName;
  }

  /**
   **/
  public Story1 tagLine(String tagLine) {
    this.tagLine = tagLine;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getTagLine() {
    return tagLine;
  }
  public void setTagLine(String tagLine) {
    this.tagLine = tagLine;
  }

  /**
   **/
  public Story1 about(String about) {
    this.about = about;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getAbout() {
    return about;
  }
  public void setAbout(String about) {
    this.about = about;
  }

  /**
   **/
  public Story1 firstChapter(String firstChapter) {
    this.firstChapter = firstChapter;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getFirstChapter() {
    return firstChapter;
  }
  public void setFirstChapter(String firstChapter) {
    this.firstChapter = firstChapter;
  }

  /**
   **/
  public Story1 draft(Boolean draft) {
    this.draft = draft;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Boolean getDraft() {
    return draft;
  }
  public void setDraft(Boolean draft) {
    this.draft = draft;
  }

  /**
   **/
  public Story1 genre(List<String> genre) {
    this.genre = genre;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public List<String> getGenre() {
    return genre;
  }
  public void setGenre(List<String> genre) {
    this.genre = genre;
  }

  /**
   **/
  public Story1 category(List<String> category) {
    this.category = category;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public List<String> getCategory() {
    return category;
  }
  public void setCategory(List<String> category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Story1 story1 = (Story1) o;
    return Objects.equals(storyId, story1.storyId) &&
        Objects.equals(title, story1.title) &&
        Objects.equals(penName, story1.penName) &&
        Objects.equals(tagLine, story1.tagLine) &&
        Objects.equals(about, story1.about) &&
        Objects.equals(firstChapter, story1.firstChapter) &&
        Objects.equals(draft, story1.draft) &&
        Objects.equals(genre, story1.genre) &&
        Objects.equals(category, story1.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storyId, title, penName, tagLine, about, firstChapter, draft, genre, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Story1 {\n");
    
    sb.append("    storyId: ").append(toIndentedString(storyId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    penName: ").append(toIndentedString(penName)).append("\n");
    sb.append("    tagLine: ").append(toIndentedString(tagLine)).append("\n");
    sb.append("    about: ").append(toIndentedString(about)).append("\n");
    sb.append("    firstChapter: ").append(toIndentedString(firstChapter)).append("\n");
    sb.append("    draft: ").append(toIndentedString(draft)).append("\n");
    sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
