package Logica.Juego;

import java.util.Iterator;

import Logica.Entidades.Enemigo;
import Logica.Entidades.Personaje;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import Vistas.ConstantesVistas;

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
        detectarColisiones();
        personaje.mover();
    }

    private void detectarColisiones() {
        for (Enemigo e : nivelActual.getEnemigos()) {
            if (personaje.getBounds().intersects(e.getBounds())) {
                if (personaje.estaCayendo()) {
                    e.serAfectadoPor(personaje);
                } else {
                    e.afectarAMario(personaje);;
                }
            }
        }

        for (Plataforma p : nivelActual.getPlataformas()) {
            if (personaje.getBounds().intersects(p.getBounds())) {
                if (personaje.getVelocidadY() < 0) {
                    corregirPosicionArriba(p);
                    personaje.setEstaEnElAire(false);
                    personaje.actualizarAlCaer();
                    personaje.setVelocidadY(0);
                } else if (personaje.getVelocidadY() > 0) {
                    corregirPosicionAbajo(p);
                    personaje.setVelocidadY(0);
                }
                // Manejar colisiones laterales si es necesario
            }
        }

        Iterator<PowerUp> iter = nivelActual.getPowerUps().iterator();
            while (iter.hasNext()) {
            PowerUp p = iter.next();
            if (personaje.getBounds().intersects(p.getBounds())) {
                 p.afectarAMario(personaje);
                 try {
                    Thread.sleep(1);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }  // Aplica el efecto al personaje
                iter.remove();  // Elimina el PowerUp de la lista de forma segura
    }
}
    }
    
    private void corregirPosicionArriba(Plataforma p) {
        if (personaje.getY() + (int) personaje.getBounds().getHeight() >= p.getY()) {
            personaje.setPosicionY(p.getY() + (int) personaje.getBounds().getHeight());
        }
    }

    private void corregirPosicionAbajo(Plataforma p) {
        if (personaje.getY() - (int) personaje.getBounds().getHeight() <= p.getY()) {
            personaje.setPosicionY(p.getY() - (int) personaje.getBounds().getHeight());
        }
    }

    public void setPersonaje(Personaje p) {
        personaje = p;
    }
}