package org.blackjack.models;

import org.blackjack.interfaces.IPlayingStrategy;

import java.util.List;

public class BlackjackGameProperties extends GameProperties {
    List<Card> cardsReceived;
    int scoreWithoutAces;
    int numAces;

    public BlackjackGameProperties(List<Card> cardsReceived, int scoreWithoutAces, int numAces, IPlayingStrategy playingStrategy) {
        this.cardsReceived = cardsReceived;
        this.scoreWithoutAces = scoreWithoutAces;
        this.numAces = numAces;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public int getScore() {
        int scoreOne = scoreWithoutAces + numAces;
        int scoreTwo = scoreOne + 10;
        return scoreWithoutAces;
    }
}
