package Vistas;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Image;

public class PantallaPerdisteOGanaste extends JPanel {
    protected JLabel labelPerdiste;
    private final String rutaImagen = "/Datos/sprites/gameover.png";
    protected Image imagenFondo;

    public PantallaPerdisteOGanaste() {
        setLayout(null);

        insertarFondo();
    }
     private void insertarFondo(){
        ImageIcon iconoImagen = new ImageIcon(getClass().getResource(rutaImagen));
        imagenFondo = iconoImagen.getImage();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el JPanel
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
    
}
