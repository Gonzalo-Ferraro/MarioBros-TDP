package Logica.Entidades;

public class SuperChampignon extends PowerUp {


    public SuperChampignon(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
        if(this.observador!=null)
            desaparecer();
    }
}