package org.blackjack.models;

import org.blackjack.enums.GameName;
import org.blackjack.interfaces.IPlayingStrategy;

import java.util.ArrayDeque;

public class BlackjackGame {
    Deck blackjackDeck;
    ArrayDeque<Player> players;
    Player currentWinningPlayer;

    public BlackjackGame() {
        blackjackDeck = new BlackjackDeck();
        players = new ArrayDeque<>();
        currentWinningPlayer = null;
    }

    public void addPlayer(Player player, IPlayingStrategy playingStrategy) {
        if (players.isEmpty()) currentWinningPlayer = player;
        players.add(player);
        player.gamePropertiesMap.put(GameName.BLACKJACK, new BlackjackGameProperties(playingStrategy));
    }

    public void startGame() {
        if (players.isEmpty()) {
            System.out.println("Please add player");
            return;
        }
        while (!players.isEmpty()) {
            Player player = players.removeFirst();
            System.out.println(player.name + "'s turn");
            GameProperties gameProperties = player.gamePropertiesMap.get(GameName.BLACKJACK);
            gameProperties.playingStrategy.play(blackjackDeck, gameProperties);

            int score = gameProperties.getScore();
            if (score == 21) {
                currentWinningPlayer = player;
                break;
            }
            if (score > 21) {
                currentWinningPlayer = null;
                continue;
            }

            if (currentWinningPlayer == null || score > currentWinningPlayer.gamePropertiesMap.get(GameName.BLACKJACK).getScore()) {
                currentWinningPlayer = player;
            }
        }
        if (currentWinningPlayer != null) System.out.println(currentWinningPlayer.name + " won!!!");
        else System.out.println("Game tied");
    }
}
