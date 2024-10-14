package Vistas;

import Logica.Entidades.EntidadLogica;

public class ObserverEntidades extends ObserverGrafico {	
	public ObserverEntidades(EntidadLogica entidad_observada) {
		super(entidad_observada);
		actualizarImagen();
		actualizarPosicionTamano();
	}
}
