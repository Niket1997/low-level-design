package org.nik.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Newsfeed {
    private String userId;
    private List<String> tweets;

    public Newsfeed(String userId) {
        this.userId = userId;
        this.tweets = new ArrayList<>();
    }
}
