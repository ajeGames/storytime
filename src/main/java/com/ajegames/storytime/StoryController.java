package com.ajegames.storytime;

import com.ajegames.storytime.data.StoryTimeRepository;
import com.ajegames.storytime.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controls actions having to do with stories.
 */
public class StoryController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(StoryController.class);

    public StorySummary createStory(StorySummary summary) {
        if (summary.getKey() != null) {
            LOG.warn("Given summary has a key, but create is for new stories; perhaps update was intended.");
            throw new IllegalArgumentException("Either remove key value or do an update");
        }
        LOG.info("Creating a new story entitled: " + summary.getTitle());
        Storybook book = repo.createStorybook();
        Chapter firstChapter = book.addChapter();
        ChapterSign firstSign = ChapterSign.create(firstChapter.getId(), "Your destiny lies ahead.");
        book.setSummary(StorySummary.create(book.getStoryKey(), summary.getTitle(), summary.getAuthor(),
                summary.getTagLine(), summary.getAbout(), firstSign));
        repo.saveStory(book);
        return book.getSummary();
    }

    public Story getStory(String storyKey) {
        LOG.info("Retrieving story with key: " + storyKey);
        return repo.getStorybook(storyKey).getStory();
    }

    public void updateSummary(StorySummary update) {
        LOG.info("Updating story information: " + update.getKey());
        Storybook bookToUpdate = repo.getStorybook(update.getKey());
        if (bookToUpdate == null) {
            throw new IllegalArgumentException("Unable to find story to update");
        }
        bookToUpdate.setSummary(update);
        repo.saveStory(bookToUpdate);
    }

    public Chapter getChapter(String storyKey, Integer chapterId) {
        LOG.info("Retrieving chapter " + chapterId + " for story " + storyKey);
        return retrieveChapter(storyKey, chapterId);
    }

    private Chapter retrieveChapter(String storyKey, Integer chapterId) {
        Storybook book = repo.getStorybook(storyKey);
        if (book == null) {
            return null;
        }
        return book.getChapter(chapterId);
    }

//    public Chapter updateChapter(Chapter update) {
//        LOG.info("Updating chapter " + update.getId() + " for story " + update.getStoryKey().getSummary().getKey());
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
