package com.ajegames.storytime.model;

import com.ajegames.util.RandomString;

public class StoryTestUtil {
    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Story generateStory() {
        Story adv = new Story();
        ChapterSign firstChapter = ChapterSign.createExisting(1, fillGenerator.nextKey());
        adv.setSummary(StorySummary.createExisting(keyGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(), firstChapter));
        return adv;
    }
}
