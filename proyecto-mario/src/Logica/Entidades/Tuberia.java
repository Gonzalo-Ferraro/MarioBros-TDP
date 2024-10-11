package Logica.Entidades;
import Logica.Fabricas.Sprite;

public class Tuberia extends Plataforma {

    protected PiranhaPlant mPiranha;

    public Tuberia(int x, int y, Sprite s, PiranhaPlant p){
        super(x, y, s);
        mPiranha = p;
    }

}
