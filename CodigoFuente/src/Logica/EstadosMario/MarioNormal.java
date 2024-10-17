package Logica.EstadosMario;

import Logica.Entidades.*;
import Logica.Fabricas.ModoDeJuego;

public class MarioNormal extends EstadoMario {

    public MarioNormal(Personaje p) {
        super(p);
    }

    public void setDireccion(int d){

        Sprite spriteAsignar = null;

        if(d == -1)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
        else 
            if(d == 1)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        
        if(d==-1 && direccion==1)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
        
        if(d==1 && direccion==-1)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");

        if(d==0)
                if(direccion==-1)
                        spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
                else
                        spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
    
        direccion = d;
        personaje.setSprite(spriteAsignar);
    }

    @Override
    public void setDerecha(boolean d, boolean i){
        derecha = d;
        izquierda = i;
        Sprite spriteAsignar = null;

        if (!derecha && !izquierda)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        else if (derecha && izquierda)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");

        // EX ACTUALIZARIMAGEN
        if (derecha && !izquierda) 
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        else if (izquierda && !derecha)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");

        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    
    @Override
    public void setIzquierda(boolean d, boolean i){
        derecha = d;
        izquierda = i;
        Sprite spriteAsignar = null;
        
        if (!izquierda && !derecha)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
        else if (izquierda && derecha)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");

        if (derecha && !izquierda) 
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        else if (izquierda && !derecha)
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");

        
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    @Override
    public void serAfectadoPor(Estrella estrella) {
        personaje.setPuntaje(personaje.getPuntaje() + 20);
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
        
    }

    @Override
    public void cambiarSprite(ModoDeJuego modo) {
        
    }


}
