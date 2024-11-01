package Vistas;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Logica.Entidades.EntidadJugador;

import javax.sound.sampled.Control;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class PantallaPerdisteOGanaste extends JPanel {
    private final String rutaImagen = "/Datos/sprites/gameover.png";
    protected Image imagenFondo;
    protected ControladorVistas controladorVistas;
    protected EntidadJugador personaje;
    private JLabel labelPuntaje;

    public PantallaPerdisteOGanaste(ControladorVistas controladorVistas, EntidadJugador personaje) {
        setLayout(null);
        this.controladorVistas = controladorVistas;
        this.personaje = personaje;

        insertarFondo();
        crearEtiquetas();
        agregarEtiquetasPanel();
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
    
    private void crearEtiquetas() {
        labelPuntaje=new JLabel(String.valueOf("Puntaje: " + personaje.getPuntaje()), SwingConstants.CENTER);
        labelPuntaje.setForeground(Color.WHITE);
        Font fuente;
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 22f);
            labelPuntaje.setFont(fuente);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        labelPuntaje.setBounds(26, 100,300, 300);
    }
    private void agregarEtiquetasPanel() {
       this.add(labelPuntaje);
    }

    public String pedirNombre() {

    JLabel labelNombre = new JLabel("Ingresar nombre:");
    JTextField campoNombre = new JTextField();
    JButton botonAceptar = new JButton("Aceptar");
    Font fuente;
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 22f);
            labelNombre.setFont(fuente);
            campoNombre.setFont(fuente);
            botonAceptar.setFont(fuente);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    
    
        labelNombre.setBounds(50, 150, 400, 50); // Ancho aumentado a 400 y alto a 50
        labelNombre.setForeground(Color.WHITE);
        add(labelNombre);
    
        campoNombre.setBounds(460, 150, 300, 50); // Ancho aumentado a 300 y altura a 50
        add(campoNombre);
    
        botonAceptar.setBounds(780, 150, 220, 50); // Ancho aumentado a 150 y altura a 50
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setBackground(Color.BLACK);
        botonAceptar.setBorder(new LineBorder(java.awt.Color.BLACK, 2));
        add(botonAceptar);

    final CountDownLatch latch = new CountDownLatch(1);
    final String[] nombreUsuario = new String[1];

    botonAceptar.addActionListener(e -> {
        nombreUsuario[0] = campoNombre.getText();
        latch.countDown(); 
    });

    this.revalidate();
    this.repaint();

    try {
        latch.await(); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    return nombreUsuario[0]; 
}
    
}
