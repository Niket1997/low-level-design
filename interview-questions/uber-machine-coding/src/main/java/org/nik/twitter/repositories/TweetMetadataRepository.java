package org.nik.twitter.repositories;

import org.nik.twitter.entities.TweetMetadata;

import java.util.HashMap;

public class TweetMetadataRepository {
    private final HashMap<String, TweetMetadata> metadata;

    private static volatile TweetMetadataRepository instance;

    private TweetMetadataRepository() {
        metadata = new HashMap<>();
    }

    public static TweetMetadataRepository getInstance() {
        if (instance == null) {
            synchronized (TweetMetadataRepository.class) {
                if (instance == null) {
                    instance = new TweetMetadataRepository();
                }
            }
        }
        return instance;
    }

    public TweetMetadata getMetadata(String tweetId) {
        if (!metadata.containsKey(tweetId)) {
            throw new IllegalArgumentException("Metadata for tweet id " + tweetId + " not found");
        }
        return metadata.get(tweetId);
    }

    public TweetMetadata save(TweetMetadata tweetMetadata) {
        metadata.put(tweetMetadata.getTweetId(), tweetMetadata);
        return tweetMetadata;
    }
}
