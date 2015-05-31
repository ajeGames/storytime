package com.ajegames.storytime.model;

import com.ajegames.util.RandomString;

public class StoryTestUtil {
    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Story generateStory() {
        Story adv = Story.createNew(fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey());
        adv.setKey(keyGenerator.nextKey());
        adv.setFirstChapter(fillValues(adv.addChapter()));
        adv.getFirstChapter().addNextChapter(fillValues(adv.addChapter()));
        return adv;
    }

    public static Chapter fillValues(Chapter chapter) {
        chapter.setTeaser(fillGenerator.nextKey());
        chapter.setHeading(fillGenerator.nextKey());
        chapter.setProse(fillGenerator.nextKey());
        return chapter;
    }
}
