package Logica.Launcher;

import Datos.EntidadSonora;
import Logica.Juego.Juego;
import Vistas.ControladorVistas;

public class Launcher {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ControladorVistas controladorVistas = new ControladorVistas(juego);
        juego.setControladorVistas(controladorVistas);
        juego.setEntidadSonora(new EntidadSonora());
        controladorVistas.mostrarMenu();
    }
}