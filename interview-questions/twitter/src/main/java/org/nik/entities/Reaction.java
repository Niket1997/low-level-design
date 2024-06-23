package org.nik.entities;

import lombok.Data;
import org.nik.enums.ReactionType;

import java.util.UUID;

@Data
public class Reaction {
    private String id;
    private String tweetId;
    private String userId;
    private ReactionType reactionType;
    private Long createdAt;

    public Reaction(String tweetId, String userId, ReactionType reactionType) {
        this.id = UUID.randomUUID().toString();
        this.tweetId = tweetId;
        this.userId = userId;
        this.reactionType = reactionType;
        this.createdAt = System.currentTimeMillis();
    }
}
