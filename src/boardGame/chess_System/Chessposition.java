package src.boardGame.chess_System;

import src.boardGame.Position;

public class Chessposition {

    private final char column;
    private final int row;

    public Chessposition (char column, int row){
        if (column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("posicao nao existente");
        }
    this.row=row;
        this.column=column;
    }

    public char getColumn() {
        return column;
    }
    public int getRow(){
        return row;
    }

   protected Position ToPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static Chessposition fromPosition(Position position){
        return new Chessposition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return " " + column + row ;
    }
}

