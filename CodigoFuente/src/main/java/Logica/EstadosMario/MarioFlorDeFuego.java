package Logica.EstadosMario;

import Logica.Entidades.*;
import Logica.Juego.Juego;

public class MarioFlorDeFuego extends SuperMario{
    public MarioFlorDeFuego(Personaje p) {
            super(p);      
    }

    @Override
    public void setDerecha(boolean d, boolean i) {
        derecha = d;
        izquierda = i;
        actualizarSprite();
    }

    @Override
    public void setIzquierda(boolean d, boolean i) {
        derecha = d;
        izquierda = i;
        actualizarSprite();
    }

    private void actualizarSprite() {
        Sprite spriteAsignar = null;

        if (!personaje.estaEnElAire()) {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-quieto-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-quieto-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-movimiento-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-movimiento-izquierda");
            }
        } else {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-izquierda");
            }
        }
        
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    public void saltar(boolean derecha, boolean izquierda) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        personaje.setVelocidadY(ConstantesEstados.SALTO_MARIO_SUPER);
        actualizarSpriteSaltar();
    }

    @Override
    public void lanzarBolaDeFuego() {
        Juego juego = personaje.getJuego();
        boolean condicion = 
            juego.getNivelActual().obtenerCantidadBolasDeFuego() 
            < ConstantesEstados.CANTIDAD_MAXIMA_BOLAS_DE_FUEGO;

        if (condicion) {
            juego.agregarBolaDeFuego(personaje.getX(), personaje.getY(), personaje.getVelocidadX());
            juego.getEntidadSonora().reproducirSonido("bola");
        }
    }

    private void actualizarSpriteSaltar() {
        Sprite spriteAsignar = null;

        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-saltando-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    public void actualizarAlCaer(boolean derecha,boolean izquierda){
        this.derecha = derecha;
        this.izquierda = izquierda;
        Sprite spriteAsignar = null;
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-movimiento-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-movimiento-izquierda");
        } else {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioflordefuego-quieto-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }


    @Override
    public void serAfectadoPor(FlorDeFuego f) {
        personaje.setPuntaje(50);
    }

}

