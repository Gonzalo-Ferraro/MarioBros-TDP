package Logica.Juego;

import Logica.Entidades.Enemigo;
import Vistas.ConstantesVistas;
import java.util.Iterator;
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
            
            Iterator<Enemigo> it = nivel.getEnemigos().iterator();
            Random r = new Random();
            
            while(it.hasNext()){
                Enemigo enemigoIt = it.next();

                if(r.nextInt(500) < 5) {
                    enemigoIt.cambiarDireccion();
                }

                enemigoIt.mover();
                
            }

        }

        
}
