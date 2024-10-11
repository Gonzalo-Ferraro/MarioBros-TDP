package Vistas;

import Logica.Entidades.EntidadJugador;
import Vistas.PantallaJuego;

public class ObserverJugador extends ObserverGrafico {
	private PantallaJuego pantallaJuego;
	private EntidadJugador jugador_observado;
	
	public ObserverJugador(PantallaJuego pantallaJuego, EntidadJugador jugador_observado) {
		super(jugador_observado);
		this.pantallaJuego = pantallaJuego;
		this.jugador_observado = jugador_observado;
		actualizar();
	}
	
	public void actualizar() {
		super.actualizar();
		pantallaJuego.actualizarScroll(jugador_observado);
	}
}
