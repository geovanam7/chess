package src.boardGame.chess_System;

import src.boardGame.Board;
import src.boardGame.Position;
import src.boardGame.chess_System.Pieces.King;
import src.boardGame.chess_System.Pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece [board.getRows()][board.getColumns()];
                for (int i=0; i < board.getRows(); i++){
                    for (int j = 0; j < board.getColumns(); j++) {
                      mat[i][j] = (ChessPiece)board.piece(i,j);

                    }
                    }

                return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2,3));
        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
    }

}



