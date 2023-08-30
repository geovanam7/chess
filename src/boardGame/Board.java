package src.boardGame;

public class Board {

    private int rows;
    private int columns;

    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows <1 || columns < 1){
            throw  new BoardException( "erro ao criar o tabuleiro, necessario ao menos 1");
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
            throw new BoardException("POSITION NOT ON THE BOARD");
        }
        return pieces[row][columns];
    }
    public Piece piece (Position position) {
        return pieces[position.getRow()][position.getColumns()];
    }

    public void placePiece(Piece piece, Position position ){
        if (ThereIsAPiece(position)){
            throw new BoardException("there is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumns()]=piece;
        piece.position=position;
    }

    public boolean positionExist (int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists (Position position){
        return positionExist(position.getRow(), position.getColumns());
    }

    public boolean ThereIsAPiece (Position position){
        if (!positionExists(position)) {
        throw new BoardException("position not on the board");
        }
        return piece(position) != null ;

    }

}
