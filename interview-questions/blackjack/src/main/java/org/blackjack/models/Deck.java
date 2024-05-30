package org.blackjack.models;

import org.blackjack.enums.CardType;

import java.util.*;

public class Deck {
    LinkedList<Card> cards;
    Map<String, List<Integer>> cardValues;

    public Deck() {
        initializeDeck();
        initializeCardValues();
        Collections.shuffle(cards);
    }

    public void initializeDeck() {
        cards = new LinkedList<>();
        for (CardType cardType : CardType.values()) {
            for (int i = 2; i <= 10; i++) {
                Card card = new Card(cardType, String.valueOf(i), List.of(i));
                cards.add(card);
            }
            cards.add(new Card(cardType, "J", List.of(11)));
            cards.add(new Card(cardType, "Q", List.of(12)));
            cards.add(new Card(cardType, "K", List.of(13)));
            cards.add(new Card(cardType, "A", List.of(14)));
        }
    }

    public void initializeCardValues() {
        cardValues = new HashMap<>();
        for (int i = 2; i <= 10; i++) {
            cardValues.put(String.valueOf(i), List.of(i));
        }
        cardValues.put("J", List.of(11));
        cardValues.put("Q", List.of(12));
        cardValues.put("K", List.of(13));
        cardValues.put("A", List.of(14));
    }


    public List<Card> getCards(int numCards) {
        if (cards.size() < numCards) throw new RuntimeException("not enough cards available");

        List<Card> result = new LinkedList<>();
        for (int i = 0; i < numCards; i++) {
            result.add(cards.removeFirst());
        }

        return result;
    }

    public List<Integer> getCardValues(Card card) {
        return cardValues.get(card.cardKey);
    }

    public void printDeck() {
        for (Card card : cards) {
            card.print();
        }
    }

    public void printCardValues() {
        for (Map.Entry<String, List<Integer>> cardValue : cardValues.entrySet()) {
            System.out.println(cardValue.getKey() + ":  " + cardValue.getValue());
        }
    }

}
