package org.nik.repositories;

import org.nik.entities.Newsfeed;
import org.nik.exceptions.NewsfeedNotFoundException;

import java.util.HashMap;

public class NewsFeedRepository {
    private final HashMap<String, Newsfeed> newsfeedHashMap;

    private static volatile NewsFeedRepository instance;

    private NewsFeedRepository() {
        newsfeedHashMap = new HashMap<>();
    }

    public static NewsFeedRepository getInstance() {
        if (instance == null) {
            synchronized (NewsFeedRepository.class) {
                if (instance == null) {
                    instance = new NewsFeedRepository();
                }
            }
        }
        return instance;
    }

    public void save(Newsfeed newsfeed) {
        newsfeedHashMap.put(newsfeed.getUserId(), newsfeed);
    }

    public Newsfeed get(String userId) {
        if (!newsfeedHashMap.containsKey(userId)) {
            throw new NewsfeedNotFoundException("Newsfeed for user id " + userId + " not found");
        }
        return newsfeedHashMap.get(userId);
    }
}
