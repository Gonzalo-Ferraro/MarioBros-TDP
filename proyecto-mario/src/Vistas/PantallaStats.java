package Vistas;


import javax.swing.*;

import java.awt.*;

import Logica.Entidades.EntidadJugador;


public class PantallaStats extends JPanel  {
    protected EntidadJugador personaje;
    protected ControladorVistas controladorVistas;
    private final String rutaImagen = "/Datos/sprites/pantallaVidas.png";
    private int nivel;

    protected Image imagenFondo;
    protected JLabel etiquetaVidas;
    protected JLabel etiquetaPuntaje;
    protected JLabel etiquetaNivel;
    
    public PantallaStats(ControladorVistas c,EntidadJugador p){
        super();

        controladorVistas = c;
        personaje = p;

        nivel = 1;
        this.setLayout(null);

        insertarFondo();
        crearEtiquetas();
        agregarEtiquetas();
    }

    private void insertarFondo(){
            ImageIcon iconoImagen = new ImageIcon(getClass().getResource(rutaImagen));
            imagenFondo = iconoImagen.getImage();
            
       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el JPanel
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }

    public void actualizarValores(){
        etiquetaVidas = new JLabel(String.valueOf(personaje.getVidas()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel(String.valueOf(personaje.getPuntaje()), SwingConstants.CENTER);
        aumentarNivel();
        etiquetaNivel=new JLabel(String.valueOf(nivel),SwingConstants.CENTER);
    }



    public void aumentarNivel(){
        nivel++;
    }


    private void  crearEtiquetas(){
        etiquetaVidas = new JLabel(String.valueOf(personaje.getVidas()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel(String.valueOf(personaje.getPuntaje()), SwingConstants.CENTER);
        etiquetaNivel=new JLabel(String.valueOf(nivel),SwingConstants.CENTER);
    
            // Hacer que las etiquetas sean opacas para que el fondo se muestre
            etiquetaVidas.setOpaque(true);
            etiquetaPuntaje.setOpaque(true);
            etiquetaNivel.setOpaque(true);

            // Establecer el fondo negro
            etiquetaVidas.setBackground(Color.BLACK);
            etiquetaPuntaje.setBackground(Color.BLACK);
            etiquetaNivel.setBackground(Color.BLACK);
        
            // Establecer el color de texto blanco
            etiquetaVidas.setForeground(Color.WHITE); // Color de texto para vidas
            etiquetaPuntaje.setForeground(Color.WHITE); // Color de texto para puntaje
            etiquetaNivel.setForeground(Color.WHITE);
        
            // Establecer la fuente
            Font font = new Font("Arial", Font.PLAIN, 45);
            etiquetaPuntaje.setFont(font);
            etiquetaVidas.setFont(font);
            etiquetaNivel.setFont(font);
        
            agregarEtiquetas();
            
    
        etiquetaPuntaje.setBounds(125, 55,150, 60);
        etiquetaVidas.setBounds(650,295,150,60);
        etiquetaNivel.setBounds(725,55,150,60);

        
    }
    private void agregarEtiquetas(){
        this.add(etiquetaNivel);
        this.add(etiquetaVidas);
        this.add(etiquetaPuntaje);
        
    }

}
