package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Representation for story information.
 */
public class StorySummary {

    private String storyKey;
    private String title;
    private String author;
    private String tagLine;
    private String about;
    private int firstChapter;

    public static StorySummary create(String storyKey, String title, String author, String tagLine, String about,
                                      int firstChapter) {
        StorySummary summary = new StorySummary();
        summary.storyKey = storyKey;
        summary.title = title;
        summary.author = author;
        summary.tagLine = tagLine;
        summary.about = about;
        summary.firstChapter = firstChapter;
        return summary;
    }

    @JsonProperty
    public String getStoryKey() {
        return storyKey;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }

    @JsonProperty
    public String getTagLine() {
        return tagLine;
    }

    @JsonProperty
    public String getAbout() {
        return about;
    }

    @JsonProperty
    public int getFirstChapter() {
        return firstChapter;
    }

    @Override
    public String toString() {
        return "StorySummary{" +
                "storyKey='" + storyKey + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", about='" + about + '\'' +
                ", firstChapter=" + firstChapter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorySummary that = (StorySummary) o;
        return Objects.equal(storyKey, that.storyKey) &&
                Objects.equal(title, that.title) &&
                Objects.equal(author, that.author) &&
                Objects.equal(tagLine, that.tagLine) &&
                Objects.equal(about, that.about) &&
                Objects.equal(firstChapter, that.firstChapter);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(storyKey, title, author, tagLine, about, firstChapter);
    }
}
