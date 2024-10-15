package Logica.Entidades;

public class KoopaTroopa extends Enemigo {

    public KoopaTroopa(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

}
