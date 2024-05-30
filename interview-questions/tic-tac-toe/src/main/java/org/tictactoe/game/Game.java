package org.tictactoe.game;

import org.tictactoe.board.Board;
import org.tictactoe.player.Player;
import org.tictactoe.playingpiece.PlayingPieceO;
import org.tictactoe.playingpiece.PlayingPieceX;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Game {
    private ArrayDeque<Player> players;
    private Board board;

    public int size;

    public Game() {
        size = 3;
        players = new ArrayDeque<>();
    }

    public void initialiseGame() {
        Player playerOne = new Player();
        playerOne.setName("playerOne");
        playerOne.setPlayingPiece(new PlayingPieceO());

        Player playerTwo = new Player();
        playerTwo.setName("playerTwo");
        playerTwo.setPlayingPiece(new PlayingPieceX());

        players.add(playerOne);
        players.add(playerTwo);

        board = new Board(size);
    }

    public String start() {
        boolean isGameGoingOn = true;

        while (isGameGoingOn) {
            Player currentPlayer = players.removeFirst();

            board.printBoard();
            if (!board.hasFreeCells()) {
                isGameGoingOn = false;
                break;
            }
            System.out.println(currentPlayer.getName() + ", please enter row,col.");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();

            String[] values = s.split(",");
            if (values.length != 2) {
                System.out.println("please enter appropriate row & column");
                players.addFirst(currentPlayer);
                continue;
            }
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            if (inputRow < 0 || inputRow >= size || inputCol < 0 || inputCol >= size) {
                System.out.println("please enter appropriate row & column");
                players.addFirst(currentPlayer);
                continue;
            }

            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputCol, currentPlayer.getPlayingPiece());
            if (!pieceAddedSuccessfully) {
                System.out.println("please choose cell that is empty");
                players.addFirst(currentPlayer);
                continue;
            }

            players.add(currentPlayer);
            boolean isWinner = board.isThereWinner(inputRow, inputCol, currentPlayer.getPlayingPiece().pieceType);

            if (isWinner) {
                return currentPlayer.getName();
            }
        }
        return "tie";
    }
}
