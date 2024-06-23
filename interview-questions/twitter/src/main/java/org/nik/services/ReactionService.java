package org.nik.services;

import org.nik.entities.Reaction;
import org.nik.entities.ReactionCount;
import org.nik.enums.ReactionType;
import org.nik.interfaces.IReactionCountService;
import org.nik.interfaces.IReactionService;
import org.nik.repositories.ReactionRepository;

public class ReactionService implements IReactionService {
    private final ReactionRepository reactionRepository;
    private final IReactionCountService reactionCountService;

    private static volatile ReactionService instance;

    private ReactionService() {
        this.reactionRepository = ReactionRepository.getInstance();
        this.reactionCountService = ReactionCountService.getInstance();
    }

    public static ReactionService getInstance() {
        if (instance == null) {
            synchronized (ReactionService.class) {
                if (instance == null) {
                    instance = new ReactionService();
                }
            }
        }
        return instance;
    }

    @Override
    public void react(String tweetId, String userId, ReactionType reactionType) {
        Reaction reaction = new Reaction(tweetId, userId, reactionType);
        reactionRepository.save(reaction);
        ReactionCount reactionCount = reactionCountService.getReactionCountForTweet(tweetId);
        switch (reactionType) {
            case LIKE: {
                reactionCount.setLikeCount(reactionCount.getLikeCount() + 1);
                break;
            }
            case UNLIKE: {
                reactionCount.setDislikeCount(reactionCount.getDislikeCount() + 1);
                break;
            }
            case HAHA: {
                reactionCount.setHahaCount(reactionCount.getHahaCount() + 1);
                break;
            }
            case LOVE: {
                reactionCount.setLoveCount(reactionCount.getLoveCount() + 1);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported reaction type: " + reactionType);
            }
        }
        reactionCountService.updateReactionCountForTweet(reactionCount);
    }
}
