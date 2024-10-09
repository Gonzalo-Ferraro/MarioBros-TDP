package Logica.Launcher;

import Logica.Juego.Juego;
import Vistas.ControladorVistas;

public class Launcher {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ControladorVistas controlador_vistas = new ControladorVistas(juego);
        juego.setControladorVistas(controlador_vistas);
        controlador_vistas.mostrarMenu();
    }
}
