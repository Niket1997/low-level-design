package org.blackjack;

import org.blackjack.enums.PlayerType;
import org.blackjack.interfaces.IPlayingStrategy;
import org.blackjack.models.BlackjackGame;
import org.blackjack.models.Player;
import org.blackjack.models.playingStrategies.BlackjackDealerPlayingStrategy;
import org.blackjack.models.playingStrategies.BlackjackPlayerPlayingStrategy;

public class Main {
    public static void main(String[] args) {
        BlackjackGame blackjackGame = new BlackjackGame();
        IPlayingStrategy playerPlayingStrategy = new BlackjackPlayerPlayingStrategy();
        IPlayingStrategy dealerPlayingStrategy = new BlackjackDealerPlayingStrategy();

        Player player = new Player("Niket", PlayerType.PLAYER);
        Player playerTwo = new Player("Test", PlayerType.PLAYER);
        Player dealer = new Player("Kedar", PlayerType.DEALER);
        blackjackGame.addPlayer(player, playerPlayingStrategy);
        blackjackGame.addPlayer(playerTwo, playerPlayingStrategy);
        blackjackGame.addPlayer(dealer, dealerPlayingStrategy);
        blackjackGame.startGame();
    }
}