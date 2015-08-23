package com.ajegames.storytime.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;

/**
 * Tests the representation class for stories.
 */
public class StorySummaryTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testSerializesToJSON() throws Exception {
        final ChapterSign firstChapter = ChapterSign.createExisting(1000, "once upon a time...");
        final StorySummary story = StorySummary.createExisting("1234abcd", "normal title", "normal author",
                "this is a normal tag line", "what it is normally about", firstChapter);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/story-test_normal.json"), Story.class));

        Assert.assertEquals(MAPPER.writeValueAsString(story), expected);
    }
}
