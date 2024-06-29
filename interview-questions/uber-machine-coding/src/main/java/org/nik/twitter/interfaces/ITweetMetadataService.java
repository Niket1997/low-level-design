package org.nik.twitter.interfaces;

import org.nik.twitter.entities.TweetMetadata;

public interface ITweetMetadataService {
    TweetMetadata getTweetMetadata(String tweetId);

    TweetMetadata save(TweetMetadata tweetMetadata);
}
