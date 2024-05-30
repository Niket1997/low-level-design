package org.blackjack.models.playingStrategies;

import org.blackjack.interfaces.IPlayingStrategy;
import org.blackjack.models.BlackjackGameProperties;
import org.blackjack.models.Card;
import org.blackjack.models.Deck;
import org.blackjack.models.GameProperties;

import java.util.List;
import java.util.Scanner;

public class BlackjackPlayerPlayingStrategy implements IPlayingStrategy {
    @Override
    public void play(Deck deck, GameProperties gameProperties) {
        List<Card> firstTwoCards = deck.getCards(2);
        Card firstCard = firstTwoCards.get(0);
        Card secondCard = firstTwoCards.get(1);

        int scoreWithoutAcesToUpdate = 0;
        int numAcesToUpdate = 0;

        if (firstCard.getCardKey().equals("A")) {
            numAcesToUpdate++;
        } else {
            scoreWithoutAcesToUpdate += firstCard.getCardValues().get(0);
        }

        if (secondCard.getCardKey().equals("A")) {
            numAcesToUpdate++;
        } else {
            scoreWithoutAcesToUpdate += secondCard.getCardValues().get(0);
        }

        BlackjackGameProperties blackjackGameProperties = (BlackjackGameProperties) gameProperties;
        blackjackGameProperties.getCardsReceived().addAll(firstTwoCards);

        blackjackGameProperties.setNumAces(blackjackGameProperties.getNumAces() + numAcesToUpdate);
        blackjackGameProperties.setScoreWithoutAces(blackjackGameProperties.getScoreWithoutAces() + scoreWithoutAcesToUpdate);
        System.out.println("Your current score can be one of: " + blackjackGameProperties.getScores());

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter valid action. \nHit: 1\nSkip: 0\n");
            int choice = sc.nextInt();
            if (choice != 0 && choice != 1) {
                System.out.println("Invalid input");
                continue;
            }

            if (choice == 0) break;

            Card card = deck.getCards(1).get(0);
            blackjackGameProperties.getCardsReceived().add(card);
            if (card.getCardKey().equals("A")) {
                blackjackGameProperties.setNumAces(blackjackGameProperties.getNumAces() + 1);
            } else {
                blackjackGameProperties.setScoreWithoutAces(blackjackGameProperties.getScoreWithoutAces() + card.getCardValues().get(0));
            }
            System.out.println("Your current score can be one of: " + blackjackGameProperties.getScores());
            if (blackjackGameProperties.getScore() >= 21) break;
        }
    }
}
