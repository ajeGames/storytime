package com.ajegames.storytime.model;

import java.util.*;

/**
 * Mutable class that handles dynamic parts of the story, aggregations, indexes, etc.  This is not meant to be passed
 * around via JSON, but it holds all of the parts that are.  The goal is to allow representation classes to be
 * immutable, while all of the action is handled here.  In short, the "bookkeeping" happens here.
 */
public class Storybook {

    private String storyKey;
    private int nextChapterId = 1000;
    private StorySummary summary;
    private SortedSet<Chapter> chapters;
    private Map<Integer, Chapter> chapterIndex;

    public Storybook() {
        chapters = new TreeSet<Chapter>();
        chapterIndex = new HashMap<Integer, Chapter>();
    }

    public Storybook(String key) {
        this();
        setStoryKey(key);
    }

    public Storybook load(Story storyToLoad) {
        setSummary(storyToLoad.getSummary());
        this.chapters.addAll(storyToLoad.getChapters());
        this.initializeAfterLoad();
        return this;
    }

    public String getStoryKey() {
        return storyKey;
    }

    private void setStoryKey(String key) {
        if (this.storyKey != null) {
            throw new IllegalStateException("key is already defined; enforcing immutable key");
        } else if (key == null) {
            throw new IllegalArgumentException("key cannot be set to null");
        }
        this.storyKey = key;
        StorySummary current = (summary != null) ? summary : new StorySummary();
        summary = StorySummary.create(this.storyKey, current.getTitle(), current.getAuthor(), current.getTagLine(),
                current.getAbout(), current.getFirstChapter());
    }

    public Story getStory() {
        return Story.create(summary, new ArrayList<Chapter>(chapters));
    }

    public StorySummary getSummary() {
        return summary;
    }

    public void setSummary(StorySummary summary) {
        this.summary = summary;
    }

    public SortedSet<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters.addAll(chapters);
        reindexChapters();
    }

    public Chapter addChapter() {
        Chapter newChapter = Chapter.createWithPlaceholderText(nextChapterId++);
        chapters.add(newChapter);
        chapterIndex.put(newChapter.getId(), newChapter);
        return newChapter;
    }

    public Chapter getChapter(Integer id) {
        return chapterIndex.get(id);
    }

    private void initializeAfterLoad() {
        this.storyKey = summary.getKey();
        reindexChapters();
    }

    private void reindexChapters() {
        // reload chapter index and set next chapter ID
        int highestChapter = 0;
        if (chapterIndex == null || !chapterIndex.isEmpty()) {
            chapterIndex = new HashMap<Integer, Chapter>();
        }
        for (Chapter chapter : chapters) {
            chapterIndex.put(chapter.getId(), chapter);
            if (chapter.getId() > highestChapter) {
                highestChapter = chapter.getId();
            }
        }
        nextChapterId = highestChapter + 1;
    }

}
