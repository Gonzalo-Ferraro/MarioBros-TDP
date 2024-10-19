package Logica.EstadosMario;

import Logica.Entidades.*;
import Logica.Fabricas.ModoDeJuego;

public class MarioNormal extends EstadoMario {

    public MarioNormal(Personaje p) {
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

        if (!derecha && !izquierda && !personaje.estaEnElAire()) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        } else if (derecha && izquierda && !personaje.estaEnElAire()  ) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
        } else if (derecha && !izquierda && !personaje.estaEnElAire() ) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        } else if (izquierda && !derecha&& !personaje.estaEnElAire() ) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
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

    private void actualizarSpriteSaltar() {
        Sprite spriteAsignar = null;

        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    public void actualizarAlCaer(boolean derecha,boolean izquierda){
        this.derecha = derecha;
        this.izquierda = izquierda;
        Sprite spriteAsignar = null;
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    @Override
    public void serAfectadoPor(Estrella estrella) {
        personaje.setPuntaje(personaje.getPuntaje() + 20);
        personaje.getJuego().getEntidadSonora().reproducirSonido("estrella");
        personaje.setEstado(new MarioInvulnerable(personaje, this));
    }

    @Override
    public void serAfectadoPor(FlorDeFuego florDeFuego) {
        personaje.setPuntaje(personaje.getPuntaje() + 5);
        personaje.setEstado(new MarioFlorDeFuego(personaje));
    }

    @Override
    public void serAfectadoPor(SuperChampignon superChampignon) {
        personaje.setPuntaje(personaje.getPuntaje() + 10);
        personaje.getJuego().getEntidadSonora().reproducirSonido("powerup");
        personaje.setEstado(new SuperMario(personaje));
    }

    // LOS serAfectadoPor concretos en la clase EstadoMario fueron eliminados ( agregar en caso de querer usarlo para sprites )

    @Override
    public void AfectarA(LadrilloSolido ladrilloSolido) {
        
    }

    @Override
    public void AfectarA(BloqueDePregunta bloqueDePregunta) {
        
    }

    @Override
    public void AfectarA(BuzzyBeetle buzzyBeetle) {
        
    }

    @Override
    public void AfectarA(Spiny spiny) {
        
    }

    @Override
    public void AfectarA(Lakitu lakitu) {
        
    }

    @Override
    public void AfectarA(PiranhaPlant piranhaPlant) {
        
    }

    @Override
    public void AfectarA(KoopaTroopa koopaTroopa) {
        
    }

    @Override
    public void AfectarA(Goomba goomba) {
        personaje.setPuntaje(personaje.getPuntaje()+60);
    }
}
