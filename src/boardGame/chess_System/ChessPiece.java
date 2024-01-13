package src.boardGame.chess_System;

import src.boardGame.Board;
import src.boardGame.Piece;

public class ChessPiece extends Piece {

    private final Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
