package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NoopAdventurePersistence implements AdventurePersistence {

    private static Logger LOG = LoggerFactory.getLogger(NoopAdventurePersistence.class);

    public List<Story> loadAdventures() {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return null;
    }

    public void saveAdventure(Story story) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
    }

    public boolean deleteAdventure(Story story) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return false;
    }
}
