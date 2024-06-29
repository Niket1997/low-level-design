package org.nik.twitter.interfaces;

import org.nik.twitter.entities.Reaction;
import org.nik.twitter.enums.ReactionType;

import java.util.List;

public interface IReactionService {
    void react(String tweetId, String userId, ReactionType reactionType);

    List<Reaction> getReactions(String tweetId);
}
