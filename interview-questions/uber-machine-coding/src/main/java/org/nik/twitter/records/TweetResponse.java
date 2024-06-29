package org.nik.twitter.records;

import lombok.Data;
import org.nik.twitter.entities.Tweet;
import org.nik.twitter.entities.TweetMetadata;

@Data
public class TweetResponse {
    private Tweet tweet;
    private TweetMetadata tweetMetadata;

    public TweetResponse(Tweet tweet, TweetMetadata tweetMetadata) {
        this.tweet = tweet;
        this.tweetMetadata = tweetMetadata;
    }
}
