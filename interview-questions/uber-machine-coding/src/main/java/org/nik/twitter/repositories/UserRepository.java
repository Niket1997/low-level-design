package org.nik.twitter.repositories;

import org.nik.twitter.entities.User;

import java.util.HashMap;

public class UserRepository {
    private HashMap<String, User> users;

    private static volatile UserRepository instance;

    private UserRepository() {
        users = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String id) {
        if (!users.containsKey(id)) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        return users.get(id);
    }
}
