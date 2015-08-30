package com.ajegames.storytime.model;

import org.testng.annotations.Test;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Tests the representation.
 */
public class StoryTest extends RepresentationTestBase {

    private static final Story NORMAL_STORY = buildNormalStory();
    private static final Story EMPTY_STORY = buildEmptyStory();

    @Test
    public void testSerializesToJSON_Normal() throws Exception {
        super.testSerializesToJSON("fixtures/Story-normal.json", Story.class, NORMAL_STORY);
    }

    @Test
    public void testDeserializesFromJSON_Normal() throws Exception {
        super.testDeserializesFromJSON("fixtures/Story-normal.json", Story.class, NORMAL_STORY);
    }

    @Test
    public void testSerializesToJSON_Empty() throws Exception {
        super.testSerializesToJSON("fixtures/Story-empty.json", Story.class, EMPTY_STORY);
    }

    @Test
    public void testDeserializesFromJSON_Empty() throws Exception {
        super.testDeserializesFromJSON("fixtures/Story-empty.json", Story.class, EMPTY_STORY);
    }

    // ==== builders ====

    private static Story buildNormalStory() {

        Story normal = new Story();

        normal.setSummary(
                StorySummary.createExisting("0123456789abcdef", "Rain", "Bubba Gump",
                        "Want a fun adventure?  Just add water.",
                        "Come have an adventure.",
                        ChapterSign.create(1000, "It was a dark and stormy night.")));

        SortedSet<Chapter> chapters = new TreeSet<Chapter>();

        Chapter chapter = Chapter.create(normal, 1000, "Chapter 1", "It was a dark and stormy night.");
        chapter.addNextChapter(ChapterSign.create(1001, "Take a walk in the rain."));
        chapter.addNextChapter(ChapterSign.create(1002, "Stay inside."));
        chapters.add(chapter);

        chapter = Chapter.create(normal, 1001, "Chapter 2",
                "As you step outside, you notice a man with a wide-brimmed hat.  Your adventure has just begun...");
        chapters.add(chapter);

        chapter = Chapter.create(normal, 1002, "Chapter 3",
                "You settle in for a nice evening by the fire.  The End.");
        chapters.add(chapter);

        normal.setChapters(chapters);

        return normal;
    }

    private static Story buildEmptyStory() {
        return new Story();
    }

}
