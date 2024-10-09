package Logica.Juego;

import Datos.GeneradorDeNiveles;
import Logica.Fabricas.ModoDeJuego;
import Vistas.ControladorVistas;

public class Juego {
    private ControladorVistas controladorVistas;
    private ModoDeJuego modo;
    private Nivel nivelActual;

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }

    public void iniciar(ModoDeJuego m) {
        modo = m;
        nivelActual = GeneradorDeNiveles.generarNivel(m, 1);
    }
}
