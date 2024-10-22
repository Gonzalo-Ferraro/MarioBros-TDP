package Logica.Entidades;

public class Estrella extends PowerUp {

    public Estrella(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
        desaparecer();
    }
}
