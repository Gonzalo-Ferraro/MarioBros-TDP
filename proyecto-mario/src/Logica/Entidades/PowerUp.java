package Logica.Entidades;
import Logica.Fabricas.Sprite;

public abstract class PowerUp extends Entidad implements AfectadorAMario {

    protected PowerUp(int x, int y, Sprite s){
        super(x, y, s);
    }
}
