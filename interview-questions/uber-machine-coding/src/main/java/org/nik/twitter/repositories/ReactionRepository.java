package org.nik.twitter.repositories;

import org.nik.twitter.entities.Reaction;

import java.util.*;

public class ReactionRepository {
    private HashMap<String, Reaction> reactions;

    private static volatile ReactionRepository instance;

    private ReactionRepository() {
        reactions = new HashMap<>();
    }

    public static ReactionRepository getInstance() {
        if (instance == null) {
            synchronized (ReactionRepository.class) {
                if (instance == null) {
                    instance = new ReactionRepository();
                }
            }
        }
        return instance;
    }

    public Reaction save(Reaction reaction) {
        reactions.put(reaction.getId(), reaction);
        return reaction;
    }

    public Reaction get(String id) {
        if (!reactions.containsKey(id)) {
            throw new IllegalArgumentException("Reaction with id " + id + " not found");
        }
        return reactions.get(id);
    }

    public List<Reaction> getReactionsForTweet(String tweetId) {
        List<Reaction> result = new ArrayList<>();
        for (Reaction reaction : reactions.values()) {
            if (reaction.getTweetId().equals(tweetId)) {
                result.add(reaction);
            }
        }
        result.sort((a, b) -> Math.toIntExact(b.getCreatedAt() - a.getCreatedAt()));
        return result;
    }
}
