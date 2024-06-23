package org.nik.services;

import org.nik.entities.Newsfeed;
import org.nik.interfaces.INewsFeedService;
import org.nik.repositories.NewsFeedRepository;

public class NewsFeedService implements INewsFeedService {
    private final NewsFeedRepository newsFeedRepository;

    private static volatile NewsFeedService instance;

    private NewsFeedService() {
        this.newsFeedRepository = NewsFeedRepository.getInstance();
    }

    public static NewsFeedService getInstance() {
        if (instance == null) {
            synchronized (NewsFeedService.class) {
                if (instance == null) {
                    instance = new NewsFeedService();
                }
            }
        }
        return instance;
    }

    @Override
    public Newsfeed getNewsFeedForUser(String userId) {
        return newsFeedRepository.get(userId);
    }

    @Override
    public Newsfeed createNewsFeedForUser(String userId) {
        Newsfeed newsfeed = new Newsfeed(userId);
        newsFeedRepository.save(newsfeed);
        return newsfeed;
    }

    @Override
    public Newsfeed updateNewsFeed(Newsfeed newsfeed) {
        newsFeedRepository.save(newsfeed);
        return newsfeed;
    }

    @Override
    public void addTweetToNewsFeed(String userId, String tweetId) {
        Newsfeed newsfeed = getNewsFeedForUser(userId);
        newsfeed.getTweets().add(tweetId);
        newsFeedRepository.save(newsfeed);
    }
}
