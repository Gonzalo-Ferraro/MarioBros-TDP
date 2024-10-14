package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;

import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Dimension;


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
        panelScrollJuego.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelScrollJuego.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelScrollJuego.setBounds(0, 0, ConstantesVistas.PANEL_ANCHO, ConstantesVistas.PANEL_ALTO);

        
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
        panelJuego.add(observer);
        System.out.println("Entidad agregada: " + entidadLogica);
        actualizarPanel();
        return observer;
    }

    public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
        ObserverJugador observer = new ObserverJugador(this, entidadJugador);
        imagenFondo.add(observer);
        System.out.println("Entidad agregada: " + entidadJugador);
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
            int x = personaje.getX() + 40 - getWidth() / 2;

            panelScrollJuego.getHorizontalScrollBar().setValue(x);
        }
    }
}
