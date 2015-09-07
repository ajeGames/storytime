package com.ajegames.storytime.model;

import com.ajegames.util.RandomString;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class StoryTestUtil {
    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Story generateStory() {
        return Story.create(StorySummary.create(keyGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                ChapterSign.create(1, fillGenerator.nextKey())),
                null);
    }

    public static Story generateSimpleNonTrivialStory() {

        SortedSet<Chapter> chapters = new TreeSet<Chapter>();
        List<ChapterSign> options = new ArrayList<ChapterSign>();
        options.add(ChapterSign.create(1001, fillGenerator.nextKey()));
        options.add(ChapterSign.create(1002, fillGenerator.nextKey()));
        chapters.add(Chapter.create(1000, fillGenerator.nextKey(), fillGenerator.nextKey(), options));
        chapters.add(Chapter.create(1001, fillGenerator.nextKey(), fillGenerator.nextKey(), null));
        chapters.add(Chapter.create(1002, fillGenerator.nextKey(), fillGenerator.nextKey(), null));

        return Story.create(
                StorySummary.create(keyGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                        fillGenerator.nextKey(), fillGenerator.nextKey(),
                        ChapterSign.create(1000, fillGenerator.nextKey())),
                new ArrayList<Chapter>(chapters));
    }

    public static Story generateStoryWithoutKey() {
        return Story.create(
                createWithoutKey(fillGenerator.nextKey(), fillGenerator.nextKey(),
                        fillGenerator.nextKey(), fillGenerator.nextKey()),
                null);
    }

    public static StorySummary createWithoutKey(String title, String author, String tagLine, String about) {
        return StorySummary.create(null, title, author, tagLine, about, null);
    }

}
