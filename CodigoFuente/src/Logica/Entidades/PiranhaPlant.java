package Logica.Entidades;

public class PiranhaPlant extends Enemigo {

    public PiranhaPlant(int x, int y, Sprite s){
        super(x, y, s);
        velocidadX = 0;
        
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
