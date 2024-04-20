package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.interfaces.IPlayingStrategy;

public class GameProperties {
    GameName gameName;
    int score;
    IPlayingStrategy playingStrategy;

    public GameProperties(GameName gameName, IPlayingStrategy playingStrategy) {
        this.gameName = gameName;
        this.score = 0;
        this.playingStrategy = playingStrategy;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score = newScore;
    }
}
