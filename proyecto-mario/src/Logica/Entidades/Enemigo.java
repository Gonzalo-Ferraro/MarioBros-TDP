package Logica.Entidades;

public abstract class Enemigo extends Entidad implements AfectablePorMario, AfectadorAMario {

    protected Enemigo(int x, int y, Sprite s){
        super(x, y, s);
    }
}
