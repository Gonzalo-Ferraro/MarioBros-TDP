package Logica.Juego;

import Vistas.ConstantesVistas;
import Vistas.PantallaJuego;

public class ControladorTimer implements Runnable {

    private Juego juego;
    private int tiempo;
    private boolean running;
    private Thread timerContador;

    private PantallaJuego pantallaJuego;
    

    public ControladorTimer(Juego j) {
        juego = j;
        tiempo = ConstantesVistas.TIEMPO_NIVEL;
        running = false;
        juego.setControladorTimer(this);
    }

    @Override
    public void run() {
        
        while (running && tiempo > 0) {
            try {
                Thread.sleep(1000);
                tiempo--;
                pantallaJuego.actualizarLabelTiempo(tiempo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (tiempo == 0) {
            juego.finTimer();

        }
    }

    public synchronized void iniciar(){
        if (running) return; // Prevent starting multiple threads
        running = true;
        tiempo = ConstantesVistas.TIEMPO_NIVEL;
        timerContador = new Thread(this);
        timerContador.start();
    }

    public synchronized void detener() {
        if (!running) return;
        running = false;

        timerContador.interrupt();
    }
    
    public void setPantallaJuego(PantallaJuego pantallaJuego) {
        this.pantallaJuego = pantallaJuego;
    }

    public int getTiempo() {
        return tiempo;
    }

}
