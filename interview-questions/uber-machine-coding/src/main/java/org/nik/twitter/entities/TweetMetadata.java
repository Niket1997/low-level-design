package org.nik.twitter.entities;

import lombok.Data;

@Data
public class TweetMetadata {
    private String tweetId;
    private int numLikes;
    private int numComments;

    public TweetMetadata(String tweetId) {
        this.tweetId = tweetId;
        this.numLikes = 0;
        this.numComments = 0;
    }
}
