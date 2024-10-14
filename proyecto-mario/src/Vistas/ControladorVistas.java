package Vistas;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Fabricas.ModoDeJuego;
import Logica.Juego.Juego;
import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Personaje;
import Logica.Entidades.Fondo;


public class ControladorVistas extends JFrame {
    private Juego juego;
	
    private PantallaJuego pantallaJuego;
    private PantallaMenu pantallaMenu;
	private PantallaStats pantallaStats;

    public ControladorVistas(Juego juego) {
        super("Super Mario Bros - Comision 06 TDP");

		this.juego = juego;

		pantallaMenu = new PantallaMenu(this);
		pantallaJuego = new PantallaJuego();
		pantallaStats = new PantallaStats(this, new Personaje(0, 0, null));

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
       actualizarPanel();
    }

	public void accionarInicioJuego(ModoDeJuego modo) {
		mostrarStats();
		pantallaStats = new PantallaStats(this, juego.obtenerPersonaje());

		juego.iniciar(modo);
	}

	public void mostrarStats() {
		this.setContentPane(pantallaStats);
		actualizarPanel();
		
		// Crear un Timer para cambiar de panel después de 5 seg
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				setContentPane(pantallaJuego);
				actualizarPanel();
            }
        }); 
        timer.setRepeats(false); // Solo ejecutarlo una vez
        timer.start();
    }

	private void actualizarPanel(){
		revalidate();
        repaint();
	}

	public Observer registrarEntidadLogica(EntidadLogica entidad_logica) {
        Observer observerEntidad = pantallaJuego.incorporarEntidadLogica(entidad_logica);
        actualizarPanel();
        return observerEntidad;
    }

    public Observer registrarEntidadJugador(EntidadJugador entidad_jugador) {
        Observer observerJugador = pantallaJuego.incorporarEntidadJugador(entidad_jugador);
        actualizarPanel();
        return observerJugador;
    }

    public Observer registrarFondo(Fondo fondo) {
        Observer observerFondo = pantallaJuego.incorporarFondo(fondo);
        actualizarPanel();
        return observerFondo;
    }
}