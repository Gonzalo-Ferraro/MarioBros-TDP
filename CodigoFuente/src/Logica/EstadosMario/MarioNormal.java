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
    }

    @Override
    public void serAfectadoPor(FlorDeFuego florDeFuego) {
        personaje.setPuntaje(personaje.getPuntaje() + 5);
    }

    @Override
    public void serAfectadoPor(BuzzyBeetle buzzyBeetle) {
        // Implement the method logic here
    }

    @Override
    public void serAfectadoPor(Spiny spiny) {
        // Implement the method logic here
    }

    @Override
    public void serAfectadoPor(Lakitu lakitu) {
        // Implement the method logic here
    }

    @Override
    public void serAfectadoPor(PiranhaPlant piranhaPlant) {
        // Implement the method logic here
    }

    @Override
    public void serAfectadoPor(KoopaTroopa koopaTroopa) {
        // Implement the method logic here
    }

    @Override
    public void serAfectadoPor(SuperChampignon superChampignon) {
        personaje.setPuntaje(personaje.getPuntaje() + 10);
    }

    @Override
    public void serAfectadoPor(Goomba goomba) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(LadrilloSolido ladrilloSolido) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(BloqueDePregunta bloqueDePregunta) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(BuzzyBeetle buzzyBeetle) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(Spiny spiny) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(Lakitu lakitu) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(PiranhaPlant piranhaPlant) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(KoopaTroopa koopaTroopa) {
        // Implement the method logic here
    }

    @Override
    public void AfectarA(Goomba goomba) {
        // Implement the method logic here
    }

    @Override
    public void cambiarSprite(ModoDeJuego modo) {
        // Implement the method logic here
    }


}
