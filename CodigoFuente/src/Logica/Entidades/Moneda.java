package Logica.Entidades;

public class Moneda extends PowerUp {

    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
    }

    // CHECKEAR QUE SEA ASI

    public Moneda(int x, int y, Sprite s){
        super(x, y, s);
    }

}
