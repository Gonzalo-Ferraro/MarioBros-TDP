package Logica.Launcher;

import Datos.EntidadSonora;
import Logica.Juego.Juego;
import Vistas.ControladorVistas;
import java.awt.EventQueue;

public class Launcher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    Juego juego = new Juego();
                    ControladorVistas controladorVistas = new ControladorVistas(juego);
                    juego.setControladorVistas(controladorVistas);
                    juego.setEntidadSonora(EntidadSonora.getInstance());
                    controladorVistas.mostrarMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}