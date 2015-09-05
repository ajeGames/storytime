package com.ajegames.storytime.model;

import com.ajegames.util.RandomString;

public class StoryTestUtil {
    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Story generateStory() {
        return Story.create(StorySummary.create(keyGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                ChapterSign.create(1, fillGenerator.nextKey())),
                null);
    }
}
