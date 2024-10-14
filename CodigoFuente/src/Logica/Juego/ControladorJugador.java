package Logica.Juego;

import Logica.Entidades.Personaje;
import Vistas.ConstantesVistas;

public class ControladorJugador extends Thread {
    private Personaje personaje;

    public void run() {
        while (true) {
            try {
                Thread.sleep(ConstantesVistas.DELAY_JUGADOR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            personaje.mover();
            
        }
    }

    public void setPersonaje(Personaje p) {
        personaje = p;
    }
}
