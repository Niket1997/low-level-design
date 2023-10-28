package org.tictactoe;

import org.tictactoe.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.initialiseGame();
        System.out.println("game winner is: " + game.start());

    }
}