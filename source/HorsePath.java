import java.util.ArrayList;

public class HorsePath {
    private Board chessboard;
    private Display display;

    private final int SIZE;
    private final int[] ROW_LIST;
    private final int[] COL_LIST;

    public HorsePath(Board board) {
        SIZE = 8;
        ROW_LIST = new int[] {1, -1, 2, -2, 1, -1, 2, -2};
        COL_LIST = new int[] {-2, -2, -1, -1, 2, 2, 1, 1};
        chessboard = board;
    }

    public ArrayList <Position> tracePath(int startRow, int startCol) {
        ArrayList <Position> positions = new ArrayList<Position>();
        Position nextMove = null;
        int nextRow = startRow;
        int nextCol = startCol;
        int movesCount = 0;
        int movesLimit = SIZE*SIZE;
        
        while(movesCount < movesLimit) {
            positions.add(new Position(nextRow, nextCol));
            chessboard.checkSquare(nextRow, nextCol);
            nextMove = getBestMove(getPossibleMoves(nextRow, nextCol));
            nextRow = nextMove.getRow();
            nextCol = nextMove.getCol();
            movesCount++;
        }
        return positions;
    }

    public ArrayList <Position> getPossibleMoves(int row, int col) {
        ArrayList <Position> positions = new ArrayList<Position>();
        int nextRow = 0;
        int nextCol = 0;

        for (int index=0; index<SIZE; index++) {
            nextRow = row + ROW_LIST[index];
            nextCol = col + COL_LIST[index];
            if (isValid(nextRow, nextCol)) {
                positions.add(new Position(nextRow, nextCol, getValidMoves(nextRow, nextCol)));
            }
        }
        return positions;
    }

    public Position getBestMove(ArrayList <Position> positionsList) {
        int row = -1;
        int col = -1;
        int maxMoves = 9;
        int itemMoves = 0;  //each element valid moves
        int listLength = positionsList.size();
        
        for (int index=0; index < listLength; index++) {
            itemMoves = positionsList.get(index).getMoves();
            
            if(itemMoves < maxMoves) {
                maxMoves = itemMoves;   //finds position with fewer valid moves
                row = positionsList.get(index).getRow();
                col = positionsList.get(index).getCol();
            }
        }
        return new Position(row, col);
    }

    public int getValidMoves(int row, int col) {
        int nextRow = 0;
        int nextCol = 0;
        int validMoves = 0;

        for (int index=0; index<SIZE; index++) {
            nextRow = row + ROW_LIST[index];
            nextCol = col + COL_LIST[index];
            if (isValid(nextRow, nextCol)) {
                validMoves++;
            }
        }
        return validMoves;
    }

    private boolean isValid(int row, int col) {
        if ((chessboard.inBounds(row)) && (chessboard.inBounds(col))) { //chessboard contains position
            return chessboard.isEmpty(row, col); //position is empty
        }
        else {
            return false; //position is not in bounds of chessboard
        }
    }

    private boolean inBoard(int fila, int columna) {
        return (chessboard.inBounds(fila)&&(chessboard.inBounds(columna)));
    }

    /*# 
     * METHOD TESTS 
     
    public void movesPerSquare() {
        display.makeVisible();

        for (int fila=0; fila<SIZE; fila++) {
            for (int columna=0; columna<SIZE; columna++) {
                display.setText(Integer.toString(this.getValidMoves(fila, columna)), fila, columna);
            }
        }
    }

    public ArrayList <Position> testPossibleMoves() {
        movesPerSquare();
        return  getPossibleMoves(4, 4);
    }
    
    public Position testBestMove() {
        //testing (1, 1)
        //expected (3, 0) or (0, 3)
        return getBestMove(getPossibleMoves(1, 1));
    }

    public int testValidMoves() {
        movesPerSquare();
        //chessboard.marcarCuadro(2, 1);
        //chessboard.marcarCuadro(1, 2);
        return getValidMoves(0, 0);
    }
    */
}
