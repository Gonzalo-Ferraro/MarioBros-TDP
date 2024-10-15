package Logica.Entidades;

public class BuzzyBeetle extends Enemigo {

    public BuzzyBeetle(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.AfectarA(this);
    }

}
