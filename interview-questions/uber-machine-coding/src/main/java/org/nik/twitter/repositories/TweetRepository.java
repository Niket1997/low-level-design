package org.nik.twitter.repositories;

import org.nik.twitter.entities.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TweetRepository {
    private HashMap<String, Tweet> tweets;

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

    public Tweet save(Tweet tweet) {
        tweets.put(tweet.getId(), tweet);
        return tweet;
    }

    public Tweet get(String id) {
        if (!tweets.containsKey(id)) {
            throw new IllegalArgumentException("Tweet with id " + id + " not found");
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
        return result;
    }
}
