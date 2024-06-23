package org.nik.services;

import org.nik.entities.ReactionCount;
import org.nik.interfaces.IReactionCountService;
import org.nik.repositories.ReactionCountRepository;

public class ReactionCountService implements IReactionCountService {
    private final ReactionCountRepository reactionCountRepository;

    private static volatile ReactionCountService instance;

    private ReactionCountService() {
        this.reactionCountRepository = ReactionCountRepository.getInstance();
    }

    public static ReactionCountService getInstance() {
        if (instance == null) {
            synchronized (ReactionCountService.class) {
                if (instance == null) {
                    instance = new ReactionCountService();
                }
            }
        }
        return instance;
    }

    @Override
    public ReactionCount createReactionCountForTweet(String tweetId) {
        ReactionCount reactionCount = new ReactionCount(tweetId);
        reactionCountRepository.save(reactionCount);
        return reactionCount;
    }

    @Override
    public ReactionCount getReactionCountForTweet(String tweetId) {
        return reactionCountRepository.get(tweetId);
    }

    @Override
    public void updateReactionCountForTweet(ReactionCount reactionCount) {
        reactionCountRepository.save(reactionCount);
    }
}
