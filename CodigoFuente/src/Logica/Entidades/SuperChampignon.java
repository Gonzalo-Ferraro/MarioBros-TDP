package Logica.Entidades;

public class SuperChampignon extends PowerUp {
    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
    }
    public SuperChampignon(int x, int y, Sprite s){
        super(x, y, s);
    }
}