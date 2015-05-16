package com.ajegames.storytime.model;

import com.ajegames.storytime.data.AdventureRepository;

/**
 * Created by dave on 5/9/15.
 */
public class StoryController {

    private static AdventureRepository repo = AdventureRepository.getInstance();

    public Adventure createAdventure(String title, String author, String tagLine, String description) {
        Adventure in = Adventure.createNew(title, author, tagLine, description);
        Adventure out = repo.addAdventure(in);
        out.setFirstChapter(out.addChapter());
        return out;
    }

    public Adventure getAdventure(String key) {
        return repo.getAdventure(key);
    }
}
