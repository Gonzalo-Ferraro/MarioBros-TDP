package Logica.Juego;

import Datos.EntidadSonora;
import Datos.GeneradorDeNiveles;
import Datos.Ranking.Ranking;
import Datos.Ranking.RankingManager;
import Logica.Entidades.*;
import Logica.Fabricas.ModoDeJuego;
import Logica.Launcher.Launcher;
import Vistas.ConstantesVistas;
import Vistas.ControladorVistas;
import Vistas.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.JOptionPane;
import javax.swing.Timer;

public class Juego {
    private ControladorVistas controladorVistas;
    private ModoDeJuego modo;
    private Nivel nivelActual;
    private EntidadSonora entidadSonora;
    private Personaje personaje;
    private RankingManager rankingManager;

    private ControladorEntidades controladorEntidades;
    private ControladorJugador controladorJugador;

    private GeneradorDeNiveles generadorDeNiveles;
    
    private int tiempo;
    
    public Juego() {
        rankingManager = new RankingManager();
    }
    //Setters-------------------------------------------------------------------
    
    public Ranking obtenerRanking() {
        return rankingManager.getRanking();
    }

    public void setDerecha(boolean d){
        personaje.setDerecha(d);
    }    

    public void setIzquierda(boolean i){
        personaje.setIzquierda(i);
    }

    public void setControladorVistas(ControladorVistas c) {
        controladorVistas = c;
    }
    
    public void setEntidadSonora(EntidadSonora e) {
        entidadSonora = e;
    }

    //Getters-------------------------------------------------------------------
    public EntidadSonora getEntidadSonora(){
        return entidadSonora;
    }

    public ModoDeJuego getModo() {
        return modo;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public int getPosScroll() {
        return controladorVistas.getPosScroll();
    }

    public Personaje obtenerPersonaje() {
        return personaje;
    }

    public Nivel obtenerNivel() {
        return nivelActual;
    }

    public int getTiempo() {
        return tiempo / 60;
    }
    
    //COMPORTAMIENTO------------------------------------------------------------

    public void decrementarTiempo() {
        tiempo--;
        controladorVistas.actualizarTimerJuego();

        if (tiempo == 0) {
            finTimer();
        }
    }
    
    public void iniciar(ModoDeJuego m) {
        modo = m;
        generadorDeNiveles = new GeneradorDeNiveles();
        
        
        nivelActual = generadorDeNiveles.generarNivel(modo, 1);
        personaje = nivelActual.getPersonaje();

        inicializarNivel();
    }

    private void inicializarNivel() {
        obtenerPersonaje().setJuego(this);

        tiempo = (ConstantesVistas.TIEMPO_NIVEL + ConstantesVistas.TIEMPO_STATS + 1) * 60;

        controladorVistas.crearPantallaJuego(obtenerPersonaje());
        controladorVistas.crearPantallaStats(obtenerPersonaje());

        registrarObservers();

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
        registrarObserverEntidades(nivelActual.getPiranhaPlants());      
    }
    
    protected void registrarObserverJugador(Personaje personaje) {
        Observer observerJugador = controladorVistas.registrarEntidadJugador(personaje);
        personaje.registrarObserver(observerJugador);
    }
    
    protected void registrarObserverFondo(Fondo fondo) {
        Observer observer = controladorVistas.registrarFondo(fondo);
        fondo.registrarObserver(observer);
    }
    
    protected void registrarObserverEntidades(Iterable<? extends Entidad> entidades) {
        for(Entidad entidad : entidades) {
            Observer  observerEntidad = controladorVistas.registrarEntidadLogica(entidad);
            entidad.registrarObserver(observerEntidad);
        }
    }

    private String obtenerNombreJugador() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        if (nombre == null || nombre.isEmpty()) {
            nombre = "Anónimo";
        }
        return nombre;
    }
    
    public void salto() {
        personaje.saltar();
    }

    public void perdiste() {
        controladorJugador.detener();
        controladorEntidades.detener();
        entidadSonora.detenerLoopMario();
        controladorVistas.crearPantallaPerdisteOGanaste(personaje);
        controladorVistas.mostrarPantallaPerdisteOGanaste();        

        actualizarRanking();

        controladorVistas.dispose();
        Launcher.main(null);
    }

    public void reiniciarNivel() {
        controladorEntidades.detener();
        
        try {
            Thread.sleep(ConstantesVistas.TIEMPO_ENTRE_NIVELES * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controladorJugador.detener();

        controladorVistas.crearPantallaJuego(obtenerPersonaje());
        controladorVistas.getPantallaStats().actualizarValores(nivelActual.getNumeroNivel());

        nivelActual = generadorDeNiveles.generarNivel(modo, nivelActual.getNumeroNivel());

        personaje.reiniciar();
        
        inicializarNivel();
    }    

    public void actualizarEtiquetaStatsPantallaJuego() {
        controladorVistas.actualizarEtiquetaStatsPantallaJuego();
    }

    public void pasarNivel() {
        if (nivelActual.getNumeroNivel() + 1 > 3) {
            ganaste();            
        } else {
            personaje.pasarNivelPersonaje();
            
            controladorEntidades.detener();
            
            try {
                Thread.sleep(ConstantesVistas.TIEMPO_ENTRE_NIVELES * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            controladorJugador.detener();
            
            controladorVistas.crearPantallaJuego(obtenerPersonaje());
            controladorVistas.getPantallaStats().actualizarValores(nivelActual.getNumeroNivel() + 1);

            nivelActual = generadorDeNiveles.generarNivel(modo,nivelActual.getNumeroNivel() + 1);
            nivelActual.setPersonaje(personaje);

            inicializarNivel();
        }
    }

    private void ganaste(){
        controladorEntidades.detener();
        controladorJugador.detener();
        entidadSonora.detenerLoopMario();
        controladorVistas.crearPantallaPerdisteOGanaste(personaje);
        controladorVistas.mostrarPantallaPerdisteOGanaste();

        actualizarRanking();

        controladorVistas.dispose();
        Launcher.main(null);
    }

    private void actualizarRanking() {
        String nombre = controladorVistas.getPantallaPerdisteOGanaste().pedirNombre();
        rankingManager.agregarJugador(nombre, personaje.getPuntaje());
        rankingManager.guardarRanking();
    }

    public void finTimer() {
        personaje.perderVida();
    }

    public void lanzarBolaDeFuego() {
        personaje.lanzarBolaDeFuego();
    }

    public synchronized void agregarBolaDeFuego(int x, int y, int velocidadX) {
        int direccion = (velocidadX >= 0) ? 1 : -1;

        BolaDeFuego bola = modo.crearBolaDeFuego(x, y, direccion);

        Observer observerBola = controladorVistas.registrarEntidadLogica(bola);
        bola.registrarObserver(observerBola);
        
        nivelActual.ingresarEntidad(bola);
    }
}
