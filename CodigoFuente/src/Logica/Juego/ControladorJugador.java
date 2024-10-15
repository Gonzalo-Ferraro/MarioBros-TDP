package Logica.Juego;

import Logica.Entidades.Personaje;
import Vistas.ConstantesVistas;

public class ControladorJugador implements Runnable {
    // Game loop thread
    private Thread gameThread;
    private boolean running = false;
    private Personaje personaje;

    private final double TIME_PER_FRAME = 1_000_000_000.0 / ConstantesVistas.FPS;

    /*
    private int frames = 0;
    */
    private int actualizaciones = 0;


    public synchronized void empezarJuego() {
        if (running) return; // Prevent starting multiple threads
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void frenarJuego() {
        if (!running) return;
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
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
                actualizarJuego();
                actualizaciones++;
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

    private void actualizarJuego() {
        personaje.mover();
    }

    public void setPersonaje(Personaje p) {
        personaje = p;
    }
}