package Logica.Juego;

import Logica.Entidades.Enemigo;
import Logica.Entidades.Personaje;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import Vistas.ConstantesVistas;
import java.awt.Rectangle;
import java.util.LinkedList;

public class ControladorJugador implements Runnable {
    // Game loop thread
    private Thread hiloJugador;
    private boolean corriendo = false;
    private Personaje personaje;
    private Nivel nivelActual;

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

        hiloJugador.interrupt();
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
                actualizarJuego();
                delta--;
            }
        }
    }

    private void actualizarJuego() {
        moverPersonaje();
    }

    private void moverPersonaje() {
        detectarColisiones();
        moverX();
        moverY();
    }

    private void moverY() {
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

    private void moverX() {
        boolean condicion = sePuedeMoverHacia(
            personaje.getX() + personaje.getVelocidadX(), 
            personaje.getY()
        ) == null &&
        personaje.getX() + personaje.getVelocidadX() > personaje.getJuego().getPosScroll();

        if (condicion) {
            personaje.moverX();
        }
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

    private void detectarColisiones() {
        checkearColisionesConEnemigos();
        checkearColisionesConPowerUps();
    }

    private void checkearColisionesConEnemigos() {
        LinkedList<Enemigo> enemigosAEliminar = new LinkedList<>();
        for (Enemigo e : nivelActual.getEnemigos()) {
            if (personaje.getBounds().intersects(e.getBounds())) {
                if (personaje.estaCayendo()) {
                    e.serAfectadoPor(personaje);
                    enemigosAEliminar.add(e);
                } else {
                    e.afectarAMario(personaje);
                }
            }
        }

        for(Enemigo e : enemigosAEliminar) {
            nivelActual.removerEntidad(e);
        }
    }

    private void checkearColisionesConPowerUps() {
        for (PowerUp p : nivelActual.getPowerUps()) {
            if (personaje.getBounds().intersects(p.getBounds())) {
                p.afectarAMario(personaje);
            }
        }
    }
    
    private void corregirPosicionArriba(Plataforma p) {
        personaje.setPosicionY(p.getY() - (int) personaje.getBounds().getHeight());
    }

    private void corregirPosicionAbajo(Plataforma p) {
        personaje.setPosicionY(p.getY() + (int) personaje.getBounds().getHeight());
    }

    public void setPersonaje(Personaje p) {
        personaje = p;
    }
}