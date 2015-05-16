package com.ajegames.storytime.model;

import com.ajegames.storytime.data.AdventureRepository;

/**
 * Created by dave on 5/9/15.
 */
public class StoryController {

    public Adventure createAdventure(String title, String author, String tagLine, String description) {
        AdventureRepository repo = AdventureRepository.getInstance();

        Adventure in = Adventure.createNew(title, author, tagLine, description);
        Adventure out = repo.addAdventure(in);

        Chapter firstChapter = new Chapter();


        return out;
    }
}
