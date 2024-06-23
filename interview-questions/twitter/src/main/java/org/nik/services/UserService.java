package org.nik.services;

import org.nik.entities.Newsfeed;
import org.nik.entities.User;
import org.nik.interfaces.INewsFeedService;
import org.nik.interfaces.IUserService;
import org.nik.repositories.UserRepository;

public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final INewsFeedService newsFeedService;

    private static volatile UserService userService;

    private UserService() {
        this.userRepository = UserRepository.getInstance();
        this.newsFeedService = NewsFeedService.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            synchronized (UserService.class) {
                if (userService == null) {
                    userService = new UserService();
                }
            }
        }
        return userService;
    }

    @Override
    public User getUser(String id) {
        return userRepository.get(id);
    }

    @Override
    public User createUser(String name) {
        User user = new User(name);
        Newsfeed newsfeed = newsFeedService.createNewsFeedForUser(user.getId());
        userRepository.save(user);
        return user;
    }

    @Override
    public void followUser(String followerId, String followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.getFollowee().add(followeeId);
        followee.getFollowers().add(followerId);
    }

    @Override
    public void unfollowUser(String followerId, String followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.getFollowee().remove(followeeId);
        followee.getFollowers().remove(followerId);
    }
}
