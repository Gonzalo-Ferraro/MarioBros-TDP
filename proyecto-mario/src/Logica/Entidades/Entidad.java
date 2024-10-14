package Logica.Entidades;


import Vistas.Observer;

public abstract class Entidad implements EntidadLogica {
    protected int x;
    protected int y;
    protected Sprite sprite;
    protected static int velocidad;
    protected Observer observador;
   

    protected Entidad(int x, int y, Sprite s){
        this.x = x;
        this.y = y;
        this.sprite = s;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void registrarObserver(Observer obs) {
        observador = obs;
        
    }
}
