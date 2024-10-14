package Logica.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

import Datos.GeneradorDeNiveles;
import Logica.Fabricas.ModoDeJuego;
import Vistas.ConstantesVistas;
import Vistas.ControladorVistas;
import  Logica.Entidades.*;

import Vistas.Observer;
import Vistas.PantallaStats;

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

        PantallaStats pantallaStats = new PantallaStats(controladorVistas, obtenerPersonaje());

        controladorVistas.setPantallaStats(pantallaStats);
        controladorVistas.mostrarPantallaStats();

        Timer timer = new Timer(ConstantesVistas.TIEMPO_STATS * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaJuego();
            }
        });
        timer.setRepeats(false); // Solo ejecutarlo una vez
        timer.start();

        crearControladores();
    }

    private void crearControladores() {
        ControladorJugador controladorJugador = new ControladorJugador();
        controladorJugador.setPersonaje(nivelActual.getPersonaje());
        controladorJugador.start();
    }

    protected void registrarObservers() {
        registrarObserverJugador(nivelActual.getPersonaje());
        registrarObserverFondo(nivelActual.getFondo());

        registrarObserverEntidades(nivelActual.getEnemigos());
        registrarObserverEntidades(nivelActual.getPlataformas());
        registrarObserverEntidades(nivelActual.getPowerUps());        
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
            Observer  observerEntidad = controladorVistas.registrarEntidadLogica(entidad);
            entidad.registrarObserver(observerEntidad);
        }
    }
    
    public Personaje obtenerPersonaje() {
        return nivelActual.getPersonaje();
    }

    public void iniciarMovimientoDerecha() {
        nivelActual.getPersonaje().setDerecha(true);
    }

    public void detenerMovimientoDerecha() {
        nivelActual.getPersonaje().setDerecha(false);
    }

    public void iniciarMovimientoIzquierda() {
        nivelActual.getPersonaje().setIzquierda(true);
    }

    public void detenerMovimientoIzquierda() {
        nivelActual.getPersonaje().setIzquierda(false);
    }
}
