package Logica.Juego;

import Logica.Entidades.Enemigo;
import Logica.Entidades.Plataforma;
import Vistas.ConstantesVistas;
import java.awt.Rectangle;
import java.util.Random;

public class ControladorEntidades extends Thread {
    private Nivel nivel;

    private Thread hiloEntidades;
    private boolean corriendo;
    private final double TIME_PER_FRAME = 1_000_000_000.0 / ConstantesVistas.FPS;

    public void setNivel(Nivel n){
        nivel = n;
    }

    public synchronized void iniciar(){
        if (corriendo) return;
        corriendo = true;
        hiloEntidades = new Thread(this);
        hiloEntidades.start();
    }

    public synchronized void detener() {
        if (!corriendo) return;
    
        corriendo = false;
        if (hiloEntidades != null) {
            hiloEntidades.interrupt();
        }
    }

    @Override
    public void run() {
            long ultimoTiempo = System.nanoTime();
            double delta = 0;
    
            while (corriendo) {
                long ahora = System.nanoTime();
                delta += (ahora - ultimoTiempo) / TIME_PER_FRAME;
                ultimoTiempo = ahora;
    
                while (delta >= 1) {
                    moverEntidades();
                    delta--;
                }
            }
        }
        
        private synchronized void moverEntidades() {
            
            Random r = new Random();

            for(Enemigo e : nivel.getEnemigos()){
                if (r.nextInt(600) < 5) {
                    e.cambiarDireccion();
                }

                if(sePuedeMoverHacia(e, e.getX() + e.getVelocidadX(), e.getY()) == null)
                    e.moverX();


                if (e.estaEnElAire()) {
                    Plataforma p = sePuedeMoverHacia(e, e.getX(), e.getY() + e.getVelocidadY());
                    if (p != null) {
                        e.setEstaEnElAire(false);
                        corregirPosicionArriba(p, e);
                        e.setVelocidadY(0);
                        
                    } else {
                        e.moverY();
                    }
                } else if (sePuedeMoverHacia(e, e.getX(), e.getY() + 1) == null) {
                    e.setEstaEnElAire(true);
                }
        }
    }

    private Plataforma sePuedeMoverHacia(Enemigo e,int x, int y) {
        Rectangle hitbox = new Rectangle(e.getBounds());
        hitbox.setLocation(x, y);

        Plataforma toRet = null;
        for (Plataforma p : nivel.getPlataformas())
            if (hitbox.intersects(p.getBounds())) {
                toRet = p;
                break;
            }

        return toRet;
    }

    private void corregirPosicionArriba(Plataforma p, Enemigo e) {
        e.setPosicionY(p.getY() - (int) e.getBounds().getHeight());
    }
}  

