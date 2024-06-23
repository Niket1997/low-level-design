package org.nik.services;

import org.nik.entities.ReactionCount;
import org.nik.entities.Tweet;
import org.nik.entities.User;
import org.nik.interfaces.INewsFeedService;
import org.nik.interfaces.IReactionCountService;
import org.nik.interfaces.ITweetService;
import org.nik.interfaces.IUserService;
import org.nik.repositories.TweetRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetService implements ITweetService {
    private final TweetRepository tweetRepository;
    private final IReactionCountService reactionCountService;
    private final INewsFeedService newsFeedService;
    private final IUserService userService;

    public TweetService() {
        this.tweetRepository = TweetRepository.getInstance();
        this.reactionCountService = ReactionCountService.getInstance();
        this.newsFeedService = NewsFeedService.getInstance();
        this.userService = UserService.getInstance();
    }

    @Override
    public Tweet postTweet(String userId, String text) {
        Tweet tweet = new Tweet(userId, text);
        ReactionCount reactionCount = reactionCountService.createReactionCountForTweet(tweet.getId());
        tweetRepository.save(tweet);

        // do fanout
        User user = userService.getUser(userId);
        for (String followerId : user.getFollowers()) {
            newsFeedService.addTweetToNewsFeed(followerId, tweet.getId());
        }
        newsFeedService.addTweetToNewsFeed(userId, tweet.getId());

        return tweet;
    }

    @Override
    public Tweet getTweet(String tweetId) {
        return tweetRepository.get(tweetId);
    }

    @Override
    public List<Tweet> getTopLikedTweetsForUser(String userId, int count) {
        List<Tweet> result = tweetRepository.getAllTweetsForUser(userId);
        Map<String, ReactionCount> reactionCountsForTweet = new HashMap<>();
        for (Tweet tweet : result) {
            reactionCountsForTweet.put(tweet.getId(), reactionCountService.getReactionCountForTweet(tweet.getId()));
        }
        result.sort((a, b) -> reactionCountsForTweet.get(b.getId()).getLikeCount() - reactionCountsForTweet.get(a.getId()).getLikeCount());
        return result.subList(0, Math.min(count, result.size()));
    }
}
