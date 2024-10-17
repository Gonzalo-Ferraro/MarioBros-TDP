package Vistas;

import java.awt.Rectangle;

public interface Observer {
	public void actualizarPosicionTamano();
	public void actualizarImagen();
	public Rectangle getBounds();
}
