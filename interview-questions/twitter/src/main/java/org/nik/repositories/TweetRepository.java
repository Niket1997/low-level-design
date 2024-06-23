package org.nik.repositories;

import org.nik.entities.Tweet;
import org.nik.exceptions.TweetNotFoundException;

import java.util.*;

public class TweetRepository {
    private final HashMap<String, Tweet> tweets;

    private static volatile TweetRepository instance;

    private TweetRepository() {
        tweets = new HashMap<>();
    }

    public static TweetRepository getInstance() {
        if (instance == null) {
            synchronized (TweetRepository.class) {
                if (instance == null) {
                    instance = new TweetRepository();
                }
            }
        }
        return instance;
    }

    public void save(Tweet tweet) {
        tweets.put(tweet.getId(), tweet);
    }

    public Tweet get(String id) {
        if (!tweets.containsKey(id)) {
            throw new TweetNotFoundException("tweet with id: " + id + " not found");
        }
        return tweets.get(id);
    }

    public List<Tweet> getAllTweetsForUser(String userId) {
        List<Tweet> result = new ArrayList<>();
        for (Tweet tweet : tweets.values()) {
            if (tweet.getUserId().equals(userId)) {
                result.add(tweet);
            }
        }
        result.sort((a, b) -> Math.toIntExact(b.getCreatedAt() - a.getCreatedAt()));
        return result;
    }
}
