package src.boardGame.Application;

import src.boardGame.Board;
import src.boardGame.chess_System.ChessMatch;

public class Program {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());


    }
}