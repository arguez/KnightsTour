public class Horse {
    private final String white = "white.png";
    private final String black = "black.png";
    private javax.swing.Icon image;

    public Horse(boolean lightBackground) {
        if (lightBackground) {
            setIcon(white);
        }
        else {
            setIcon(black);
        }
    }
    
    private void setIcon (String color) {
        image = new javax.swing.ImageIcon(this.getClass().getResource(color));
    }
    
    public javax.swing.Icon getColor() {
        return image;
    }
}
