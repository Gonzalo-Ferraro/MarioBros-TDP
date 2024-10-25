package Vistas;


import Logica.Entidades.EntidadJugador;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;


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

        nivel = personaje.getJuego().obtenerNivel().getNumeroNivel();
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

    private void crearEtiquetas() {
        etiquetaVidas = new JLabel(String.valueOf("x   " + personaje.getVidas()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel(String.valueOf("Puntaje: " + personaje.getPuntaje()), SwingConstants.CENTER);
        etiquetaNivel = new JLabel(String.valueOf("Nivel: " + nivel),SwingConstants.CENTER);
    
        // Establecer el color de texto blanco
        etiquetaVidas.setForeground(Color.WHITE); 
        etiquetaPuntaje.setForeground(Color.WHITE); 
        etiquetaNivel.setForeground(Color.WHITE);
    
        // Establecer la fuente
        Font fuente;
        Font fuenteVidas;
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 22f);
            fuenteVidas = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 30f);
            etiquetaPuntaje.setFont(fuente);
            etiquetaVidas.setFont(fuenteVidas);
            etiquetaNivel.setFont(fuente);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    
        etiquetaPuntaje.setBounds(125, 15,300, 60);
        etiquetaVidas.setBounds(575,312,200,60);
        etiquetaNivel.setBounds(900,15,250,60);
    }

    private void agregarEtiquetasPanel() {
        this.add(etiquetaNivel);
        this.add(etiquetaVidas);
        this.add(etiquetaPuntaje);
    }
    
    public void actualizarValores(int nuevoNivel) {

        // Actualizar el texto de las etiquetas
        etiquetaVidas.setText("x   " + personaje.getVidas());
        etiquetaPuntaje.setText("Puntaje: " + personaje.getPuntaje());
        etiquetaNivel.setText("Nivel: " + nuevoNivel);

        // Forzar la actualización de la interfaz
        revalidate();
        repaint();
    }
    
}
