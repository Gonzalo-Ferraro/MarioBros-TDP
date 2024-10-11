package Logica.Entidades;

public class Personaje implements EntidadJugador {
    protected int vidas;
    protected int puntaje;

    public Personaje(int vidas){
        this.vidas=vidas;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getVidas(){
        return vidas;
    }
}
