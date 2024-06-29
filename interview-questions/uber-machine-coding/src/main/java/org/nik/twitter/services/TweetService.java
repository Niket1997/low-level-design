package org.nik.twitter.services;

import org.nik.twitter.entities.Tweet;
import org.nik.twitter.entities.TweetMetadata;
import org.nik.twitter.entities.User;
import org.nik.twitter.interfaces.ITweetService;
import org.nik.twitter.interfaces.IUserService;
import org.nik.twitter.records.TweetResponse;
import org.nik.twitter.repositories.TweetMetadataRepository;
import org.nik.twitter.repositories.TweetRepository;

import java.util.ArrayList;
import java.util.List;

public class TweetService implements ITweetService {
    private final TweetRepository tweetRepository;
    private final TweetMetadataRepository tweetMetadataRepository;
    private final IUserService userService;

    private static volatile TweetService instance;

    private TweetService() {
        tweetRepository = TweetRepository.getInstance();
        tweetMetadataRepository = TweetMetadataRepository.getInstance();
        userService = UserService.getInstance();
    }

    public static TweetService getInstance() {
        if (instance == null) {
            synchronized (TweetService.class) {
                if (instance == null) {
                    instance = new TweetService();
                }
            }
        }
        return instance;
    }

    @Override
    public TweetResponse create(String userId, String text) {
        Tweet tweet = new Tweet(userId, text);
        TweetMetadata tweetMetadata = new TweetMetadata(tweet.getId());
        tweetMetadataRepository.save(tweetMetadata);
        tweetRepository.save(tweet);
        return new TweetResponse(tweet, tweetMetadata);
    }

    @Override
    public TweetResponse get(String id) {
        Tweet tweet = tweetRepository.get(id);
        TweetMetadata tweetMetadata = new TweetMetadata(tweet.getId());
        return new TweetResponse(tweet, tweetMetadata);
    }

    @Override
    public List<TweetResponse> getTopLikedTweets(String userId) {
        List<Tweet> tweets = tweetRepository.getAllTweetsForUser(userId);
        List<TweetResponse> tweetResponseList = new ArrayList<>();
        for (Tweet tweet : tweets) {
            TweetMetadata tweetMetadata = new TweetMetadata(tweet.getId());
            tweetResponseList.add(new TweetResponse(tweet, tweetMetadata));
        }
        tweetResponseList.sort((a, b) -> b.getTweetMetadata().getNumLikes() - a.getTweetMetadata().getNumLikes());
        return tweetResponseList;
    }

    @Override
    public List<TweetResponse> getNewsFeed(String userId) {
        User user = userService.get(userId);
        List<Tweet> tweets = tweetRepository.getAllTweetsForUser(userId);
        for (String following : user.getFollowing()) {
            tweets.addAll(tweetRepository.getAllTweetsForUser(following));
        }

        List<TweetResponse> tweetResponseList = new ArrayList<>();
        for (Tweet tweet : tweets) {
            TweetMetadata tweetMetadata = new TweetMetadata(tweet.getId());
            tweetResponseList.add(new TweetResponse(tweet, tweetMetadata));
        }
        tweetResponseList.sort((a, b) -> Math.toIntExact(b.getTweet().getCreatedAt() - a.getTweet().getCreatedAt()));

        return tweetResponseList;
    }
}
