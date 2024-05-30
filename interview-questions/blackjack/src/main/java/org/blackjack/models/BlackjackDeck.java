package org.blackjack.models;

import org.blackjack.enums.CardType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BlackjackDeck extends Deck {
    @Override
    public void initializeDeck() {
        cards = new LinkedList<>();
        for (CardType cardType : CardType.values()) {
            for (int i = 2; i <= 10; i++) {
                Card card = new Card(cardType, String.valueOf(i), List.of(i));
                cards.add(card);
            }
            cards.add(new Card(cardType, "J", List.of(10)));
            cards.add(new Card(cardType, "Q", List.of(10)));
            cards.add(new Card(cardType, "K", List.of(10)));
            cards.add(new Card(cardType, "A", List.of(1, 11)));
        }
    }

    @Override
    public void initializeCardValues() {
        cardValues = new HashMap<>();
        for (int i = 2; i <= 10; i++) {
            cardValues.put(String.valueOf(i), List.of(i));
        }
        cardValues.put("J", List.of(10));
        cardValues.put("Q", List.of(10));
        cardValues.put("K", List.of(10));
        cardValues.put("A", List.of(1, 11));
    }
}
