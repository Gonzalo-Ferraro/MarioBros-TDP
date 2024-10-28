package Logica.Entidades;

public class ChampignonVerde extends PowerUp {

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
        if(this.observador != null)
            desaparecer();
    }

    public ChampignonVerde(int x, int y, Sprite s){
        super(x, y, s);
    }

}
