package org.nik.twitter.entities;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class User {
    private String id;
    private String name;
    private Set<String> followers;
    private Set<String> following;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }
}
