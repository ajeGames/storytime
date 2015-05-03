package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <code>Story</code> holds information about the story, including title and a brief description to entice the curious reader.
 * It also points to the beginning of the story.
 */
public class Story {

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
    private String firstScene;

    public static Story createNew(String title, String author, String tagLine, String description) {
        Story out = new Story();
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setDescription(description);
        return out;
    }

    public static Story createExisting(String key, String title, String author, String tagLine, String description,
                                       String firstScene) {
        Story out = new Story();
        out.setKey(key);
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setDescription(description);
        out.setFirstScene(firstScene);
        return out;
    }

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

    public String getFirstScene() {
        return firstScene;
    }

    public void setFirstScene(String firstScene) {
        this.firstScene = firstScene;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (author != null ? !author.equals(story.author) : story.author != null) return false;
        if (description != null ? !description.equals(story.description) : story.description != null) return false;
        if (firstScene != null ? !firstScene.equals(story.firstScene) : story.firstScene != null) return false;
        if (key != null ? !key.equals(story.key) : story.key != null) return false;
        if (tagLine != null ? !tagLine.equals(story.tagLine) : story.tagLine != null) return false;
        if (title != null ? !title.equals(story.title) : story.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (tagLine != null ? tagLine.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (firstScene != null ? firstScene.hashCode() : 0);
        return result;
    }
}
