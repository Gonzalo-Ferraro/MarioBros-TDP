package Logica.Entidades;
import Logica.Fabricas.Sprite;


public abstract class Enemigo extends Entidad implements AfectablePorMario, AfectadorAMario {

    protected Enemigo(int x, int y, Sprite s){
        super(x, y, s);
    }
}
