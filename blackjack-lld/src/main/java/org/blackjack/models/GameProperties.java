package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.interfaces.IPlayingStrategy;

public abstract class GameProperties {
    GameName gameName;
    IPlayingStrategy playingStrategy;

    public abstract int getScore();
}
