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

    public synchronized void detener(){
        if (!running) return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        
            // Timing variables
            long ultimoTiempo = System.nanoTime();
            double delta = 0;
    
            //long timer = System.currentTimeMillis(); Utilizado para el conteo de fps
    
            while (running) {
                long ahora = System.nanoTime();
                delta += (ahora - ultimoTiempo) / TIME_PER_FRAME;
                ultimoTiempo = ahora;
    
                // Update the game state as many times as needed
                while (delta >= 1) {
                    System.out.println("moviendo entidad");
                    moverEntidades();
                    //controlarColisiones();
                    delta--;
                }
    
                // Render the game
                /* 
                frames++;
    
                // Print FPS and UPS every second
                
                if (System.currentTimeMillis() - timer >= 1000) {
                    System.out.println("FPS: " + frames + ", UPS: " + actualizaciones);
                    frames = 0;
                    actualizaciones = 0;
                    timer += 1000;
                }
                Comentado para tener mayor fluidez en el juego. 
                */
            }
        }
        
        private void moverEntidades(){
            Random r=new Random();
            for(Enemigo enemigo : nivel.getEnemigos()){
                if(r.nextInt(100)<5){
                    enemigo.cambiarDireccion();
                    System.out.println("Cambiando direccion");
                }
                enemigo.mover();
            }
        }

        
}
