package Logica.EstadosMario;

import Logica.Entidades.*;
import Logica.Fabricas.ModoDeJuego;

public class MarioNormal extends EstadoMario {
    public MarioNormal(Personaje p) {
        super(p);
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
    public void serAfectadoPor(BuzzyBeetle buzzyBeetle) {
        
    }

    @Override
    public void serAfectadoPor(Spiny spiny) {
        
    }

    @Override
    public void serAfectadoPor(Lakitu lakitu) {
        
    }

    @Override
    public void serAfectadoPor(PiranhaPlant piranhaPlant) {
      
    }

    @Override
    public void serAfectadoPor(KoopaTroopa koopaTroopa) {
        
    }

    @Override
    public void serAfectadoPor(SuperChampignon superChampignon) {
        personaje.setPuntaje(personaje.getPuntaje() + 10);
        personaje.setEstado(new SuperMario(personaje));
    }

    @Override
    public void serAfectadoPor(Goomba goomba) {
        
    }

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
