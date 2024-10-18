package Logica.Juego;

import Vistas.ConstantesVistas;
import Logica.Entidades.Enemigo;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import java.util.Random;
public class ControladorEntidades extends Thread {
    private Nivel nivel;

    private Thread gameThread;
    private boolean running;
    private final double TIME_PER_FRAME = 1_000_000_000.0 / ConstantesVistas.FPS;

    public void setNivel(Nivel n){
        nivel = n;
    }

    public synchronized void iniciar(){
        if (running) return; // Prevent starting multiple threads
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void detener() {
        if (!running) return;
        running = false;

        gameThread.interrupt();
    }

    @Override
    public void run() {
            long ultimoTiempo = System.nanoTime();
            double delta = 0;
    
            while (running) {
                long ahora = System.nanoTime();
                delta += (ahora - ultimoTiempo) / TIME_PER_FRAME;
                ultimoTiempo = ahora;
    
                // Update the game state as many times as needed
                while (delta >= 1) {
                    moverEntidades();
                    delta--;
                }
            }
        }
        
        private synchronized void moverEntidades(){
            Random r = new Random();
            for(Enemigo enemigo : nivel.getEnemigos()) {
                if(r.nextInt(100) < 5) {
                    enemigo.cambiarDireccion();
                }
                enemigo.mover();
            }
            System.out.println("Running: " + running);
        }

        
}
