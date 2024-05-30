package org.tictactoe.board;

import org.tictactoe.common.enums.PieceType;
import org.tictactoe.playingpiece.PlayingPiece;

public class Board {
    private final PlayingPiece[][] board;
    private int numPiecesAdded;

    public Board(int size) {
        numPiecesAdded = 0;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (board[row][col] != null) return false;
        board[row][col] = playingPiece;
        numPiecesAdded++;
        return true;
    }

    public boolean hasFreeCells() {
        return numPiecesAdded < board.length * board.length;
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int i = 0; i < board.length; i++) {

            if (board[row][i] == null || board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for (int i = 0; i < board.length; i++) {

            if (board[i][column] == null || board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for (int i = 0, j = 0; i < board.length; i++, j++) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for (int i = 0, j = board.length - 1; i < board.length; i++, j--) {
            if (board[i][j] == null || board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("   ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
