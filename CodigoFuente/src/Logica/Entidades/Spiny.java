package Logica.Entidades;

public class Spiny extends Enemigo {

    public Spiny(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

}
