package com.ajegames.storytime.model;

import com.ajegames.storytime.data.StoryTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by dmount on 5/22/15.
 */
public class CatalogController {

    private static StoryTimeRepository repo = StoryTimeRepository.getInstance();
    private static Logger LOG = LoggerFactory.getLogger(CatalogController.class);

    public List<Story> getAllStories() {
        LOG.info("Fetching all stories in repository");
        return repo.getAllStories();
    }
}
