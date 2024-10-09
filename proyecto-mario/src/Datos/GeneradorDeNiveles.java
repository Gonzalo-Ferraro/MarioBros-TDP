package Datos;

import Logica.Fabricas.ModoDeJuego;
import Logica.Juego.Nivel;

public class GeneradorDeNiveles {
    public static Nivel generarNivel(ModoDeJuego m, int n) {
        return new Nivel();
    }
}
