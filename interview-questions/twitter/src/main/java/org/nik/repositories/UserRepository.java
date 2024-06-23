package org.nik.repositories;

import org.nik.entities.User;
import org.nik.exceptions.UserNotFoundException;

import java.util.HashMap;

public class UserRepository {
    private final HashMap<String, User> users;

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

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User get(String id) {
        if (!users.containsKey(id)) {
            throw new UserNotFoundException("user with id " + id + " not found");
        }
        return users.get(id);
    }
}
