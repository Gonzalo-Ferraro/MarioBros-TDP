package Vistas;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;
import Logica.Juego.ControladorTimer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class PantallaJuego extends JPanel {
    private JPanel panelJuego;
    private JScrollPane panelScrollJuego;
    private JLabel imagenFondo;

    protected JLabel etiquetaVidas;
    protected JLabel etiquetaVidasContorno;

    protected JLabel etiquetaPuntaje;
    protected JLabel etiquetaPuntajeContorno;

    protected JLabel etiquetaTiempo;
    protected JLabel etiquetaTiempoContorno;

    

    protected EntidadJugador personaje;
    protected ControladorTimer controladorTimer;

    public PantallaJuego(EntidadJugador jugador, ControladorTimer c) {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        setLayout(new BorderLayout());
        inicializarComponentes();

        controladorTimer = c;
        personaje = jugador;

        crearEtiquetas();
        agregarEtiquetasPanel();
    }

    private void inicializarComponentes() {
        panelJuego = new JPanel();
        panelJuego.setLayout(null);

        panelScrollJuego = new JScrollPane(panelJuego);
        panelScrollJuego.setHorizontalScrollBar(new InvisibleScrollBar());
        panelScrollJuego.setVerticalScrollBar(new InvisibleScrollBar());
        panelScrollJuego.setBounds(0, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);

        panelJuego.setBackground(new Color(79, 128, 248));
        
        imagenFondo = new JLabel();
        imagenFondo.setLayout(null);
        imagenFondo.setBounds(0, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);

        panelJuego.add(imagenFondo);
        
        add(panelScrollJuego, BorderLayout.CENTER);
    }   

    private void actualizarPanel() {
        revalidate();
        repaint();
    }

    public Observer incorporarEntidadLogica(EntidadLogica entidadLogica) {
        ObserverGrafico observer = new ObserverEntidades(entidadLogica);
        imagenFondo.add(observer);
        actualizarPanel();
        return observer;
    }

    public void removerEntidadLogica(EntidadLogica entidadLogica) {
        imagenFondo.remove((JLabel) entidadLogica.getObserver());
        actualizarPanel();
    }

    public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
        ObserverJugador observer = new ObserverJugador(this, entidadJugador);

        imagenFondo.add(observer);
        actualizarPanel();
        return observer;
    }

    private void crearEtiquetas() {
        etiquetaVidasContorno = new JLabel(String.valueOf("Vidas: " + personaje.getVidas()), SwingConstants.CENTER);
        etiquetaVidas = new JLabel(String.valueOf("Vidas: " + personaje.getVidas()), SwingConstants.CENTER);

        etiquetaPuntajeContorno  = new JLabel(String.valueOf("Puntaje: " + personaje.getPuntaje()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel(String.valueOf("Puntaje: " + personaje.getPuntaje()), SwingConstants.CENTER);

        etiquetaTiempoContorno = new JLabel(String.valueOf("Tiempo: " + controladorTimer.getTiempo() ), SwingConstants.CENTER);
        etiquetaTiempo = new JLabel(String.valueOf("Tiempo: " + controladorTimer.getTiempo() ), SwingConstants.CENTER);

        Font fuenteContorno;
        Font fuente;
    
        // Establecer el color de texto blanco
        etiquetaVidasContorno.setForeground(Color.BLACK); 
        etiquetaVidas.setForeground(Color.WHITE); 

        etiquetaPuntajeContorno.setForeground(Color.BLACK); 
        etiquetaPuntaje.setForeground(Color.WHITE); 

        etiquetaTiempoContorno.setForeground(Color.BLACK);
        etiquetaTiempo.setForeground(Color.WHITE);
    
        // Establecer la fuente
        try {
            fuenteContorno = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 22f);
            fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/Datos/font/PressStart2P-Regular.ttf")).deriveFont(Font.BOLD, 22f);

            etiquetaPuntajeContorno.setFont(fuenteContorno);
            etiquetaPuntaje.setFont(fuente);

            etiquetaVidasContorno.setFont(fuenteContorno);
            etiquetaVidas.setFont(fuente);

            etiquetaTiempoContorno.setFont(fuenteContorno);
            etiquetaTiempo.setFont(fuente);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        etiquetaPuntajeContorno.setBounds(130, 15,300, 60);
        etiquetaPuntaje.setBounds(125, 15,300, 60);

        etiquetaVidasContorno.setBounds(905,15,250,60);
        etiquetaVidas.setBounds(900,15,250,60);

        etiquetaTiempoContorno.setBounds(545,15,300,60);
        etiquetaTiempo.setBounds(540,15,300,60);
    }

    private void agregarEtiquetasPanel() {
        imagenFondo.add(etiquetaPuntaje);
        imagenFondo.add(etiquetaPuntajeContorno);

        imagenFondo.add(etiquetaVidas);
        imagenFondo.add(etiquetaVidasContorno);

        imagenFondo.add(etiquetaTiempo);
        imagenFondo.add(etiquetaTiempoContorno);
    }

    public Observer incorporarFondo(Fondo fondo) {
        ObserverGrafico observer = new ObserverEntidades(fondo);

        imagenFondo.setIcon(new ImageIcon(getClass().getResource(fondo.getSprite().getRutaImagen())));
        imagenFondo.setBounds(0, 0, imagenFondo.getIcon().getIconWidth(), imagenFondo.getIcon().getIconHeight());
        panelJuego.setPreferredSize(new Dimension(imagenFondo.getIcon().getIconWidth(), imagenFondo.getIcon().getIconHeight()));

        return observer;
    }


    public void actualizarScroll(EntidadJugador personaje) {
        if (personaje != null) {
            int x = 
                personaje.getX() + 
                ConstantesVistas.TAMANO_BLOQUE / 2 - 
                ConstantesVistas.PANEL_ANCHO / 2;

            if(panelScrollJuego.getHorizontalScrollBar().getValue() < x){
                panelScrollJuego.getHorizontalScrollBar().setValue(x);
                

                int scrollValue = panelScrollJuego.getHorizontalScrollBar().getValue();
                etiquetaPuntajeContorno.setLocation(new Point(scrollValue + 130, etiquetaPuntaje.getY()));
                etiquetaPuntaje.setLocation(new Point(scrollValue + 125, etiquetaPuntaje.getY()));

                etiquetaVidasContorno.setLocation(new Point(scrollValue + 905, etiquetaVidas.getY()));
                etiquetaVidas.setLocation(new Point(scrollValue + 900, etiquetaVidas.getY()));

                etiquetaTiempoContorno.setLocation(new Point(scrollValue + 545, etiquetaTiempo.getY()));
                etiquetaTiempo.setLocation(new Point(scrollValue + 540, etiquetaTiempo.getY()));
            }
        }
    }
    
    public int getPosScroll() {
        return panelScrollJuego.getHorizontalScrollBar().getValue();
    }

    private static class InvisibleScrollBar extends JScrollBar {
        @Override
        public void paint(Graphics g) {
            // No dibujar nada
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    }

    public void actualizarEtiquetaStatsPantallaJuego() {
        etiquetaPuntajeContorno.setText("Puntaje: " + personaje.getPuntaje());
        etiquetaPuntaje.setText("Puntaje: " + personaje.getPuntaje());

        etiquetaVidasContorno.setText("Vidas: " + personaje.getVidas());
        etiquetaVidas.setText("Vidas: " + personaje.getVidas());
    }


    public void actualizarLabelTiempo(int tiempo) {
        etiquetaTiempoContorno.setText("Tiempo: " + controladorTimer.getTiempo());
        etiquetaTiempo.setText("Tiempo: " + controladorTimer.getTiempo());
    }

    public ControladorTimer getControladorTimer(){
        return controladorTimer;
    }

}
