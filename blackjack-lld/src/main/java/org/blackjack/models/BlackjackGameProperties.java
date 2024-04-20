package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.interfaces.IPlayingStrategy;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGameProperties extends GameProperties {
    List<Card> cardsReceived;
    int scoreWithoutAces;
    int numAces;

    public BlackjackGameProperties(IPlayingStrategy playingStrategy) {
        super(GameName.BLACKJACK, playingStrategy);
        this.cardsReceived = new ArrayList<>();
        this.scoreWithoutAces = 0;
        this.numAces = 0;
    }

    @Override
    public int getScore() {
        int scoreOne = scoreWithoutAces + numAces;
        int scoreTwo = scoreOne + 10;
        if (scoreOne == 21 || scoreTwo == 21) return 21;
        return scoreTwo > 21 ? scoreOne : scoreTwo;
    }

    public List<Integer> getScores() {
        int scoreOne = scoreWithoutAces + numAces;
        int scoreTwo = scoreOne + 10;
        return List.of(scoreOne, scoreTwo);
    }

    public List<Card> getCardsReceived() {
        return cardsReceived;
    }

    public void setCardsReceived(List<Card> cardsReceived) {
        this.cardsReceived = cardsReceived;
    }

    public int getScoreWithoutAces() {
        return scoreWithoutAces;
    }

    public void setScoreWithoutAces(int scoreWithoutAces) {
        this.scoreWithoutAces = scoreWithoutAces;
    }

    public int getNumAces() {
        return numAces;
    }

    public void setNumAces(int numAces) {
        this.numAces = numAces;
    }
}
