package com.ajegames.storytime.model;

import com.ajegames.storytime.data.StoryTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controls actions having to do with stories.
 */
public class StoryController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(StoryController.class);

    public Story createStory(String title, String author, String tagLine, String description) {
        LOG.debug("Creating a new story entitled: " + title);
        Story in = Story.createNew(title, author, tagLine, description);
        Story out = repo.addStory(in);
        out.setFirstChapter(out.addChapter());
        repo.saveStory(out.getKey());
        return out;
    }

    public Story getStory(String storyKey) {
        LOG.debug("Retrieving story with key: " + storyKey);
        return repo.getStory(storyKey);
    }

    public Story updateStory(Story update) {
        LOG.debug("Updating story information: " + update.getKey());
        Story story = getStory(update.getKey());
        if (story == null) {
            throw new IllegalArgumentException("Unable to find story to update");
        }
        if (update.getTitle() != null) {
            story.setTitle(update.getTitle());
        }
        if (update.getAuthor() != null) {
            story.setAuthor(update.getAuthor());
        }
        if (update.getTagLine() != null) {
            story.setTagLine(update.getTagLine());
        }
        if (update.getDescription() != null) {
            story.setDescription(update.getDescription());
        }
        repo.saveStory(story.getKey());
        return story;
    }

    public Chapter getChapter(String storyKey, Integer chapterId) {
        LOG.debug("Retrieving chapter " + chapterId + " for story " + storyKey);
        return retrieveChapter(storyKey, chapterId);
    }

    private Chapter retrieveChapter(String storyKey, Integer chapterId) {
        Story story = repo.getStory(storyKey);
        if (story == null) {
            return null;
        }
        return story.getChapter(chapterId);
    }

    public Chapter updateChapter(String storyKey, Chapter update) {
        LOG.debug("Updating chapter " + update.getId() + " for story " + storyKey);
        Chapter chap = retrieveChapter(storyKey, update.getId());
        if (update.getTeaser() != null) {
            chap.setTeaser(update.getTeaser());
        }
        if (update.getHeading() != null) {
            chap.setHeading(update.getHeading());
        }
        if (update.getProse() != null) {
            chap.setProse(update.getProse());
        }
        repo.saveStory(storyKey);
        return chap;
    }

    public Chapter addNextChapter(String storyKey, Integer parentChapterId, String teaser) {
        LOG.debug("Creating next chapter options for chapter " + parentChapterId + " of story " + storyKey + ": "
                + teaser);
        Story story = repo.getStory(storyKey);
        Chapter parent = story.getChapter(parentChapterId);
        Chapter chap = story.addChapter();
        chap.setTeaser(teaser);
        parent.addNextChapter(chap);
        repo.saveStory(storyKey);
        return chap;
    }

    public void deleteStory(String storyKey) {
        LOG.debug("Deleting story: " + storyKey);
        repo.deleteStory(storyKey);
    }

    /**
     * TODO How is this going to work?
     * How to detach and reattach chapter chains?
     * How to detect chapters that are not attached?
     * Whether to delete an entire chapter chain?
     * What to do when first chapter is deleted?
     */

}
