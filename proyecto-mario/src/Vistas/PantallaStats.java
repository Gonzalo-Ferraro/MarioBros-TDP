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
    
    public PantallaStats(ControladorVistas c, EntidadJugador p){
        super();

        controladorVistas = c;
        personaje = p;

        nivel = 1;
        this.setLayout(null);

        insertarFondo();
        crearEtiquetas();
        agregarEtiquetasPanel();
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



    private void  crearEtiquetas(){
        // etiquetaVidas = new JLabel(String.valueOf(personaje.getVidas()), SwingConstants.CENTER);
        etiquetaVidas = new JLabel("3", SwingConstants.CENTER);
        // etiquetaPuntaje = new JLabel(String.valueOf(personaje.getPuntaje()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel("1000000000", SwingConstants.CENTER);
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
            etiquetaVidas.setForeground(Color.WHITE); 
            etiquetaPuntaje.setForeground(Color.WHITE); 
            etiquetaNivel.setForeground(Color.WHITE);
        
            // Establecer la fuente
            Font font = new Font("Arial", Font.PLAIN, 45);
            etiquetaPuntaje.setFont(font);
            etiquetaVidas.setFont(font);
            etiquetaNivel.setFont(font);
        
            
    
        etiquetaPuntaje.setBounds(125, 55,150, 60);
        etiquetaVidas.setBounds(650,295,150,60);
        etiquetaNivel.setBounds(725,55,150,60);

        
    }
    private void agregarEtiquetasPanel(){
        this.add(etiquetaNivel);
        this.add(etiquetaVidas);
        this.add(etiquetaPuntaje);
        
    }

    
    public void actualizarValores(int nivel){
        etiquetaVidas.setText(String.valueOf(personaje.getVidas())); 
        etiquetaPuntaje.setText(String.valueOf(personaje.getPuntaje()));
        aumentarNivel(nivel);
        etiquetaNivel.setText(String.valueOf(this.nivel));
    }



    public void aumentarNivel(int nivel){
        this.nivel=nivel;
    }


}
