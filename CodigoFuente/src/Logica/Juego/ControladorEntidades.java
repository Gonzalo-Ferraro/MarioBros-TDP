package Logica.Juego;

import Logica.Entidades.Enemigo;
import Logica.Entidades.Plataforma;
import Vistas.ConstantesVistas;

import java.awt.Rectangle;
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

            for(Enemigo e : nivel.getEnemigos()){
                if(r.nextInt(600) < 5) {
                    e.cambiarDireccion();
                }
                if(sePuedeMoverHacia(e, e.getX() + e.getVelocidadX(), e.getY()) == null)
                 e.moverX();
                

                if(sePuedeMoverHacia(e, e.getX(), e.getY() + 1) == null){ //enemigo en el aire
                    e.setEstaEnElAire(true);
                    
                }
                else{
                    e.setEstaEnElAire(false);
                    
                }
                e.moverY();
        }


    }
    private Plataforma sePuedeMoverHacia(Enemigo e,int x, int y) {
        Rectangle hitbox = new Rectangle(e.getBounds());
        hitbox.setLocation(x, y);

        Plataforma toRet = null;
        for (Plataforma p : nivel.getPlataformas())
            if (hitbox.intersects(p.getBounds())) {
                toRet = p;
            }

        return toRet;
    }
}  

