package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Representation for story information.
 */
public class StorySummary {

    private String key;
    private String title;
    private String author;
    private String tagLine;
    private String about;
    private ChapterSign firstChapter;

    public static StorySummary create(String key, String title, String author, String tagLine, String about,
                                      final ChapterSign firstChapter) {
        StorySummary summary = new StorySummary();
        summary.key = key;
        summary.title = title;
        summary.author = author;
        summary.tagLine = tagLine;
        summary.about = about;
        summary.firstChapter = firstChapter;
        return summary;
    }

    @JsonProperty
    public String getKey() {
        return key;
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
    public ChapterSign getFirstChapter() {
        return firstChapter;
    }

    @Override
    public String toString() {
        return "StorySummary{" +
                "key='" + key + '\'' +
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
        return Objects.equal(key, that.key) &&
                Objects.equal(title, that.title) &&
                Objects.equal(author, that.author) &&
                Objects.equal(tagLine, that.tagLine) &&
                Objects.equal(about, that.about) &&
                Objects.equal(firstChapter, that.firstChapter);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key, title, author, tagLine, about, firstChapter);
    }
}
