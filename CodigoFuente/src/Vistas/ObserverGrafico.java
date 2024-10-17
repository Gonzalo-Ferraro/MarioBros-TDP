package Vistas;

import Logica.Entidades.EntidadLogica;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class ObserverGrafico extends JLabel implements Observer {
	private EntidadLogica entidad_observada;
	
	protected ObserverGrafico(EntidadLogica entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizarImagen() {
		String ruta_imagen = entidad_observada.getSprite().getRutaImagen();
		ImageIcon icono = new ImageIcon(getClass().getResource(ruta_imagen));
		setIcon(icono);
	}
	
	public void actualizarPosicionTamano() {
		int x, y;

        x = AdaptadorPosicionPixel.transformar_x(entidad_observada.getX());
    	y = AdaptadorPosicionPixel.transformar_y(entidad_observada.getY());

		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();

		setBounds(x, y, ancho, alto);
	}

}
