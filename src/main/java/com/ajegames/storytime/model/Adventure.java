package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is the top of the story graph for a multi-path adventure.
 */
public class Adventure {

    @JsonProperty
    private String key;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String tagLine;

    @JsonProperty
    private String description;

    @JsonProperty
    private Chapter firstChapter;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Chapter getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(Chapter firstChapter) {
        this.firstChapter = firstChapter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adventure adventure = (Adventure) o;

        if (key != null ? !key.equals(adventure.key) : adventure.key != null) return false;
        if (title != null ? !title.equals(adventure.title) : adventure.title != null) return false;
        if (author != null ? !author.equals(adventure.author) : adventure.author != null) return false;
        if (tagLine != null ? !tagLine.equals(adventure.tagLine) : adventure.tagLine != null) return false;
        if (description != null ? !description.equals(adventure.description) : adventure.description != null)
            return false;
        return !(firstChapter != null ? !firstChapter.equals(adventure.firstChapter) : adventure.firstChapter != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (tagLine != null ? tagLine.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (firstChapter != null ? firstChapter.hashCode() : 0);
        return result;
    }
}
