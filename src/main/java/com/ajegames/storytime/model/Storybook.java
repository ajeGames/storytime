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

    public static Storybook createWithKey(String key) {
        Storybook book = new Storybook();
        book.setStoryKey(key);
        return book;
    }

    public static Storybook load(Story storyToLoad) {
        Storybook book = new Storybook();
        book.setSummary(storyToLoad.getSummary());
        book.chapters.addAll(storyToLoad.getChapters());
        book.initializeAfterLoad();
        return book;
    }

    private Storybook() {
        chapters = new TreeSet<Chapter>();
        chapterIndex = new HashMap<Integer, Chapter>();
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

    public Chapter addNextChapterOption(Integer sourceChapterId, String teaser) {
        Chapter fromChapter = getChapter(sourceChapterId);
        if (fromChapter == null) {
            throw new IllegalArgumentException("Source chapter not found");
        }
        Chapter toChapter = addChapter();
        List<ChapterSign> nextChapterOptions = new ArrayList<ChapterSign>(fromChapter.getNextChapterOptions());
        nextChapterOptions.add(ChapterSign.create(toChapter.getId(), teaser));
        fromChapter = Chapter.create(fromChapter.getId(), fromChapter.getHeading(), fromChapter.getProse(),
                nextChapterOptions);
        updateChapter(fromChapter);
        return fromChapter;
    }

    public SortedSet<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters.addAll(chapters);
        reindexChapters();
    }

    public Chapter addChapter() {
        Chapter newChapter = Chapter.createWithID(nextChapterId++);
        chapters.add(newChapter);
        chapterIndex.put(newChapter.getId(), newChapter);
        return newChapter;
    }

    public Chapter getChapter(Integer id) {
        return chapterIndex.get(id);
    }

    public Chapter getFirstChapter() {
        return (summary != null) ?
                getChapter(getSummary().getFirstChapter().getTargetChapterId()) :
                null;
    }

    public void updateChapter(Chapter update) {
        if (update == null || update.getId() == null) {
            throw new IllegalArgumentException("Chapter and ID cannot be null");
        }
        Chapter toUpdate = getChapter(update.getId());
        if (toUpdate == null) {
            throw new IllegalArgumentException("Chapter not found; cannot update");
        }
        chapters.remove(toUpdate);
        chapterIndex.remove(toUpdate.getId());

        chapters.add(update);
        chapterIndex.put(update.getId(), update);
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
