package org.nik.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class ReactionCount {
    private String tweetId;
    private int likeCount;
    private int dislikeCount;
    private int loveCount;
    private int hahaCount;

    public ReactionCount(String tweetId) {
        this.tweetId = tweetId;
        this.likeCount = 0;
        this.dislikeCount = 0;
        this.loveCount = 0;
        this.hahaCount = 0;
    }
}
