package Logica.EstadosMario;

import Logica.Entidades.*;

public class MarioNormal extends EstadoMario {
    private boolean muerto;

    public MarioNormal(Personaje p) {
        super(p);
        muerto = false;
    }

    public void eliminar() {
        muerto = true;
        Sprite spriteAsignar = personaje.getEntidadGrafica().getSprite("mario-eliminado");
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
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
        Sprite spriteAsignar = personaje.getEntidadGrafica().getSprite("mario-eliminado");

        if(!muerto) {
            if (!personaje.estaEnElAire()) {
                if (!derecha && !izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
                } else if (derecha && izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
                } else if (derecha && !izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
                } else if (izquierda && !derecha) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
                }
            } else {
                if (!derecha && !izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
                } else if (derecha && izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
                } else if (derecha && !izquierda) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
                } else if (izquierda && !derecha) {
                    spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
                }
            }
        }
        
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    public void saltar(boolean derecha, boolean izquierda) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        personaje.setVelocidadY(ConstantesEstados.SALTO_MARIO_NORMAL);
        actualizarSpriteSaltar();
    }

    @Override
    public void lanzarBolaDeFuego() {
        //Mario en estado normal no puede lanzar bolas de fuego
    }

    private void actualizarSpriteSaltar() {
        Sprite spriteAsignar = personaje.getEntidadGrafica().getSprite("mario-eliminado");
        
        if(!muerto) {
            if (derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
            } else if (izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
            } else {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
            }
        }

        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    @Override
    public void actualizarAlCaer(boolean derecha,boolean izquierda){
        this.derecha = derecha;
        this.izquierda = izquierda;
        Sprite spriteAsignar = null;
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
        } else {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }


    //POWER-UPS
    @Override
    public void serAfectadoPor(Estrella estrella) {
        personaje.setPuntaje(20);
        personaje.getEntidadSonora().reproducirSonido("estrella");
        personaje.setEstado(new MarioInvulnerable(personaje, this));
    }

    @Override
    public void serAfectadoPor(FlorDeFuego florDeFuego) {
        personaje.setPuntaje(5);
        personaje.setEstado(new MarioFlorDeFuego(personaje));
    }

    @Override
    public void serAfectadoPor(SuperChampignon superChampignon) {
        personaje.setPuntaje(10);
        personaje.getEntidadSonora().reproducirSonido("powerup");
        personaje.setEstado(new SuperMario(personaje));
    }

    

    @Override
    public void AfectarA(LadrilloSolido ladrilloSolido) {
        //Mario en estado normal no puede romper bloques de ladrillo
    }

    @Override
    public void AfectarA(BloqueDePregunta bloqueDePregunta) {

    }
}
