package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class StorySummary   {
  
  private String storyId = null;
  private String title = null;
  private String authorId = null;
  private String penName = null;
  private String tagLine = null;
  private String about = null;
  private String firstChapter = null;
  private Boolean draft = null;
  private javax.xml.datatype.XMLGregorianCalendar publishedAt = null;
  private Integer version = null;
  private List<String> genre = new ArrayList<String>();
  private List<String> category = new ArrayList<String>();

  /**
   **/
  public StorySummary storyId(String storyId) {
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
  public StorySummary title(String title) {
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
  public StorySummary authorId(String authorId) {
    this.authorId = authorId;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getAuthorId() {
    return authorId;
  }
  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }

  /**
   **/
  public StorySummary penName(String penName) {
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
  public StorySummary tagLine(String tagLine) {
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
  public StorySummary about(String about) {
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
  public StorySummary firstChapter(String firstChapter) {
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
  public StorySummary draft(Boolean draft) {
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
  public StorySummary publishedAt(javax.xml.datatype.XMLGregorianCalendar publishedAt) {
    this.publishedAt = publishedAt;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getPublishedAt() {
    return publishedAt;
  }
  public void setPublishedAt(javax.xml.datatype.XMLGregorianCalendar publishedAt) {
    this.publishedAt = publishedAt;
  }

  /**
   **/
  public StorySummary version(Integer version) {
    this.version = version;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Integer getVersion() {
    return version;
  }
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   **/
  public StorySummary genre(List<String> genre) {
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
  public StorySummary category(List<String> category) {
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
    StorySummary storySummary = (StorySummary) o;
    return Objects.equals(storyId, storySummary.storyId) &&
        Objects.equals(title, storySummary.title) &&
        Objects.equals(authorId, storySummary.authorId) &&
        Objects.equals(penName, storySummary.penName) &&
        Objects.equals(tagLine, storySummary.tagLine) &&
        Objects.equals(about, storySummary.about) &&
        Objects.equals(firstChapter, storySummary.firstChapter) &&
        Objects.equals(draft, storySummary.draft) &&
        Objects.equals(publishedAt, storySummary.publishedAt) &&
        Objects.equals(version, storySummary.version) &&
        Objects.equals(genre, storySummary.genre) &&
        Objects.equals(category, storySummary.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storyId, title, authorId, penName, tagLine, about, firstChapter, draft, publishedAt, version, genre, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StorySummary {\n");
    
    sb.append("    storyId: ").append(toIndentedString(storyId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    authorId: ").append(toIndentedString(authorId)).append("\n");
    sb.append("    penName: ").append(toIndentedString(penName)).append("\n");
    sb.append("    tagLine: ").append(toIndentedString(tagLine)).append("\n");
    sb.append("    about: ").append(toIndentedString(about)).append("\n");
    sb.append("    firstChapter: ").append(toIndentedString(firstChapter)).append("\n");
    sb.append("    draft: ").append(toIndentedString(draft)).append("\n");
    sb.append("    publishedAt: ").append(toIndentedString(publishedAt)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
