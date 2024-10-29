package Logica.Juego;

import Logica.Entidades.BolaDeFuego;
import Logica.Entidades.ConstantesEntidades;
import Logica.Entidades.Enemigo;
import Logica.Entidades.Entidad;
import Logica.Entidades.PiranhaPlant;
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

    public synchronized void iniciar() {
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
                if (!corriendo) break;

                actualizarJuego();

                delta--;
            }
        }
    }

    private synchronized void actualizarJuego() {
        checkearColisionesConBolasDeFuego();
        moverEntidades();
    }

    private synchronized void checkearColisionesConBolasDeFuego() {
        for (BolaDeFuego bola : nivel.getBolasDeFuego())
            if (bola.getViva()) {
                for (Enemigo e : nivel.getEnemigos())
                    if (bola.getBounds().intersects(e.getBounds())) {
                        e.serAfectadoPorBola(nivel.getPersonaje());
                        e.desaparecer();
                        nivel.decrementarBolasDeFuego();
                        bola.desaparecer();
                    }
                
                for (PiranhaPlant p : nivel.getPiranhaPlants())
                    if (bola.getBounds().intersects(p.getBounds())) {
                        p.serAfectadoPorBola(nivel.getPersonaje());
                        nivel.decrementarBolasDeFuego();
                        bola.desaparecer();
                    }
            }
    }
        
    private synchronized void moverEntidades() {
        Random r = new Random();

        for( Enemigo e : nivel.getEnemigos()) {
            if (r.nextInt(600) < 5)
                e.cambiarDireccion();

            moverX(e);
            moverY(e);
        }

        for (PiranhaPlant p : nivel.getPiranhaPlants())
            p.moverY();

        for (BolaDeFuego bola : nivel.getBolasDeFuego()) {
            if (bola.getViva()) {
                moverX(bola);
                moverY(bola);
            }
        }
    }

    private void moverX(BolaDeFuego bola) {
        Plataforma plataforma = sePuedeMoverHacia(bola, bola.getX() + bola.getVelocidadX(), bola.getY());

        if (plataforma == null)
            bola.moverX();
        else {
            bola.cambiarDireccion();
            bola.choque();

            plataforma.serAfectadoPorBola();

            if (bola.getChoques() >= ConstantesEntidades.CANTIDAD_CHOQUES_BOLA_DE_FUEGO) {
                nivel.decrementarBolasDeFuego();
                bola.desaparecer();
            }
        }
    }

    private void moverY(BolaDeFuego bola) {
        Plataforma plataforma = sePuedeMoverHacia(bola, bola.getX(), bola.getY() + bola.getVelocidadY());
        if (plataforma != null) {
            bola.reboteSuelo();
            bola.choque();
            corregirPosicionArriba(plataforma, bola);

            plataforma.serAfectadoPorBola();

            if (bola.getChoques() >= ConstantesEntidades.CANTIDAD_CHOQUES_BOLA_DE_FUEGO) {
                nivel.decrementarBolasDeFuego();
                bola.desaparecer();
            }
        } else {
            bola.moverY();
            checkearLimites(bola);
        }
    }

    private void checkearLimites(BolaDeFuego bola) {
        if (bola.getY() > ConstantesVistas.VENTANA_ALTO) {
            nivel.decrementarBolasDeFuego();
            bola.desaparecer();
        }
    }

    private void moverX(Enemigo e) {
        if (sePuedeMoverHacia(e, e.getX() + e.getVelocidadX(), e.getY()) == null)
            e.moverX();
        else
            e.cambiarDireccion();
    }

    private void moverY(Enemigo e) {
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

    private Plataforma sePuedeMoverHacia(Entidad e,int x, int y) {
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

    private void corregirPosicionArriba(Plataforma p, BolaDeFuego bola) {
        bola.setPosicionY(p.getY() - (int) bola.getBounds().getHeight());
    }
}  

