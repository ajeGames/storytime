package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class StorySummaryAuthorUpdate   {
  
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
  public StorySummaryAuthorUpdate storyId(String storyId) {
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
  public StorySummaryAuthorUpdate title(String title) {
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
  public StorySummaryAuthorUpdate penName(String penName) {
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
  public StorySummaryAuthorUpdate tagLine(String tagLine) {
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
  public StorySummaryAuthorUpdate about(String about) {
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
  public StorySummaryAuthorUpdate firstChapter(String firstChapter) {
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
  public StorySummaryAuthorUpdate draft(Boolean draft) {
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
  public StorySummaryAuthorUpdate genre(List<String> genre) {
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
  public StorySummaryAuthorUpdate category(List<String> category) {
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
    StorySummaryAuthorUpdate storySummaryAuthorUpdate = (StorySummaryAuthorUpdate) o;
    return Objects.equals(storyId, storySummaryAuthorUpdate.storyId) &&
        Objects.equals(title, storySummaryAuthorUpdate.title) &&
        Objects.equals(penName, storySummaryAuthorUpdate.penName) &&
        Objects.equals(tagLine, storySummaryAuthorUpdate.tagLine) &&
        Objects.equals(about, storySummaryAuthorUpdate.about) &&
        Objects.equals(firstChapter, storySummaryAuthorUpdate.firstChapter) &&
        Objects.equals(draft, storySummaryAuthorUpdate.draft) &&
        Objects.equals(genre, storySummaryAuthorUpdate.genre) &&
        Objects.equals(category, storySummaryAuthorUpdate.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storyId, title, penName, tagLine, about, firstChapter, draft, genre, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StorySummaryAuthorUpdate {\n");
    
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
