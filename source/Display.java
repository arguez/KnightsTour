import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class Display extends JFrame{
    private Main controlador;
    private JButton[][] matriz;
    private final char SEPARADOR;
    private final int filas;
    private final int columnas;
    private final int altoVentana = 560;
    private final int anchoVentana = 560;
    private final int ubicacionX = 237;
    private final int ubicacionY = 0;

    public Display (Main main, int side, char separador){
        this.controlador = main;
        this.filas = side;
        this.columnas = side;
        this.SEPARADOR = separador;
        matriz = new JButton[filas][ columnas];
        configurar();
    }

    public void setBackground(Color color, int fila, int columna) {
        matriz[fila][columna].setBackground(color);
    }
    
    public void setFigura(Icon figura, int fila, int columna) {
        matriz[fila][columna].setIcon(figura);
    }
    
    public void setText(String texto, int fila, int columna) {
        matriz[fila][columna].setText(texto);
    }
    
    public void configurar(){
        this.setResizable(false);
        this.setSize(anchoVentana, altoVentana);
        this.setLocation(ubicacionX, ubicacionY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(filas, columnas));
        
        for (int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++){
                matriz[i][j] = new JButton();
                matriz[i][j].addActionListener(controlador);
                matriz[i][j].setActionCommand(Integer.toString(i) + SEPARADOR + Integer.toString(j));
                this.add(matriz[i][j]);
            }
        }
    }
    
    public void makeVisible() {
        this.setVisible(true);
    }
    
    public void quitarTexto(int fila, int columna) {
        matriz[fila][columna].setText("");
    }
    
    public void quitarFigura(int fila, int columna) {
        matriz[fila][columna].setIcon(null);
    }
}
