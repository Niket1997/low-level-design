package org.blackjack.interfaces;

import org.blackjack.models.Deck;

public interface IPlayingStrategy {
    boolean play(Deck deck);
}
