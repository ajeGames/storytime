package com.ajegames.storytime.model;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the representation.
 */
public class StorySummaryTest extends RepresentationTestBase {

    private static final StorySummary NORMAL_STORY_SUMMARY = buildStorySummary();

    @Test
    public void testSerializesToJSON_Normal() throws Exception {
        super.testSerializesToJSON("fixtures/StorySummary-normal.json", StorySummary.class, NORMAL_STORY_SUMMARY);
    }

    @Test
    public void testDeserializesFromJSON_Normal() throws Exception {
        super.testDeserializesFromJSON("fixtures/StorySummary-normal.json", StorySummary.class, NORMAL_STORY_SUMMARY);
    }

    @Test
    public void testSerializesToJSON_ExtraFields() throws Exception {
        try {
            super.testSerializesToJSON("fixtures/StorySummary-extraFields.json", StorySummary.class,
                    NORMAL_STORY_SUMMARY);
        } catch (UnrecognizedPropertyException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void testDeserializesFromJSON_ExtraFields() throws Exception {
        try {
            super.testDeserializesFromJSON("fixtures/StorySummary-extraFields.json", StorySummary.class,
                    NORMAL_STORY_SUMMARY);
        } catch (UnrecognizedPropertyException e) {
            return;
        }
        Assert.fail();
    }

    // ==== builders ====

    private static StorySummary buildStorySummary() {
        final ChapterSign firstChapter = ChapterSign.create(1000, "once upon a time...");
        return StorySummary.createExisting("1234abcd", "normal title", "normal author",
                "this is a normal tag line", "what it is normally about", firstChapter);
    }

}