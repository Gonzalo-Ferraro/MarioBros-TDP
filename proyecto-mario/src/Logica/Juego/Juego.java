package Logica.Juego;

import java.util.List;

import Datos.GeneradorDeNiveles;
import Logica.Fabricas.ModoDeJuego;
import Vistas.ControladorVistas;
import  Logica.Entidades.*;
public class Juego {
    private ControladorVistas controladorVistas;
    private ModoDeJuego modo;
    private Nivel nivelActual;
    protected Personaje personaje;
    private GeneradorDeNiveles generadorDeNiveles;

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }

    public void iniciar(ModoDeJuego m) {
        modo = m;
        generadorDeNiveles = new GeneradorDeNiveles();
        nivelActual = generadorDeNiveles.generarNivel(m, 1);
    }

    protected void registrar_observers() {
		registrar_observer_jugador(nivelActual.get_vehiculo_jugador());
		registrar_observer_silueta(nivelActual.get_silueta());
		registrar_observers_para_entidades(nivelActual.get_vehiculos_carrera());
		registrar_observers_para_entidades(nivelActual.get_vehiculos_transito());
		registrar_observers_para_entidades(nivelActual.get_obstaculos());
		registrar_observers_para_entidades(nivelActual.get_power_ups());
	}
	
	protected void registrar_observer_jugador(Jugador vehiculo_jugador) {
		Observer observer_jugador = controlador_vistas.registrar_entidad(vehiculo_jugador);
		vehiculo_jugador.registrar_observer(observer_jugador);
	}
	
	protected void registrar_observer_silueta(Silueta silueta_ruta) {
		Observer observer = controlador_vistas.registrar_silueta(silueta_ruta);
		silueta_ruta.registrar_observer(observer);
	}
	
	protected void registrar_observers_para_entidades(List<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			Observer observer = controlador_vistas.registrar_entidad(entidad);
			entidad.registrar_observer(observer);
		}
	}
    
    public Personaje obtenerPersonaje() {
        return personaje;
    }
    
}
