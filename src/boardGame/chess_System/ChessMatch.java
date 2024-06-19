package src.boardGame.chess_System;

import src.boardGame.Board;
import src.boardGame.Piece;
import src.boardGame.Position;
import src.boardGame.chess.pieces.King;
import src.boardGame.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {

    private int turn;
    private  Color currentPlayer;
    private final Board board;

   private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<ChessPiece> capturedPieces = new ArrayList<>();

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessMatch() {
        turn = 1;
        currentPlayer = Color.WHITE;
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);

            }
        }

        return mat;
    }

    public boolean [][] possibleMoves(Chessposition sourcePosition){
        Position position = sourcePosition.ToPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(Chessposition sourcePosistion, Chessposition targetPosition) {
        Position source = sourcePosistion.ToPosition();
        Position target = targetPosition.ToPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.RemovePiece(source);
        Piece capturedPiece = board.RemovePiece(target);
        board.placePiece(p, target);
        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add((ChessPiece) capturedPiece);
        }
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.ThereIsAPiece(position)) {
            throw new ChessException("There are no pieces in this position");
        }
        if (currentPlayer !=((ChessPiece) board.piece(position)).getColor()){
            throw new ChessException("The chose piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
           throw new ChessException("there is no movement for the chosen piece");
    }

    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new Chessposition(column, row).ToPosition());
        piecesOnTheBoard.add(piece);
    }


        private void initialSetup () {


            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            //  placeNewPiece('e', 1, new Rook(board, Color.WHITE)); repetida
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));

        } public List<ChessPiece> getCapturedPieces() {
        return capturedPieces;
    }
    }







