package Logica.Juego;

import java.util.List;

import Datos.GeneradorDeNiveles;
import Logica.Fabricas.ModoDeJuego;
import Vistas.ControladorVistas;
import  Logica.Entidades.*;

import Vistas.Observer;

public class Juego {
    private ControladorVistas controladorVistas;
    private ModoDeJuego modo;
    private Nivel nivelActual;
    
    private GeneradorDeNiveles generadorDeNiveles;

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }

    public void iniciar(ModoDeJuego m) {
        modo = m;
        generadorDeNiveles = new GeneradorDeNiveles();
        nivelActual = generadorDeNiveles.generarNivel(m, 1);
		registrarObservers();

	}

	   

    protected void registrarObservers() {
		registrarObserverJugador(nivelActual.getPersonaje());
		registrarObserverFondo(nivelActual.getFondo());

		registrarObserverEntidades(nivelActual.getEnemigos());
		registrarObserverEntidades(nivelActual.getPlataformas());
		registrarObserverEntidades(nivelActual.getPowerUps());

		//registrar fondo
		
	}
	
	protected void registrarObserverJugador(Personaje personaje) {
		Observer observerJugador = controladorVistas.registrarEntidadJugador(personaje);
		personaje.registrarObserver(observerJugador);
	}
	
	protected void registrarObserverFondo(Fondo fondo) {
		Observer observer = controladorVistas.registrarFondo(fondo);
		fondo.registrarObserver(observer);
	}
	
	protected void registrarObserverEntidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer  observerEntidad= controladorVistas.registrarEntidadLogica(entidad);
			entidad.registrarObserver(observerEntidad);
		}
	}
    
    public Personaje obtenerPersonaje() {
        return nivelActual.getPersonaje();

    }
    
}
