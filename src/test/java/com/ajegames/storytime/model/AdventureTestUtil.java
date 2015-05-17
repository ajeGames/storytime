package com.ajegames.storytime.model;

import com.ajegames.util.RandomString;

public class AdventureTestUtil {
    private static RandomString keyGenerator = new RandomString(8);
    private static RandomString fillGenerator = new RandomString(16);

    public static Adventure generateAdventureWithoutKey() {
        return Adventure.createNew(fillGenerator.nextKey(), fillGenerator.nextKey(), fillGenerator.nextKey(),
                fillGenerator.nextKey());
    }
}
