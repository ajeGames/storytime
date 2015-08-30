package com.ajegames.storytime.model;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<ChapterSign> options = new ArrayList<ChapterSign>();
        options.add(ChapterSign.create(1001, "Take a walk in the rain."));
        options.add(ChapterSign.create(1002, "Stay inside."));
        return Signpost.create(1000, options);
    }

    private static Signpost buildEmptySignpost() {
        return new Signpost();
    }
}
