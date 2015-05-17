package com.ajegames.storytime.model;

import com.ajegames.storytime.data.AdventureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controls actions having to do with stories.
 */
public class StoryController {

    private static AdventureRepository repo = AdventureRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(StoryController.class);

    public Adventure createAdventure(String title, String author, String tagLine, String description) {
        LOG.info("Creating a new adventure entitled: " + title);
        Adventure in = Adventure.createNew(title, author, tagLine, description);
        Adventure out = repo.addAdventure(in);
        out.setFirstChapter(out.addChapter());
        return out;
    }

    public Adventure getAdventure(String key) {
        LOG.info("Retrieving adventure with key: " + key);
        return repo.getAdventure(key);
    }

    public Adventure updateAdventure(Adventure update) {
        LOG.info("Updating adventure information: " + update.getKey());
        Adventure adv = getAdventure(update.getKey());
        if (adv == null) {
            throw new IllegalArgumentException("Unable to find story to update");
        }
        if (update.getTitle() != null) {
            adv.setTitle(update.getTitle());
        }
        if (update.getAuthor() != null) {
            adv.setAuthor(update.getAuthor());
        }
        if (update.getTagLine() != null) {
            adv.setTagLine(update.getTagLine());
        }
        if (update.getDescription() != null) {
            adv.setDescription(update.getDescription());
        }
        return adv;
    }

    public Chapter getChapter(String adventureKey, Integer chapterId) {
        LOG.info("Retrieving chapter " + chapterId + " for adventure " + adventureKey);
        Adventure adv = repo.getAdventure(adventureKey);
        Chapter chap = adv.getChapter(chapterId);
        return chap;
    }

    public Chapter updateChapter(String adventureKey, Chapter update) {
        LOG.info("Updating chapter " + update.getId() + " for adventure " + adventureKey);
        Chapter chap = getChapter(adventureKey, update.getId());
        if (update.getTeaser() != null) {
            chap.setTeaser(update.getTeaser());
        }
        if (update.getHeading() != null) {
            chap.setHeading(update.getHeading());
        }
        if (update.getProse() != null) {
            chap.setProse(update.getProse());
        }
        return chap;
    }
}
