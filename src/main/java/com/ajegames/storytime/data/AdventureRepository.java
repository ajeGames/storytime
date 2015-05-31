package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Story;
import com.ajegames.util.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureRepository {

    private static AdventureRepository instance;
    private static Logger LOG = LoggerFactory.getLogger(AdventureRepository.class);

    private RandomString keyGenerator;
    private Map<String, Story> adventures;
    private AdventurePersistence storage;

    public static AdventureRepository getInstance() {
        if (instance == null) {
            instance = new AdventureRepository();
        }
        return instance;
    }

    private AdventureRepository() {
        this.keyGenerator = new RandomString(8);
        this.adventures = new HashMap<String, Story>();
        this.storage = new NoopAdventurePersistence();
    }

    public void setPersistence(AdventurePersistence persistenceImpl) {
        LOG.info("Setting persistence mechanism");
        if (persistenceImpl == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        this.storage = persistenceImpl;
        loadAdventures();
    }

    public void loadAdventures() {
        List<Story> stories = storage.loadAdventures();
        LOG.info("Loading " + stories.size() + " stories");
        for (Story adv : stories) {
            addAdventure(adv);
        }
    }

    public void saveAdventure(String key) {
        LOG.info("Saving adventure: " + key);
        Story adv = getAdventure(key);
        this.storage.saveAdventure(adv);
    }

    public Story addAdventure(Story adv) {
        LOG.info("Adding adventure: " + adv.getKey());
        // assign key if needed
        String tempKey = adv.getKey();
        if (tempKey == null) {
            do {
                tempKey = keyGenerator.nextKey();
            } while (adventures.containsKey(tempKey));
            adv.setKey(tempKey);
        }
        adventures.put(tempKey, adv);
        return adv;
    }

    public Story getAdventure(String key) {
        return adventures.get(key);
    }

    public void deleteAdventure(String key) {
        LOG.info("Deleting adventure: " + key);
        storage.deleteAdventure(getAdventure(key));
        adventures.remove(key);
    }

    public List<Story> getAllAdventures() {
        LOG.info("Retrieving full list of adventures");
        List<Story> all = new ArrayList<Story>();
        all.addAll(adventures.values());
        return all;
    }
}
