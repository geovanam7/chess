package src.boardGame.chess.pieces;

import src.boardGame.Board;
import src.boardGame.chess_System.ChessPiece;
import src.boardGame.chess_System.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";

    }
}