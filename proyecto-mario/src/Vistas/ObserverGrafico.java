package Vistas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Entidades.EntidadLogica;

// Abstraccion de los dos tipos de observadores disponibles (grafico y jugador)
// Encapsula todo el comportamiento en comun.

public abstract class ObserverGrafico extends JLabel implements Observer {
	
	private static final long serialVersionUID = 1L;
	private EntidadLogica entidad_observada;
	
	protected ObserverGrafico(EntidadLogica entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		actualizar_imagen();
		actualizar_posicion_tamano();
	}
	
	protected void actualizar_imagen() {
		String ruta_imagen = entidad_observada.getSprite().get_ruta_imagen();
		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(ruta_imagen));
		setIcon(icono);
	}
	
	protected void actualizar_posicion_tamano() {
		int x = AdaptadorPosicionPixel.transformar_x(entidad_observada.getX());
		int y = AdaptadorPosicionPixel.transformar_y(entidad_observada.getY());
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		setBounds(x, y, ancho, alto);
	}
}
