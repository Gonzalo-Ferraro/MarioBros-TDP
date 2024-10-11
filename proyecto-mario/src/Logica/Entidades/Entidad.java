package Logica.Entidades;
import Logica.Fabricas.Sprite;

public abstract class Entidad  implements EntidadLogica{
    protected int x;
    protected int y;
    protected Sprite sprite;
    protected static int velocidad;
    // protected ObserverGrafico observador;

    protected Entidad(int x, int y, Sprite s){
        this.x = x;
        this.y = y;
        this.sprite = s;
    }

}
