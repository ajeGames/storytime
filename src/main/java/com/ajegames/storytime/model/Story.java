package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the top of the story graph for a multi-path adventure.
 */
public class Story {

    private int chapterCounter = 1;

    @JsonProperty
    private String key;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String tagLine;

    @JsonProperty
    private String about;

    @JsonProperty
    private Chapter firstChapter;

    private Map<Integer, Chapter> chapters;

    public static Story createNew(String title, String author, String tagLine, String description) {
        Story out = new Story();
        out.setTitle(title);
        out.setAuthor(author);
        out.setTagLine(tagLine);
        out.setAbout(description);
        return out;
    }

    public Story() {
        chapters = new HashMap<Integer, Chapter>();
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Chapter getFirstChapter() {
        return firstChapter;
    }

    public void setFirstChapter(Chapter firstChapter) {
        this.firstChapter = firstChapter;
    }

    public Chapter addChapter() {
        Chapter out = Chapter.create(this, chapterCounter++);
        chapters.put(out.getId(), out);
        return out;
    }

    public Chapter getChapter(Integer id) {
        return chapters.get(id);
    }

    public void indexChapters() {
        indexChapter(firstChapter);
    }

    private void indexChapter(Chapter chapter) {
        chapters.put(chapter.getId(), chapter);
        if (chapter.hasNext()) {
            for (Chapter next : chapter.getNextChapterOptions()) {
                indexChapter(next);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (key != null ? !key.equals(story.key) : story.key != null) return false;
        if (title != null ? !title.equals(story.title) : story.title != null) return false;
        if (author != null ? !author.equals(story.author) : story.author != null) return false;
        if (tagLine != null ? !tagLine.equals(story.tagLine) : story.tagLine != null) return false;
        if (about != null ? !about.equals(story.about) : story.about != null)
            return false;
        return !(firstChapter != null ? !firstChapter.equals(story.firstChapter) : story.firstChapter != null);

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
