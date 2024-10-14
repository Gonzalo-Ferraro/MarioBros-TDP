package Logica.Juego;

import Vistas.ConstantesVistas;

public class ControladorEntidades extends Thread {
    private Nivel nivel;

    public void run() {
        while (true) {

            try {
                Thread.sleep(ConstantesVistas.DELAY_JUGADOR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
