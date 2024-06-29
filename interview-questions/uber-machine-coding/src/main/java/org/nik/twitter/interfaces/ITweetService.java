package org.nik.twitter.interfaces;

import org.nik.twitter.records.TweetResponse;

import java.util.List;

public interface ITweetService {
    TweetResponse create(String userId, String text);

    TweetResponse get(String id);

    List<TweetResponse> getTopLikedTweets(String userId);

    List<TweetResponse> getNewsFeed(String userId);
}
