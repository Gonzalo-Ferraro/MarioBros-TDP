package Logica.Juego;

import java.util.LinkedList;
import java.util.List;

import Logica.Entidades.BolaDeFuego;
import Logica.Entidades.Enemigo;
import Logica.Entidades.Fondo;
import Logica.Entidades.Plataforma;
import Logica.Entidades.PowerUp;
import Logica.Entidades.Personaje;

public class Nivel {
    private List<Enemigo> enemigos;
    private List<PowerUp> powerUps;
    private List<Plataforma> plataformas;
    private List<BolaDeFuego> bolasDeFuego;
    private Fondo fondo;
    private String rutaNivel;
    private Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Nivel(int n) {
        rutaNivel = "/Datos/niveles/nivel-" + n + ".txt";

        enemigos = new LinkedList<>();
        powerUps = new LinkedList<>();
        plataformas = new LinkedList<>();
        bolasDeFuego = new LinkedList<>();
    }

    public String getRutaNivel() {
        return rutaNivel;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public List<BolaDeFuego> getBolasDeFuego() {
        return bolasDeFuego;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public void setFondo(Fondo f) {
        fondo = f;
    }
}
