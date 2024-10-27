package Vistas;

import Logica.Entidades.EntidadJugador;
import Logica.Entidades.EntidadLogica;
import Logica.Entidades.Fondo;
import Logica.Fabricas.ModoDeJuego;
import Logica.Juego.Juego;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class ControladorVistas extends JFrame implements KeyListener {
    private Juego juego;
	
    private PantallaJuego pantallaJuego;
    private PantallaMenu pantallaMenu;
	private PantallaStats pantallaStats;
    
    public ControladorVistas(Juego juego) {
        super("Super Mario Bros - Comision 06 TDP");
        
		this.juego = juego;
        
		pantallaMenu = new PantallaMenu(this);
        
		configurar_ventana();
		registrarOyentes();
	}
	
    public int getPosScroll() {
        return pantallaJuego.getPosScroll();
    }
    
	protected void configurar_ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(ConstantesVistas.VENTANA_ANCHO, ConstantesVistas.VENTANA_ALTO);
		setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/Datos/sprites/modo-original/mario-quieto-derecha.png"));
        setIconImage(icono.getImage());
		setVisible(true);
	}

    public void crearPantallaJuego(EntidadJugador personaje) {
        pantallaJuego = new PantallaJuego(personaje);
    }

    public void crearPantallaStats(EntidadJugador personaje) {
        pantallaStats = new PantallaStats(this, personaje);
    }

    
    public void mostrarMenu() {
    	setContentPane(pantallaMenu);
        actualizarPanel();
    }

	public void accionarInicioJuego(ModoDeJuego modo) {
		juego.iniciar(modo);
	}

	public void mostrarPantallaStats() {
	    this.setContentPane(pantallaStats);
	    actualizarPanel();
	}

	private void actualizarPanel(){
		revalidate();
        repaint();
	}

    public void actualizarTimerJuego() {
        pantallaJuego.actualizarLabelTiempo();
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

    
	public void setPantallaStats(PantallaStats pantallaStats) {
		this.pantallaStats = pantallaStats;
	}

	public void mostrarPantallaJuego() {
		setContentPane(pantallaJuego);
		actualizarPanel();
	}

    public void mostrarRanking() {
        new VentanaRanking(juego.obtenerRanking());
    }

    //Oyentes teclas----------------------------------------------
	protected void registrarOyentes() {
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                juego.setIzquierda(true);
                break;
            case KeyEvent.VK_W:
                juego.salto();
                break;
            case KeyEvent.VK_D:
				juego.setDerecha(true);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Tecla Espacio presionada");
                 
                 break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A -> juego.setIzquierda(false);
            case KeyEvent.VK_W -> {
            }
            case KeyEvent.VK_D -> juego.setDerecha(false);
            case KeyEvent.VK_SPACE -> System.out.println("Tecla Espacio soltada");
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {}

    public void actualizarEtiquetaStatsPantallaJuego() {
        pantallaJuego.actualizarEtiquetaStatsPantallaJuego();
    }

    public PantallaStats getPantallaStats(){
        return pantallaStats;
    }
}