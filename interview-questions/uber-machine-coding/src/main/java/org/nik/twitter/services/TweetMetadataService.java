package org.nik.twitter.services;

import org.nik.twitter.entities.TweetMetadata;
import org.nik.twitter.interfaces.ITweetMetadataService;
import org.nik.twitter.repositories.TweetMetadataRepository;

public class TweetMetadataService implements ITweetMetadataService {
    private final TweetMetadataRepository tweetMetadataRepository;

    private static volatile TweetMetadataService instance;

    private TweetMetadataService() {
        tweetMetadataRepository = TweetMetadataRepository.getInstance();
    }

    public static TweetMetadataService getInstance() {
        if (instance == null) {
            synchronized (TweetMetadataService.class) {
                if (instance == null) {
                    instance = new TweetMetadataService();
                }
            }
        }
        return instance;
    }

    @Override
    public TweetMetadata getTweetMetadata(String tweetId) {
        return tweetMetadataRepository.getMetadata(tweetId);
    }

    @Override
    public TweetMetadata save(TweetMetadata tweetMetadata) {
        return tweetMetadataRepository.save(tweetMetadata);
    }
}
