package org.nik.twitter.entities;

import lombok.Data;
import org.nik.twitter.enums.ReactionType;

@Data
public class Reaction {
    private String id;
    private String tweetId;
    private ReactionType reactionType;
    private long createdAt;

    public Reaction(String id, String tweetId, ReactionType reactionType) {
        this.id = id;
        this.tweetId = tweetId;
        this.reactionType = reactionType;
        this.createdAt = System.currentTimeMillis();
    }
}
