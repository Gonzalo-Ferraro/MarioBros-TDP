package Vistas;

public class AdaptadorPosicionPixel {
	
	public static int transformar_x(int x) {
		return x;
	}
	
	// Las coordenadas gráficas se miden de arriba hacia abajo
	public static int transformar_y(int y) {
		return ConstantesVistas.PANEL_ALTO - y;
	}
}
