public class Position {
    int row;
    int col;
    int moves;
    
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.moves = -1;
    }
    
    public Position(int row, int col, int moves) {
        this.row = row;
        this.col = col;
        this.moves = moves;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public int getMoves() {
        return moves;
    }
}
