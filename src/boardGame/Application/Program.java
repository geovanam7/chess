package src.boardGame.Application;

import src.boardGame.Board;
import src.boardGame.chess_System.ChessException;
import src.boardGame.chess_System.ChessMatch;
import src.boardGame.chess_System.ChessPiece;
import src.boardGame.chess_System.Chessposition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.PrintMatch(chessMatch);
                System.out.println("  ");
                System.out.println("Source:  ");
                Chessposition source = UI.readChessPosition(sc);

boolean[][] possibleMoves = chessMatch.possibleMoves(source);
UI.clearScreen();
UI.printBoard(chessMatch.getPieces(),possibleMoves);

                System.out.println("  ");
                System.out.println("Target:  ");
                Chessposition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);


            }
            catch (ChessException | InputMismatchException e) {
                System.out.println (e.getMessage());
                sc.nextLine();
            }

        }
    }
}