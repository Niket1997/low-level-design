package org.nik.repositories;

import org.nik.entities.ReactionCount;
import org.nik.exceptions.ReactionCountNotFoundException;

import java.util.HashMap;

public class ReactionCountRepository {
    private final HashMap<String, ReactionCount> reactionCounts;

    private static volatile ReactionCountRepository instance;

    private ReactionCountRepository() {
        this.reactionCounts = new HashMap<>();
    }

    public static ReactionCountRepository getInstance() {
        if (instance == null) {
            synchronized (ReactionCountRepository.class) {
                if (instance == null) {
                    instance = new ReactionCountRepository();
                }
            }
        }
        return instance;
    }

    public void save(ReactionCount reactionCount) {
        reactionCounts.put(reactionCount.getTweetId(), reactionCount);
    }

    public ReactionCount get(String tweetId) {
        if (!reactionCounts.containsKey(tweetId)) {
            throw new ReactionCountNotFoundException("Reaction count with tweet id " + tweetId + " not found");
        }
        return reactionCounts.get(tweetId);
    }
}
