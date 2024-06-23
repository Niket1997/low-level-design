package org.nik.interfaces;

import org.nik.entities.User;
import org.nik.enums.ReactionType;

public interface IReactionService {
    void react(String tweetId, String userId, ReactionType reactionType);
}
