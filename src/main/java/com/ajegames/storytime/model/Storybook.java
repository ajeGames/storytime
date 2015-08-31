package com.ajegames.storytime.model;

import java.util.*;

/**
 * Mutable class that handles dynamic parts of the story, aggregations, indexes, etc.  This is not meant to be passed
 * around via JSON, but it holds all of the parts that are.  The goal is to allow representation classes to be
 * immutable, while all of the action is handled here.  In short, the "bookkeeping" happens here.
 */
public class Storybook {

    private int nextChapterId = 1000;
    private StorySummary summary;
    private SortedSet<Chapter> chapters;
    private Map<Integer, Chapter> chapterIndex;

    public Storybook() {
        chapters = new TreeSet<Chapter>();
        chapterIndex = new HashMap<Integer, Chapter>();
    }

    public Storybook load(Story storyToLoad) {
        this.summary = storyToLoad.getSummary();
        this.chapters.addAll(storyToLoad.getChapters());
        this.initializeAfterLoad();
        return this;
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
    }

    public Map<Integer, Chapter> getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(Map<Integer, Chapter> chapterIndex) {
        this.chapterIndex = chapterIndex;
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

}
