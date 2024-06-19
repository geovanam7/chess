package src.boardGame.Application;

import src.boardGame.Board;
import src.boardGame.chess_System.ChessException;
import src.boardGame.chess_System.ChessMatch;
import src.boardGame.chess_System.ChessPiece;
import src.boardGame.chess_System.Chessposition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                UI.clearScreen();
                UI.PrintMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                Chessposition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                Chessposition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {        //revisar lógica  
                    captured.add(capturedPiece);
                }

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}