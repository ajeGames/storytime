package com.ajegames.storytime.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;

/**
 * Tests the representation class for stories.
 */
public class StoryTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void testSerializesToJSON() throws Exception {
        Story story = Story.createNew("normal title", "normal author", "this is a normal tag line", "what it is normally about");
        story.setKey("1234abcd");
        Chapter first = story.addChapter();
        first.setId(1000);
        first.setTeaser("once upon a time...");
        story.setFirstChapter(first);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/story-test_normal.json"), Story.class));

        Assert.assertEquals(MAPPER.writeValueAsString(story), expected);
    }
}

/*
  "key": "1234abcd",
  "title": "normal title",
  "author": "normal author",
  "tagLine": "this is a normal tag line",
  "about": "what it is normally about",
  "firstChapter": {
    "id": 1000,
    "teaser": "once upon a time..."
  }
 */