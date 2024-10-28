package Vistas;

import javax.swing.SwingUtilities;

import Logica.Entidades.EntidadJugador;

public class ObserverJugador extends ObserverGrafico {
	private PantallaJuego pantallaJuego;
	private EntidadJugador jugadorObservado;
	
	public ObserverJugador(PantallaJuego pantallaJuego, EntidadJugador jugadorObservado) {
		super(jugadorObservado);
		this.pantallaJuego = pantallaJuego;
		this.jugadorObservado = jugadorObservado;
		actualizarImagen();
		actualizarPosicionTamano();
	}
	
	public void actualizarPosicionTamano() {
		SwingUtilities.invokeLater(() -> {
			super.actualizarPosicionTamano();
			pantallaJuego.actualizarScroll(jugadorObservado);
		});
	}
}
