package org.nik.twitter.services;

import org.nik.twitter.entities.User;
import org.nik.twitter.interfaces.IUserService;
import org.nik.twitter.repositories.UserRepository;

public class UserService implements IUserService {
    private final UserRepository userRepository;

    private static volatile UserService instance;

    private UserService() {
        userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    @Override
    public User create(String name) {
        User user = new User(name);
        return userRepository.save(user);
    }

    @Override
    public User get(String id) {
        return userRepository.getUser(id);
    }

    @Override
    public void follow(String followerId, String followeeId) {
        User followerUser = get(followerId);
        User folloingUser = get(followeeId);

        followerUser.getFollowing().add(followeeId);
        folloingUser.getFollowers().add(followerId);
    }

    @Override
    public void unfollow(String followerId, String followeeId) {
        User followerUser = get(followerId);
        User folloingUser = get(followeeId);

        followerUser.getFollowing().remove(followeeId);
        folloingUser.getFollowers().remove(followerId);
    }
}
