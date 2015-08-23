package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.Chapter;
import com.ajegames.storytime.model.ChapterSign;
import com.ajegames.storytime.model.Story;
import com.ajegames.storytime.model.StorySummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controls actions having to do with stories.
 */
public class StoryController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(StoryController.class);

    public Story createStory(String title, String author, String tagLine, String description) {
        LOG.info("Creating a new story entitled: " + title);
        Story in = new Story();
        in.setSummary(StorySummary.createNew(title, author, tagLine, description));
        Story out = repo.registerNewStory(in);
        Chapter first = out.addChapter();
        ChapterSign firstSign = ChapterSign.createExisting(first.getId(), "Your destiny lies ahead.");
        out.getSummary().setFirstChapter(firstSign);
        repo.saveStory(out);
        return out;
    }

    public Story getStory(String storyKey) {
        LOG.info("Retrieving story with key: " + storyKey);
        return repo.getStory(storyKey);
    }

    // TODO considering converting to immutable representation classes

    public void updateSummary(StorySummary update) {
        LOG.info("Updating story information: " + update.getKey());
        Story storyToUpdate = getStory(update.getKey());
        if (storyToUpdate == null) {
            throw new IllegalArgumentException("Unable to find story to update");
        }
        storyToUpdate.setSummary(update);
        repo.saveStory(storyToUpdate);
    }

    public Chapter getChapter(String storyKey, Integer chapterId) {
        LOG.info("Retrieving chapter " + chapterId + " for story " + storyKey);
        return retrieveChapter(storyKey, chapterId);
    }

    private Chapter retrieveChapter(String storyKey, Integer chapterId) {
        Story story = repo.getStory(storyKey);
        if (story == null) {
            return null;
        }
        return story.getChapter(chapterId);
    }

//    public Chapter updateChapter(Chapter update) {
//        LOG.info("Updating chapter " + update.getId() + " for story " + update.getMyStory().getSummary().getKey());
//        Chapter chap = retrieveChapter(storyKey, update.getId());
//        if (update.getHeading() != null) {
//            chap.setHeading(update.getHeading());
//        }
//        if (update.getProse() != null) {
//            chap.setProse(update.getProse());
//        }
//        repo.saveStory(update.getStory());
//        return chap;
//    }
//
//    public Chapter addNextChapter(String storyKey, Integer parentChapterId, String teaser) {
//        LOG.info("Creating next chapter options for chapter " + parentChapterId + " of story " + storyKey + ": "
//                + teaser);
//        Story story = repo.getStory(storyKey);
//        Chapter parent = story.getChapter(parentChapterId);
//        Chapter chap = story.addChapter();
//        chap.setTeaser(teaser);
//        parent.addNextChapter(chap);
//        repo.saveStory(storyKey);
//        return chap;
//    }

    public void deleteStory(String storyKey) {
        LOG.info("Deleting story: " + storyKey);
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
