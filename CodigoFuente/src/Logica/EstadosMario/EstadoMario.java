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

public abstract class EstadoMario  {

    protected Personaje personaje;
    protected boolean derecha;
    protected boolean izquierda;

    protected int direccion;
    public EstadoMario(Personaje p) {
        personaje = p;
        derecha = false;
        izquierda = false;
    }

    public abstract void setDerecha(boolean derecha,boolean izquierda);
    public abstract void setIzquierda(boolean izquierda, boolean derecha);

    public void serAfectadoPor(Goomba g){
        personaje.setPuntaje(-30);
        personaje.perderVida();
    }

    public void serAfectadoPor(KoopaTroopa k){
        personaje.setPuntaje(-45);
        personaje.perderVida();
    }

    public void serAfectadoPor(PiranhaPlant p){
        personaje.setPuntaje(-30);
        personaje.perderVida();
    }

    public void serAfectadoPor(Lakitu l){
        personaje.perderVida();
    }

    public void serAfectadoPor(Spiny s){
        personaje.perderVida();
        personaje.setPuntaje(-30);
    }

    public void serAfectadoPor(BuzzyBeetle b){
        personaje.setPuntaje(-15);
        personaje.perderVida();
    }

    public  void serAfectadoPor(Vacio v){
        personaje.setPuntaje(-15);
        personaje.perderVida();
    }

    public void serAfectadoPor(ChampignonVerde c){
        personaje.setPuntaje(100);
        personaje.aumentarVidas();
    }

    public  void serAfectadoPor(Moneda m){
        personaje.setPuntaje(50);
        personaje.getJuego().getEntidadSonora().reproducirSonido("moneda");
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
   

    public abstract void saltar(boolean derecha, boolean izquierda);
    public abstract void actualizarAlCaer(boolean derecha, boolean izquierda);

    public void espacio(){
        personaje.espacio();
    }
}
