package org.nik.repositories;

import org.nik.entities.Reaction;
import org.nik.exceptions.ReactionCountNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReactionRepository {
    private final HashMap<String, Reaction> reactions;

    private static volatile ReactionRepository instance;

    private ReactionRepository() {
        this.reactions = new HashMap<>();
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

    public void save(Reaction reaction) {
        reactions.put(reaction.getId(), reaction);
    }

    public Reaction get(String id) {
        if (!reactions.containsKey(id)) {
            throw new ReactionCountNotFoundException("Reaction with id " + id + " not found");
        }
        return reactions.get(id);
    }

    public List<Reaction> getPaginatedReactionsOnTweet(String tweetId, int offset, int limit) {
        List<Reaction> result = new ArrayList<>();
        for (Reaction reaction : reactions.values()) {
            if (reaction.getTweetId().equals(tweetId)) {
                result.add(reaction);
            }
        }
        result.sort((a, b) -> Math.toIntExact(b.getCreatedAt() - a.getCreatedAt()));
        return result.subList(offset, offset + limit);
    }
}
