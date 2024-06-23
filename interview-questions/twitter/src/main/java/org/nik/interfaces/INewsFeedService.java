package org.nik.interfaces;

import org.nik.entities.Newsfeed;

public interface INewsFeedService {
    Newsfeed getNewsFeedForUser(String userId);

    Newsfeed createNewsFeedForUser(String userId);

    Newsfeed updateNewsFeed(Newsfeed newsfeed);

    void addTweetToNewsFeed(String userId, String tweetId);
}
