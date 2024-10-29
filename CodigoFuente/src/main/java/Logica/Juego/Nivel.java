package Logica.Juego;

import Logica.Entidades.BolaDeFuego;
import Logica.Entidades.Enemigo;
import Logica.Entidades.Fondo;
import Logica.Entidades.Personaje;
import Logica.Entidades.PiranhaPlant;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import java.util.LinkedList;
import java.util.List;

public class Nivel {
    private List<Enemigo> enemigos;
    private List<PiranhaPlant> piranhaPlants;
    private List<PowerUp> powerUps;
    private List<Plataforma> plataformas;
    private List<BolaDeFuego> bolasDeFuego;
    private Fondo fondo;
    private String rutaNivel;
    private Personaje personaje;

    private int numeroNivel;
    private int cantidadBolasDeFuego;
    
    public Nivel(int n) {
        rutaNivel = "/Datos/niveles/nivel-" + n + ".txt";
        
        enemigos = new LinkedList<>();
        piranhaPlants = new LinkedList<>();
        powerUps = new LinkedList<>();
        plataformas = new LinkedList<>();
        bolasDeFuego = new LinkedList<>();

        cantidadBolasDeFuego = 0;
        
        numeroNivel = n;
    }
    
    public Personaje getPersonaje() {
        return personaje;
    }
    
    public String getRutaNivel() {
        return rutaNivel;
    }
    
    public Fondo getFondo() {
        return fondo;
    }

    public Iterable<Plataforma> getPlataformas() {
        return plataformas;
    }

    public Iterable<BolaDeFuego> getBolasDeFuego() {
        return bolasDeFuego;
    }
    
    public Iterable<Enemigo> getEnemigos() {
        return enemigos;
    }

    public Iterable<PiranhaPlant> getPiranhaPlants() {
        return piranhaPlants;
    }

    public int obtenerCantidadBolasDeFuego() {
        return cantidadBolasDeFuego;
    }
    
    public int getNumeroNivel() {
        return numeroNivel;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
    
    public void setFondo(Fondo f) {
        fondo = f;
    }
    
    public void decrementarBolasDeFuego() {
        cantidadBolasDeFuego--;
    }

    public void ingresarEntidad(Enemigo e) {
        enemigos.add(e);
    }

    public void ingresarEntidad(PiranhaPlant p) {
        piranhaPlants.add(p);
    }
    
    public void ingresarEntidad(PowerUp p) {
        powerUps.add(p);
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void ingresarEntidad(Plataforma p) {
        plataformas.add(p);
    }

    public void ingresarEntidad(BolaDeFuego b) {
        bolasDeFuego.add(b);
        cantidadBolasDeFuego++;
    }

    public synchronized void removerEntidad(Enemigo e) {
        enemigos.remove(e);
    }

    public synchronized void removerEntidad(PowerUp p) {
        powerUps.remove(p);
    }
    
    public synchronized void removerEntidad(Plataforma p) {
        plataformas.remove(p);
    }
}
