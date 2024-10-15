package Logica.Launcher;

import Datos.EntidadSonora;
import Logica.Juego.Juego;
import Vistas.ControladorVistas;

public class Launcher {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ControladorVistas controlador_vistas = new ControladorVistas(juego);
        juego.setControladorVistas(controlador_vistas);
        juego.setEntidadSonora(new EntidadSonora());
        controlador_vistas.mostrarMenu();
    }
}