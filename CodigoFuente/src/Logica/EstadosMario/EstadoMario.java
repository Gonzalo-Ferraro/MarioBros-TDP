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
    public abstract void saltar(boolean derecha, boolean izquierda);
    public abstract void actualizarAlCaer(boolean derecha, boolean izquierda);
    
    public void espacio(){
        personaje.espacio();
    }
    
    public void eliminar() {

    }

    //Ser afectado por ENEMIGOS
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
        personaje.setPuntaje(-30);
        personaje.perderVida();
    }

    public void serAfectadoPor(BuzzyBeetle b){
        personaje.setPuntaje(-15);
        personaje.perderVida();
    }

    
    public void serAfectadoPor(Vacio v){
        personaje.setPuntaje(-15);
        personaje.perderVida();
    }

    //POWER-UPS
    public void serAfectadoPor(ChampignonVerde c){
        personaje.setPuntaje(100);
        personaje.aumentarVidas();
    }

    public void serAfectadoPor(Moneda m){
        personaje.setPuntaje(5);
        personaje.getEntidadSonora().reproducirSonido("moneda");
    }

    public abstract void serAfectadoPor(FlorDeFuego f);
    public abstract void serAfectadoPor(Estrella e);
    public abstract void serAfectadoPor(SuperChampignon s);
    
    //Afectar a ENEMIGOS
    public void AfectarA(Goomba g){
        personaje.setPuntaje(60);
    }
    public void AfectarA(KoopaTroopa k){
        personaje.setPuntaje(90);
    }
    public void AfectarA(PiranhaPlant p){
        personaje.setPuntaje(30);
    }
    public void AfectarA(Lakitu l){
        personaje.setPuntaje(60);
    }
    public void AfectarA(Spiny s){
        personaje.setPuntaje(60);
    }
    public void AfectarA(BuzzyBeetle b){
        personaje.setPuntaje(30);
    }

    
    public void AfectarA(BloqueDePregunta bloq){
        bloq.serAfectadoPor(personaje);
    }

    public abstract void AfectarA(LadrilloSolido ladrillo);

}
