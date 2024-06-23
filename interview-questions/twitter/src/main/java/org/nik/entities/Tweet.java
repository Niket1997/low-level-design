package org.nik.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class Tweet {
    private String id;
    private String text;
    private String userId;
    private long createdAt;
    private long updatedAt;

    public Tweet(String text, String userId) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.userId = userId;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }
}
