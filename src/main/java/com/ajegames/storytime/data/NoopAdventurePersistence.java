package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NoopAdventurePersistence implements AdventurePersistence {

    private static Logger LOG = LoggerFactory.getLogger(NoopAdventurePersistence.class);

    public List<Adventure> loadAdventures() {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return null;
    }

    public void saveAdventure(Adventure adventure) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
    }

    public boolean deleteAdventure(Adventure adventure) {
        LOG.warn("This implementation does nothing, which is fine for testing.");
        return false;
    }
}
