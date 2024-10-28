package Logica.Entidades;

import Logica.Juego.Juego;

public interface EntidadJugador extends EntidadLogica {
    public int getVidas();
    public int getPuntaje();
    public Juego getJuego();
}
