package src.boardGame.chess_System;

import src.boardGame.Board;
import src.boardGame.Piece;
import src.boardGame.Position;

public abstract class ChessPiece extends Piece {

    private final Color color;

    private int moveCount;
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void increaseMovCount (){
        moveCount++;

    }
    public void decreaseMovCount (){
        moveCount--;

    }

    public Chessposition getChessPosition(){
        return Chessposition.fromPosition(position);
    }


    protected boolean IsThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}
