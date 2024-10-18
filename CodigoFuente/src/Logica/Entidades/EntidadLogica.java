package Logica.Entidades;

import Vistas.Observer;

public interface EntidadLogica {
    public Sprite getSprite();
    public int getX();
    public int getY();
    public Observer getObserver();
}
