package Vistas;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;

import java.awt.Point;
import java.awt.Dimension;


public class PantallaJuego extends JScrollPane {
    public PantallaJuego() {
        super();

        setPreferredSize(new Dimension(ConstantesVistas.PANEL_ANCHO,ConstantesVistas.PANEL_ALTO));
    }

    private void actualizarPanel() {
        revalidate();
        repaint();
    }



     public Observer incorporarEntidadLogica(EntidadLogica entidadLogica) {
        ObserverGrafico observer = new ObserverGrafico(entidadLogica) {};
        getViewport().add((JLabel) observer);
        actualizarPanel();
        return observer;
    }

    public Observer incorporarEntidadJugador(EntidadJugador entidadJugador) {
        ObserverJugador observer = new ObserverJugador(this, entidadJugador);
        getViewport().add((JLabel) observer);
        actualizarPanel();
        return observer;
    }


    public Observer incorporarFondo(Fondo fondo) {
        ObserverGrafico observer = new ObserverGrafico(fondo) {};
        getViewport().add((JLabel) observer);
        actualizarPanel();
        return observer;
    }


    public void actualizarScroll(EntidadJugador personaje) {
        if (personaje != null) {
            int x = personaje.getX() - getWidth() / 2;
            int y = personaje.getY() - getHeight() / 2;
            getViewport().setViewPosition(new Point(x, y));
        }
    }
}
