package Logica.Juego;

import Logica.Entidades.Enemigo;
import Logica.Entidades.Personaje;
import Logica.Entidades.PiranhaPlant;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import Vistas.ConstantesVistas;

import java.util.LinkedList;
import java.util.List;
import java.awt.Rectangle;


public class ControladorJugador implements Runnable {
    private Thread hiloJugador;
    private boolean corriendo = false;
    private Personaje personaje;
    private Nivel nivelActual;

    private List<Enemigo> enemigosAeliminar;
    private List<PowerUp> powerUpsAeliminar;

    private final double TIME_PER_FRAME = 1_000_000_000.0 / ConstantesVistas.FPS;

    public synchronized void empezarJuego() {
        if (corriendo) return;

        corriendo = true;

        nivelActual = personaje.getJuego().getNivelActual();

        hiloJugador = new Thread(this);
        hiloJugador.start();
    }

    public synchronized void detener() {
        if (!corriendo) return;
    
        corriendo = false;
        if (hiloJugador != null) {
            hiloJugador.interrupt();
        }
    }

    @Override
    public synchronized void run() {
        long ultimoTiempo = System.nanoTime();
        double delta = 0;

        while (corriendo) {
            if (Thread.currentThread().isInterrupted()) break; // Verificar interrupción
            long ahora = System.nanoTime();
            delta += (ahora - ultimoTiempo) / TIME_PER_FRAME;
            ultimoTiempo = ahora;

            while (delta >= 1) {
                actualizarJuego();
                delta--;
                if (!corriendo) break; // Salida rápida en la segunda condición
            }
        }
    }

    private synchronized void actualizarJuego() {
        moverPersonaje();
        decrementarTiempo();
    }

    private void decrementarTiempo() {
        personaje.getJuego().decrementarTiempo();
    }

    private void moverPersonaje() {
        detectarColisiones();
        eliminarEntidades();
        moverX();
        moverY();
    }
    
    private synchronized void detectarColisiones() {
        checkearColisionesConEnemigos();
        checkearColisionesConPowerUps();
    }
    
    private synchronized void checkearColisionesConEnemigos() {
        enemigosAeliminar= new LinkedList<>();
        for (Enemigo e : nivelActual.getEnemigos()) {
            if (personaje.getBounds().intersects(e.getBounds())) {
                if (personaje.estaCayendo()) {
                    e.serAfectadoPor(personaje); 
                    personaje.saltarLuegoDeColision();
                    enemigosAeliminar.add(e);
                } else {
                    e.afectarAMario(personaje);
                }
            }
        }

        for (PiranhaPlant p : nivelActual.getPiranhaPlants()) {
            if (personaje.getBounds().intersects(p.getBounds())) {
                p.afectarAMario(personaje);
            }
        }
    }
    
    private void checkearColisionesConPowerUps() {
        powerUpsAeliminar = new LinkedList<>();
        for (PowerUp p : nivelActual.getPowerUps()) {
            if (personaje.getBounds().intersects(p.getBounds())) {
                p.afectarAMario(personaje);
                powerUpsAeliminar.add(p);
            }
        }
    }

    private synchronized void eliminarEntidades(){
        for(Enemigo e : enemigosAeliminar)
            nivelActual.removerEntidad(e);

        for(PowerUp p : powerUpsAeliminar)
            nivelActual.removerEntidad(p);
    }
    
    private synchronized void moverX() {
        boolean condicion = sePuedeMoverHacia(
            personaje.getX() + personaje.getVelocidadX(), 
            personaje.getY()
        ) == null &&
        personaje.getX() + personaje.getVelocidadX() > personaje.getJuego().getPosScroll();

        if (condicion) {
            personaje.moverX();
        }
    }

    private synchronized void moverY() {
        if (personaje.estaEnElAire()) {
            Plataforma plataformaColisionada = sePuedeMoverHacia(
                personaje.getX(), 
                personaje.getY() + personaje.getVelocidadY()
            );

            if (plataformaColisionada == null) {
                personaje.moverY();
            } else {
                if (personaje.getVelocidadY() > 0) {
                    corregirPosicionArriba(plataformaColisionada);
                    personaje.setEstaEnElAire(false);
                    personaje.actualizarAlCaer();
                    personaje.setVelocidadY(0);
                } else if (personaje.getVelocidadY() < 0) {
                    corregirPosicionAbajo(plataformaColisionada);
                    personaje.setVelocidadY(0);
                }
            }
        } else {
            if (!estaEnElPiso()) {
                personaje.setEstaEnElAire(true);
            }
        }
    }

    private boolean estaEnElPiso() {
        return sePuedeMoverHacia(
            personaje.getX(), 
            personaje.getY() + 1
        ) != null;
    }


    private Plataforma sePuedeMoverHacia(int x, int y) {
        Rectangle hitbox = new Rectangle(personaje.getBounds());
        hitbox.setLocation(x, y);

        Plataforma toRet = null;
        for (Plataforma p : nivelActual.getPlataformas())
            if (hitbox.intersects(p.getBounds())) {
                toRet = p;
            }

        return toRet;
    }

 
    private void corregirPosicionArriba(Plataforma p) {
        personaje.setPosicionY(p.getY() - (int) personaje.getBounds().getHeight());
    }

    private void corregirPosicionAbajo(Plataforma p) {
        personaje.setPosicionY(p.getY() + (int) personaje.getBounds().getHeight());
        p.serAfectadoPor(personaje);
    }

    public void setPersonaje(Personaje p) {
        personaje = p;
    }
}