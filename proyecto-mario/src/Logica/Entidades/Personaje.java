package Logica.Entidades;

public class Personaje extends Entidad implements EntidadJugador {
    protected int vidas;
    protected int puntaje;

    public Personaje(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        
        this.vidas=3;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getVidas(){
        return vidas;
    }
}
