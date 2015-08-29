package com.ajegames.storytime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This is the top of the story graph for a multi-path adventure.
 */
public class Story {

    @JsonIgnore
    private int nextChapterId = 1000;
    private StorySummary summary;
    private SortedSet<Chapter> chapters;

    @JsonIgnore
    private Map<Integer, Chapter> chapterIndex;

    public Story() {
        summary = new StorySummary();
        chapters = new TreeSet<Chapter>();
        chapterIndex = new HashMap<Integer, Chapter>();
    }

    @JsonProperty
    public StorySummary getSummary() {
        return summary;
    }

    @JsonProperty
    public void setSummary(StorySummary summary) {
        this.summary = summary;
    }

    @JsonProperty
    public SortedSet<Chapter> getChapters() {
        return chapters;
    }

    @JsonProperty
    public void setChapters(SortedSet<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Chapter addChapter() {
        Chapter newChapter = Chapter.createWithPlaceholderText(this, nextChapterId++);
        chapters.add(newChapter);
        chapterIndex.put(newChapter.getId(), newChapter);
        return newChapter;
    }

    @JsonIgnore
    public Chapter getChapter(Integer id) {
        return chapterIndex.get(id);
    }

    // TODO method to reset nextChapterID to highest loaded chapter ID + 1

    public void initializeAfterLoad() {
        // reload chapter index and set next chapter ID
        int highestChapter = 0;
        if (chapterIndex == null || !chapterIndex.isEmpty()) {
            chapterIndex = new HashMap<Integer, Chapter>();
        }
        chapterIndex = new HashMap<Integer, Chapter>();
        for (Chapter chapter : chapters) {
            chapterIndex.put(chapter.getId(), chapter);
            if (chapter.getId() > highestChapter) {
                highestChapter = chapter.getId();
            }
        }
        nextChapterId = highestChapter + 1;
    }

    @Override
    public String toString() {
        return "Story{" +
                "nextChapterId=" + nextChapterId +
                ", summary=" + summary +
                ", chapters=" + chapters +
                ", chapterIndex=" + chapterIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Story story = (Story) o;

        if (nextChapterId != story.nextChapterId) return false;
        if (summary != null ? !summary.equals(story.summary) : story.summary != null) return false;
        if (chapters != null ? !chapters.equals(story.chapters) : story.chapters != null) return false;
        return !(chapterIndex != null ? !chapterIndex.equals(story.chapterIndex) : story.chapterIndex != null);

    }

    @Override
    public int hashCode() {
        int result = nextChapterId;
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (chapters != null ? chapters.hashCode() : 0);
        result = 31 * result + (chapterIndex != null ? chapterIndex.hashCode() : 0);
        return result;
    }
}
