package Vistas;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
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
    protected JLabel etiquetaPuntaje;

    protected EntidadJugador personaje;

    public PantallaJuego(EntidadJugador jugador) {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        setLayout(new BorderLayout());
        inicializarComponentes();

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
        etiquetaVidas = new JLabel(String.valueOf("Vidas: " + personaje.getVidas()), SwingConstants.CENTER);
        etiquetaPuntaje = new JLabel(String.valueOf("Puntaje: " + personaje.getPuntaje()), SwingConstants.CENTER);
    
        // Establecer el color de texto blanco
        etiquetaVidas.setForeground(Color.WHITE); 
        etiquetaPuntaje.setForeground(Color.WHITE); 
    
        // Establecer la fuente
        Font font = new Font("Arial", Font.PLAIN, 45);
        etiquetaPuntaje.setFont(font);
        etiquetaVidas.setFont(font);
    
        etiquetaPuntaje.setBounds(125, 15,300, 60);
        etiquetaVidas.setBounds(950,15,250,60);
    }

    private void agregarEtiquetasPanel() {
        imagenFondo.add(etiquetaPuntaje);
        imagenFondo.add(etiquetaVidas);
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
                etiquetaPuntaje.setLocation(new Point(scrollValue + 125, etiquetaPuntaje.getY()));
                etiquetaVidas.setLocation(new Point(scrollValue + 950, etiquetaVidas.getY()));
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
        etiquetaPuntaje.setText("Puntaje: " + personaje.getPuntaje());
        etiquetaVidas.setText("Vidas: " + personaje.getVidas());
    }
}
