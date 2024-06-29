package org.nik.twitter.services;

import org.nik.twitter.entities.Reaction;
import org.nik.twitter.entities.TweetMetadata;
import org.nik.twitter.enums.ReactionType;
import org.nik.twitter.interfaces.IReactionService;
import org.nik.twitter.interfaces.ITweetMetadataService;
import org.nik.twitter.repositories.ReactionRepository;

import java.util.List;

public class ReactionService implements IReactionService {
    private final ReactionRepository reactionRepository;
    private final ITweetMetadataService tweetMetadataService;

    private static volatile ReactionService instance;

    private ReactionService() {
        this.reactionRepository = ReactionRepository.getInstance();
        this.tweetMetadataService = TweetMetadataService.getInstance();
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
        TweetMetadata tweetMetadata = tweetMetadataService.getTweetMetadata(tweetId);

        switch (reactionType) {
            case LIKE: {
                tweetMetadata.setNumLikes(tweetMetadata.getNumLikes() + 1);
                break;
            }

            case DISLIKE: {
                tweetMetadata.setNumLikes(tweetMetadata.getNumLikes() - 1);
            }
        }

        tweetMetadataService.save(tweetMetadata);
        Reaction reaction = new Reaction(tweetId, userId, reactionType);
        reactionRepository.save(reaction);
    }

    @Override
    public List<Reaction> getReactions(String tweetId) {
        return reactionRepository.getReactionsForTweet(tweetId);
    }
}
