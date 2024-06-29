package org.nik.twitter;

/*
Design Twitter like system. Implement below functionality -
Post a tweet
Like a tweet
Dislike a tweet
Get Top liked tweets for a user
Follow a user
Unfollow a user
Generate news feed for a user ( consisting of user’s tweets + followee’s tweets in reverse time order)
* */

import org.nik.twitter.interfaces.IReactionService;
import org.nik.twitter.interfaces.ITweetService;
import org.nik.twitter.interfaces.IUserService;
import org.nik.twitter.records.TweetResponse;
import org.nik.twitter.services.ReactionService;
import org.nik.twitter.services.TweetService;
import org.nik.twitter.services.UserService;
import org.nik.twitter.entities.User;

import java.util.List;

public class Twitter {
    private final IUserService userService;
    private final ITweetService tweetService;
    private final IReactionService reactionService;

    public Twitter() {
        userService = UserService.getInstance();
        tweetService = TweetService.getInstance();
        reactionService = ReactionService.getInstance();
    }

    public TweetResponse createTweet(String userId, String text) {
        return tweetService.create(userId, text);
    }

    public void follow(String followerId, String followingId) {
        userService.follow(followerId, followingId);
    }

    public void unfollow(String followerId, String followingId) {
        userService.unfollow(followerId, followingId);
    }

    public List<TweetResponse> getNewsFeed(String userId) {
        return tweetService.getNewsFeed(userId);
    }

    public User createUser(String name) {
        return userService.create(name);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        User userOne = twitter.createUser("Aniket");
        User userTwo = twitter.createUser("Aishu");

        twitter.createTweet(userOne.getId(), "I'm awesome");
        twitter.createTweet(userTwo.getId(), "Me too");

        twitter.follow(userOne.getId(), userTwo.getId());
        System.out.println(twitter.getNewsFeed(userOne.getId()));
        System.out.println();
        System.out.println(twitter.getNewsFeed(userTwo.getId()));
    }
}
