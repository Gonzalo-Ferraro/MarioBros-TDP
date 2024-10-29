package Logica.Entidades;

public class Goomba extends Enemigo {

    public Goomba(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
        desaparecer();
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void serAfectadoPorBola(Personaje p) {
        serAfectadoPor(p);
    }
}   
