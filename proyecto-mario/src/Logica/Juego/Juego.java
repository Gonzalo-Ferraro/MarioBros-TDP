package Logica.Juego;

import Datos.GeneradorDeNiveles;
import Logica.Fabricas.ModoDeJuego;
import Vistas.ControladorVistas;
import  Logica.Entidades.*;
public class Juego {
    private ControladorVistas controladorVistas;
    private ModoDeJuego modo;
    private Nivel nivelActual;
    protected Personaje personaje;

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }

    public void iniciar(ModoDeJuego m) {
        modo = m;
        nivelActual = GeneradorDeNiveles.generarNivel(m, 1);
    }
    
    public Personaje obtenerPersonaje(){
        return personaje;
    }
    
}
