package Logica.Entidades;

import Vistas.Observer;

public class Personaje extends Entidad implements EntidadJugador {
    protected int vidas;
    protected int puntaje;

    private boolean derecha;
    private boolean izquierda;

    public Personaje(int x, int y, Sprite sprite) {
        super(x, y, sprite);

        velocidad = 5;
        derecha = false;
        izquierda = false;
        
        this.vidas=3;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getVidas(){
        return vidas;
    }

    public void mover() {
        if (derecha) {
            x += velocidad;
        }
        if (izquierda) {
            x -= velocidad;
        }

        observador.actualizar();
    }

    public void setDerecha(boolean b) {
        derecha = b;
    }

    public void setIzquierda(boolean b) {
        izquierda = b;
    }

    public Observer getObserver() {
        return observador;
    }

    public int getVelocidadActual() {
        int velocidadActual;

        if (derecha && !izquierda) {
            velocidadActual = velocidad;
        } else if (izquierda && !derecha) {
            velocidadActual = -velocidad;
        } else {
            velocidadActual = 0;
        }

        return velocidadActual;
    }
}
