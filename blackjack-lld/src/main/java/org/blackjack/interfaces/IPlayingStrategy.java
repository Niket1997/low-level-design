package org.blackjack.interfaces;

import org.blackjack.models.Deck;
import org.blackjack.models.GameProperties;

public interface IPlayingStrategy {
    void play(Deck deck, GameProperties gameProperties);
}
