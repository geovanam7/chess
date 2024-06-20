package src.boardGame;

import src.boardGame.chess_System.ChessPiece;
import src.boardGame.chess_System.Chessposition;

public class Board {

    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows <1 || columns < 1){
            throw  new BoardException( "error when creating the board, at least 1");
        }
        this.rows = rows;
        this.columns=columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Piece piece (int row, int columns){
        if (!positionExist(row, columns)){
            throw new BoardException("non-existent position on the board");
        }
        return pieces[row][columns];
    }
    public Piece piece (Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }


    public void placePiece(Piece piece, Position position) {
        if (ThereIsAPiece(position)) {
            throw new BoardException("there is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece RemovePiece (Position position){
        if (!positionExists(position)){
            throw new BoardException("non-existent position on the board");
        }
        if (piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;

    }

    public boolean positionExist (int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists (Position position){
        return positionExist(position.getRow(), position.getColumn());
    }

    public boolean ThereIsAPiece (Position position){
        if (!positionExists(position)) {
        throw new BoardException("position not on the board");
        }
        return piece(position) != null ;

    }


}
