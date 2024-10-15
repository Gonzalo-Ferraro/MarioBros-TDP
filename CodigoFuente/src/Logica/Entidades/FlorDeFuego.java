package Logica.Entidades;

public class FlorDeFuego extends PowerUp implements AfectadorAMario {

    public FlorDeFuego(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
    }

}
