package Vistas;

import javax.swing.JFrame;

import Logica.Fabricas.ModoDeJuego;
import Logica.Juego.Juego;

public class ControladorVistas extends JFrame {
    private Juego juego;
    private PantallaJuego pantallaJuego;
    private PantallaMenu pantallaMenu;

    public ControladorVistas(Juego juego) {
        super("Super Mario Bros - Comision 06 TDP");

		this.juego = juego;

		pantallaMenu = new PantallaMenu(this);
		pantallaJuego = new PantallaJuego();

		configurar_ventana();
		registrar_oyente_ventana();
	}
	
	protected void configurar_ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void registrar_oyente_ventana() {
		// To DO
	}

    public void mostrarMenu() {
        setContentPane(pantallaMenu);
        revalidate();
        repaint();
    }

	public void accionarInicioJuego(ModoDeJuego modo) {
		juego.iniciar(modo);
	}
}
