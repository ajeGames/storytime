package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    /**
     * Helper method for constructing new StorySummary (no key, no first chapter).
     * @param title
     * @param author
     * @param tagLine
     * @param about
     * @return
     */
    public static StorySummary createNew(String title, String author, String tagLine, String about) {
        StorySummary out = new StorySummary();
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setAbout(about);
        out.setFirstChapter(new ChapterSign());
        return out;
    }

    public static StorySummary createExisting(String key, String title, String author, String tagLine,
                                              String about, ChapterSign firstChapter) {
        StorySummary out = new StorySummary();
        out.setKey(key);
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setAbout(about);
        out.setFirstChapter(firstChapter);
        return out;
    }

    @JsonProperty
    public String getKey() {
        return key;
    }

    @JsonProperty
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }

    @JsonProperty
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty
    public String getTagLine() {
        return tagLine;
    }

    @JsonProperty
    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    @JsonProperty
    public String getAbout() {
        return about;
    }

    @JsonProperty
    public void setAbout(String about) {
        this.about = about;
    }

    @JsonProperty
    public ChapterSign getFirstChapter() {
        return firstChapter;
    }

    @JsonProperty
    public void setFirstChapter(ChapterSign firstChapter) {
        this.firstChapter = firstChapter;
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

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (tagLine != null ? !tagLine.equals(that.tagLine) : that.tagLine != null) return false;
        if (about != null ? !about.equals(that.about) : that.about != null) return false;
        return !(firstChapter != null ? !firstChapter.equals(that.firstChapter) : that.firstChapter != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (tagLine != null ? tagLine.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (firstChapter != null ? firstChapter.hashCode() : 0);
        return result;
    }
}
