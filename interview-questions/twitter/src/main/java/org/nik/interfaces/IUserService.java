package org.nik.interfaces;

import org.nik.entities.User;

public interface IUserService {
    User getUser(String id);

    User createUser(String name);

    void followUser(String followerId, String followeeId);

    void unfollowUser(String followerId, String followeeId);
}
