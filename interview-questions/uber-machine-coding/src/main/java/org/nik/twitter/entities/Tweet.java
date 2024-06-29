package org.nik.twitter.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class Tweet {
    private String id;
    private String text;
    private String userId;
    private long createdAt;

    public Tweet(String userId, String text) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.userId = userId;
        this.createdAt = System.currentTimeMillis();
    }
}
