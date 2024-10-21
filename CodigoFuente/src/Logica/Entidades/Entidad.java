package Logica.Entidades;


import Vistas.Observer;
import java.awt.Rectangle;

public abstract class Entidad implements EntidadLogica {
    protected int x;
    protected int y;
    protected Sprite sprite;
    protected  int velocidadX;
    protected  int direccion;
    

    protected Observer observador;
    protected EntidadGrafica entidadGrafica;
   

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

    public void setEntidadGrafica(EntidadGrafica entidadGrafica){
        this.entidadGrafica = entidadGrafica;
    }

    public void setDireccion(int direccion){
        this.direccion = direccion;
    }

    public Rectangle getBounds(){
        return observador.getBounds();
    }
    
    public Observer getObserver(){
        return observador;
    }

    protected void desaparecer() {
        x = -100;
        y = -100;
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }
}
