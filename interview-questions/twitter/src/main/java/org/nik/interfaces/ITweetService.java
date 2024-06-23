package org.nik.interfaces;

import org.nik.entities.Tweet;

import java.util.List;

public interface ITweetService {
    Tweet postTweet(String userId, String text);

    Tweet getTweet(String tweetId);

    List<Tweet> getTopLikedTweetsForUser(String userId, int count);
}
