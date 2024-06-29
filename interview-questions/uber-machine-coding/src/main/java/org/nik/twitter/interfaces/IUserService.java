package org.nik.twitter.interfaces;

import org.nik.twitter.entities.User;

public interface IUserService {
    User create(String name);

    User get(String id);

    void follow(String followerId, String followeeId);

    void unfollow(String followerId, String followeeId);
}
