package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import java.util.Date;
import java.util.List;

/**
 * Representation for story information.
 */
public class StorySummary {

    private String storyId;
    private String title;
    private String authorId;
    private String penName;
    private String tagLine;
    private String about;
    private int firstChapter;
    private boolean draft;
    private Date publishedAt;
    private int version;
    private List<String> genre;
    private List<String> category;

    public static StorySummary create(String storyId, String title, String authorId, String penName,
                        String tagLine, String about, int firstChapter, boolean draft,
                        Date publishedAt, int version, List<String> genre, List<String> category) {
        StorySummary summary = new StorySummary();
        summary.storyId = storyId;
        summary.title = title;
        summary.authorId = authorId;
        summary.penName = penName;
        summary.tagLine = tagLine;
        summary.about = about;
        summary.firstChapter = firstChapter;
        summary.draft = draft;
        summary.publishedAt = publishedAt;
        summary.version = version;
        summary.genre = genre;
        summary.category = category;
        return summary;
    }

    @JsonProperty
    public String getStoryId() {
        return storyId;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getAuthorId() {
        return authorId;
    }

    @JsonProperty
    public String getPenName() {
        return penName;
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

    @JsonProperty
    public boolean isDraft() {
        return draft;
    }

    @JsonProperty
    public Date getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty
    public int getVersion() {
        return version;
    }

    @JsonProperty
    public List<String> getGenre() {
        return genre;
    }

    @JsonProperty
    public List<String> getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorySummary that = (StorySummary) o;
        return getFirstChapter() == that.getFirstChapter() &&
                isDraft() == that.isDraft() &&
                getVersion() == that.getVersion() &&
                Objects.equal(getStoryId(), that.getStoryId()) &&
                Objects.equal(getTitle(), that.getTitle()) &&
                Objects.equal(getAuthorId(), that.getAuthorId()) &&
                Objects.equal(getPenName(), that.getPenName()) &&
                Objects.equal(getTagLine(), that.getTagLine()) &&
                Objects.equal(getAbout(), that.getAbout()) &&
                Objects.equal(getPublishedAt(), that.getPublishedAt()) &&
                Objects.equal(getGenre(), that.getGenre()) &&
                Objects.equal(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getStoryId(), getTitle(), getAuthorId(), getPenName(), getTagLine(), getAbout(), getFirstChapter(), isDraft(), getPublishedAt(), getVersion(), getGenre(), getCategory());
    }

    @Override
    public String toString() {
        return "StorySummary{" +
                "storyId='" + storyId + '\'' +
                ", title='" + title + '\'' +
                ", authorId='" + authorId + '\'' +
                ", penName='" + penName + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", about='" + about + '\'' +
                ", firstChapter=" + firstChapter +
                ", draft=" + draft +
                ", publishedAt=" + publishedAt +
                ", version=" + version +
                ", genre=" + genre +
                ", category=" + category +
                '}';
    }
}
