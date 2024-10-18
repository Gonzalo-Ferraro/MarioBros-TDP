package Logica.EstadosMario;

import Logica.Entidades.BloqueDePregunta;
import Logica.Entidades.BuzzyBeetle;
import Logica.Entidades.ChampignonVerde;
import Logica.Entidades.Estrella;
import Logica.Entidades.FlorDeFuego;
import Logica.Entidades.Goomba;
import Logica.Entidades.KoopaTroopa;
import Logica.Entidades.LadrilloSolido;
import Logica.Entidades.Lakitu;
import Logica.Entidades.Moneda;
import Logica.Entidades.Personaje;
import Logica.Entidades.PiranhaPlant;
import Logica.Entidades.Spiny;
import Logica.Entidades.SuperChampignon;
import Logica.Entidades.Vacio;
import Logica.Fabricas.ModoDeJuego;

public abstract class EstadoMario  {

    protected Personaje personaje;
    protected boolean derecha;
    protected boolean izquierda;

    protected int direccion;
    public EstadoMario(Personaje p) {
        personaje = p;
        
    }

    public abstract void setDerecha(boolean derecha,boolean izquierda);
    public abstract void setIzquierda(boolean izquierda, boolean derecha);

    public void serAfectadoPor(Goomba g){
        personaje.perderVida();
        personaje.setPuntaje(-30);
    }

    public void serAfectadoPor(KoopaTroopa k){
        personaje.perderVida();
        personaje.setPuntaje(-45);
    }

    public void serAfectadoPor(PiranhaPlant p){
        personaje.perderVida();
        personaje.setPuntaje(-30);
    }

    public void serAfectadoPor(Lakitu l){
        personaje.perderVida();
    }

    public void serAfectadoPor(Spiny s){
        personaje.perderVida();
        personaje.setPuntaje(-30);
    }

    public void serAfectadoPor(BuzzyBeetle b){
        personaje.perderVida();
        personaje.setPuntaje(-15);
    }

    public  void serAfectadoPor(Vacio v){
        personaje.perderVida();
        personaje.setPuntaje(-15);
    }

    public void serAfectadoPor(ChampignonVerde c){
        personaje.setVidas(1);
        personaje.setPuntaje(100);
    }

    public  void serAfectadoPor(Moneda m){
        personaje.setPuntaje(5);
    }

    public abstract void serAfectadoPor(FlorDeFuego f);
    public abstract void serAfectadoPor(Estrella e);
    public abstract void serAfectadoPor(SuperChampignon s);
    
    public abstract void AfectarA(Goomba g);
    public abstract void AfectarA(KoopaTroopa k);
    public abstract void AfectarA(PiranhaPlant p);
    public abstract void AfectarA(Lakitu l);
    public abstract void AfectarA(Spiny s);
    public abstract void AfectarA(BuzzyBeetle b);

    public abstract void AfectarA(BloqueDePregunta bloq);
    public abstract void AfectarA(LadrilloSolido ladrillo);

    // cambiar parametro cuando agreguemos el arreglo de sprites
    public abstract void cambiarSprite(ModoDeJuego modo );

    public void saltar(){
        personaje.saltar();
    }

    public void espacio(){
        personaje.espacio();
    }
}
