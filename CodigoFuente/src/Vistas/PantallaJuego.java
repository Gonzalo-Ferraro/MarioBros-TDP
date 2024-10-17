package Vistas;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class PantallaJuego extends JPanel {
    private JPanel panelJuego;
    private JScrollPane panelScrollJuego;
    private JLabel imagenFondo;

    public PantallaJuego() {
		setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO));
        setLayout(new BorderLayout());
        inicializarComponentes();
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

    public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
        ObserverJugador observer = new ObserverJugador(this, entidadJugador);
        imagenFondo.add(observer);
        actualizarPanel();
        return observer;
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

            if(panelScrollJuego.getHorizontalScrollBar().getValue() < x)
                panelScrollJuego.getHorizontalScrollBar().setValue(x);
        }
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
}
