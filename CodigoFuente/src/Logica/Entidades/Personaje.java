package Logica.Entidades;

import Logica.Juego.Juego;
import Vistas.Observer;

public class Personaje extends Entidad implements EntidadJugador {
    private Juego juego;

    protected int vidas;
    protected int puntaje;

    private boolean derecha;
    private boolean izquierda;

    public Personaje(int x, int y, Sprite sprite) {
        super(x, y, sprite);

        velocidad = 7;
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

    public void setJuego(Juego j) {
        juego = j;
    }

    public void mover() {
        if (derecha) {
            x += velocidad;
        }
        if (izquierda) {
            x -= velocidad;
        }

        observador.actualizarPosicionTamano();
    }

    public void setDerecha(boolean b) {
        derecha = b;
        
        if (!b && !izquierda)
        sprite = juego.getModo().getMarioQuietoDerecha();
        else if (b && izquierda)
        sprite = juego.getModo().getMarioQuietoIzquierda();
        
        actualizarSprite();
    }

    public void setIzquierda(boolean b) {
        izquierda = b;
        actualizarSprite();

        if (!b && !derecha)
            sprite = juego.getModo().getMarioQuietoIzquierda();
        else if (b && derecha)
            sprite = juego.getModo().getMarioQuietoDerecha();

        actualizarSprite();
    }

    private void actualizarSprite() {
        if (derecha && !izquierda) 
            sprite = juego.getModo().getMarioMoviendoDerecha();
        else if (izquierda && !derecha)
            sprite = juego.getModo().getMarioMoviendoIzquierda();

        observador.actualizarImagen();
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
