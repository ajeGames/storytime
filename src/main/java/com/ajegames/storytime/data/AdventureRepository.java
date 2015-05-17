package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;
import com.ajegames.util.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureRepository {

    private static AdventureRepository instance;
    private static Logger LOG = LoggerFactory.getLogger(AdventureRepository.class);

    private RandomString keyGenerator;
    private Map<String, Adventure> adventures;
    private AdventurePersistence storage;

    public static AdventureRepository getInstance() {
        if (instance == null) {
            instance = new AdventureRepository();
        }
        return instance;
    }

    private AdventureRepository() {
        this.keyGenerator = new RandomString(8);
        this.adventures = new HashMap<String, Adventure>();
        this.storage = new NoopAdventurePersistence();
    }

    public void setPersistence(AdventurePersistence persistenceImpl) {
        if (persistenceImpl == null) {
            throw new IllegalArgumentException("Persistence mechanism cannot be null");
        }
        this.storage = persistenceImpl;
        loadAdventures();
    }

    public void loadAdventures() {
        List<Adventure> adventures = storage.loadAdventures();
        for (Adventure adv : adventures) {
            addAdventure(adv);
        }
    }

    public Adventure addAdventure(Adventure adv) {
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

    public Adventure getAdventure(String key) {
        return adventures.get(key);
    }

    public void deleteAdventure(String key) {
        adventures.remove(key);
    }
}
