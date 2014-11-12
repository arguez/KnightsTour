import java.awt.Color;
import javax.swing.Icon;

public class Board {
    private Square squares[][];
    private final int SIDE;

    public Board(int side) {
        SIDE = side;
        squares = new Square [side][side];
        fillBoard();
    }

    private void fillBoard() {
        boolean change = true;
        for (int row=0; row<SIDE; row++) {
            for (int col=0; col<SIDE; col++) {
                if (change) {
                    squares[row][col] = new Square(true);
                }
                else {
                    squares[row][col] = new Square(false);
                }
                change = !change;
            }
            change = !change;
        }
    }

    public boolean isEmpty(int row, int col) {
        return squares[row][col].isEmpty();
    }

    public Color getSquareColor(int row, int col) {
        return squares[row][col].getColor();
    }

    public Icon getImageColor(int row, int col) {
        return squares[row][col].getItem();
    }

    public void checkSquare(int row, int col) {
        squares[row][col].place(true);
    }
    
    boolean inBounds(int position) {
        return (position >= 0) && (position < SIDE);
    }
}
