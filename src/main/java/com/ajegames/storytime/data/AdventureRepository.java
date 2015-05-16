package com.ajegames.storytime.data;

import com.ajegames.storytime.model.Adventure;
import com.ajegames.storytime.model.Chapter;
import com.ajegames.util.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AdventureRepository {

    private static AdventureRepository instance;
    private static Logger LOG = LoggerFactory.getLogger(AdventureRepository.class);

    private RandomString keyGenerator;
    private Map<String, Adventure> adventures;

    public static AdventureRepository getInstance() {
        if (instance == null) {
            instance = new AdventureRepository();
        }
        return instance;
    }

    private AdventureRepository() {
        this.keyGenerator = new RandomString(8);
        this.adventures = new HashMap<String, Adventure>();
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


}
