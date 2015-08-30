package com.ajegames.storytime.model;

import org.testng.annotations.Test;

/**
 * Tests the Signpost representation.
 */
public class SignpostTest extends RepresentationTestBase {

    private static Signpost NORMAL_SIGNPOST = buildNormalSignpost();
    private static Signpost EMPTY_SIGNPOST = buildEmptySignpost();

    @Test
    public void testSerializesToJSON_Normal() throws Exception {
        super.testSerializesToJSON("fixtures/Signpost-normal.json", Signpost.class, NORMAL_SIGNPOST);
    }

    @Test
    public void testDeserializesToJSON_Normal() throws Exception {
        super.testDeserializesFromJSON("fixtures/Signpost-normal.json", Signpost.class, NORMAL_SIGNPOST);
    }

    @Test
    public void testSerializesToJSON_Empty() throws Exception {
        super.testSerializesToJSON("fixtures/Signpost-empty.json", Signpost.class, EMPTY_SIGNPOST);
    }

    @Test
    public void testDeserializesToJSON_Empty() throws Exception {
        super.testDeserializesFromJSON("fixtures/Signpost-empty.json", Signpost.class, EMPTY_SIGNPOST);
    }

    // ==== builders ====

    private static Signpost buildNormalSignpost() {
        Signpost post = new Signpost();
        post.setFromChapterId(1000);
        post.addNextChapterOption(ChapterSign.create(1001, "Take a walk in the rain."));
        post.addNextChapterOption(ChapterSign.create(1002, "Stay inside."));
        return post;
    }

    private static Signpost buildEmptySignpost() {
        return new Signpost();
    }
}
