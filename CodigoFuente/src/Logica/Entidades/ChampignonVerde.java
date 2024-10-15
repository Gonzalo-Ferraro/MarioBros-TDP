package Logica.Entidades;

public class ChampignonVerde extends PowerUp {

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

    public ChampignonVerde(int x, int y, Sprite s){
        super(x, y, s);
    }

}
