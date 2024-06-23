package org.nik.entities;

import lombok.Data;

import java.util.*;

@Data
public class User {
    private String id;
    private String name;
    private List<String> tweets;
    private Set<String> followers;
    private Set<String> followee;
    private long createdAt;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tweets = new ArrayList<>();
        this.followers = new HashSet<>();
        this.followee = new HashSet<>();
        this.createdAt = System.currentTimeMillis();
    }
}
