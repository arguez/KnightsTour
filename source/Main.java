import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main implements ActionListener {
    private final char SPLIT = ',';
    private final int SIDE = 8;
    private Display display;
    private HorsePath horsePath;
    private Board chessboard;

    public static void main(String [] args) {
        new Main().start();
    }

    public void start(){
        display = new Display(this, SIDE, SPLIT);
        chessboard = new Board(SIDE);
        horsePath = new HorsePath(chessboard);
        refreshDisplay();
        display.makeVisible();
    }

    public void actionPerformed(ActionEvent event){
        String action = event.getActionCommand();
        String [] label = action.split(SPLIT+"");
        int row = Integer.parseInt(label[0]);
        int col = Integer.parseInt(label[1]);
        this.showPath(row, col);
    }

    public void showPath(int startRow, int startCol) {
        ArrayList <Position> positions = null;
        positions = horsePath.tracePath(startRow, startCol);
        int listSize = positions.size();
        int displayRow = 0;
        int displayCol = 0;

        for (int index=0; index<listSize; index++) {
            displayRow = positions.get(index).getRow();
            displayCol = positions.get(index).getCol();
            this.setText(index + 1, displayRow, displayCol);
        }
    }

    public void refreshDisplay() {
        for (int row=0; row<SIDE; row++) {
            for (int col=0; col<SIDE; col++) {
                this.setColor(row, col);
            }
        }
    }

    public void setColor(int row, int col) {
        display.setBackground(chessboard.getSquareColor(row, col), row, col);
    }

    public void setFigura(int row, int col) {
        display.setFigura(chessboard.getImageColor(row, col), row, col);
    }

    public void setText(int text,int row, int col) {
        display.setText(Integer.toString(text), row, col);
    }
}
