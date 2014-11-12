import java.awt.Color;

public class Square {
    private Horse horse;
    private Color background;
    private boolean hasContent;
    
    public Square(boolean lightBackground) {
        horse = new Horse(lightBackground);
        hasContent = false;

        if (lightBackground) {
            background = Color.WHITE;
        }
        else {
            background = Color.GRAY;
        }
    }
    
    public javax.swing.Icon getItem() {
        return horse.getColor();
    }
    
    public Color getColor() {
        return background;
    }
    
    public boolean isEmpty() {
        return !hasContent;
    }
    
    public void place(boolean content) {
        hasContent = content;
    }
}
