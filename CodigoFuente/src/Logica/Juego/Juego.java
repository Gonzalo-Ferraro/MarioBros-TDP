package Logica.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JOptionPane;

import Datos.EntidadSonora;
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
    private EntidadSonora entidadSonora;
    private Personaje personaje;

    private ControladorEntidades controladorEntidades;
    private ControladorJugador controladorJugador;

    private GeneradorDeNiveles generadorDeNiveles;

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }

    public void setEntidadSonora(EntidadSonora e) {
        entidadSonora = e;
    }
    
    public EntidadSonora getEntidadSonora(){
        return entidadSonora;
    }

    public ModoDeJuego getModo() {
        return modo;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public void iniciar(ModoDeJuego m) {
        modo = m;
        generadorDeNiveles = new GeneradorDeNiveles();
        
        
        nivelActual = generadorDeNiveles.generarNivel(modo, 1);
        personaje = nivelActual.getPersonaje();

        inicializarNivel();
    }

    private void inicializarNivel() {
        registrarObservers();

        obtenerPersonaje().setJuego(this);
        PantallaStats pantallaStats = new PantallaStats(controladorVistas, obtenerPersonaje());

        controladorVistas.setPantallaStats(pantallaStats);
        controladorVistas.mostrarPantallaStats();


        Timer temporizadorPantallaJuego = new Timer(ConstantesVistas.TIEMPO_STATS * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarPantallaJuego();
            }
        });
        temporizadorPantallaJuego.setRepeats(false); // Solo ejecutarlo una vez
        temporizadorPantallaJuego.start();

        crearControladores();

        Timer temporizadorLoop = new Timer(ConstantesVistas.TIEMPO_STATS * 1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entidadSonora.iniciarLoopMario();
            }
        });
        temporizadorLoop.setRepeats(false); // Solo ejecutarlo una vez
        temporizadorLoop.start();
    }

    private void crearControladores() {
        controladorJugador = new ControladorJugador();
        controladorJugador.setPersonaje(personaje);
        controladorJugador.empezarJuego();

        controladorEntidades = new ControladorEntidades();
        controladorEntidades.setNivel(nivelActual);
        controladorEntidades.iniciar();
    }

    protected void registrarObservers() {
        registrarObserverJugador(personaje);
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
        return personaje;
    }

    public void setDerecha(boolean d){
        personaje.setDerecha(d);
    }    
    public void setIzquierda(boolean i){
        personaje.setIzquierda(i);
    }
    public void salto() {
        personaje.saltar();
    }

    public void perdiste() {
        controladorEntidades.detener();
        controladorJugador.detener();

        controladorVistas.dispose();

        JOptionPane.showMessageDialog(null, "Perdiste");
    }

    public void reiniciarNivel() {
        try {
            Thread.sleep(ConstantesVistas.TIEMPO_ENTRE_NIVELES * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Reiniciando nivel");

        controladorEntidades.detener();
        controladorJugador.detener();

        controladorVistas.nuevaPantallaJuego();

        nivelActual = generadorDeNiveles.generarNivel(modo, 1);
        personaje.reiniciar();

        inicializarNivel();
    }    
}
