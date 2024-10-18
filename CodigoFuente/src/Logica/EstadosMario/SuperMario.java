package Logica.EstadosMario;

import Logica.Entidades.BloqueDePregunta;
import Logica.Entidades.BuzzyBeetle;
import Logica.Entidades.Estrella;
import Logica.Entidades.FlorDeFuego;
import Logica.Entidades.Goomba;
import Logica.Entidades.KoopaTroopa;
import Logica.Entidades.LadrilloSolido;
import Logica.Entidades.Lakitu;
import Logica.Entidades.Personaje;
import Logica.Entidades.PiranhaPlant;
import Logica.Entidades.Spiny;
import Logica.Entidades.SuperChampignon;
import Logica.Fabricas.ModoDeJuego;

public class SuperMario extends EstadoMario {
    
    public SuperMario(Personaje p) {
        super(p);
    }

    @Override
    public void serAfectadoPor(Goomba g) {
       
    }

    @Override
    public void serAfectadoPor(SuperChampignon s) {
        personaje.setPuntaje(personaje.getPuntaje() + 50);
        
    }

    @Override
    public void serAfectadoPor(KoopaTroopa k) {
       
    }

    @Override
    public void serAfectadoPor(PiranhaPlant p) {
       
    }

    @Override
    public void serAfectadoPor(Lakitu l) {
       
    }

    @Override
    public void serAfectadoPor(Spiny s) {
       
    }

    @Override
    public void serAfectadoPor(BuzzyBeetle b) {
       
    }

    @Override
    public void serAfectadoPor(FlorDeFuego f) {
       
    }

    @Override
    public void serAfectadoPor(Estrella e) {
       
    }

    @Override
    public void AfectarA(Goomba g) {
        
    }

    @Override
    public void AfectarA(KoopaTroopa k) {
        
    }

    @Override
    public void AfectarA(PiranhaPlant p) {
        
    }

    @Override
    public void AfectarA(Lakitu l) {
        
    }

    @Override
    public void AfectarA(Spiny s) {
        
    }

    @Override
    public void AfectarA(BuzzyBeetle b) {
        
    }

    @Override
    public void AfectarA(BloqueDePregunta bloq) {
        
    }

    @Override
    public void AfectarA(LadrilloSolido ladrillo) {
        
    }

    @Override
    public void cambiarSprite(ModoDeJuego modo) {
    }

    @Override
    public void setDerecha(boolean derecha, boolean izquierda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDerecha'");
    }

    @Override
    public void setIzquierda(boolean izquierda, boolean derecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIzquierda'");
    }

    
    

}
