package org.nik.interfaces;

import org.nik.entities.ReactionCount;
import org.nik.entities.Tweet;

public interface IReactionCountService {
    ReactionCount createReactionCountForTweet(String tweetId);

    ReactionCount getReactionCountForTweet(String tweetId);

    void updateReactionCountForTweet(ReactionCount reactionCount);
}
