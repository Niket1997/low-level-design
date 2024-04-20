package org.blackjack.models;

import org.blackjack.enums.CardType;

import java.util.List;

public class Card {
    CardType cardType;
    String cardKey;
    List<Integer> cardValues;

    public Card(CardType cardType, String cardKey, List<Integer> cardValues) {
        this.cardType = cardType;
        this.cardKey = cardKey;
        this.cardValues = cardValues;
    }

    public CardType getCardType() {
        return cardType;
    }

    public String getCardKey() {
        return cardKey;
    }

    public List<Integer> getCardValues() {
        return cardValues;
    }

    public void print() {
        System.out.println(cardType + ", " + cardKey + ", " + cardValues);
    }
}
