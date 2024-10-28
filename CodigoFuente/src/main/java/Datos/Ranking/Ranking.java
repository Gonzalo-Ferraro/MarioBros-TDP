package Datos.Ranking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    private List<Jugador> jugadores;

    public Ranking() {
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        ordenarYLimitarJugadores();
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "jugadores=" + jugadores +
                '}';
    }

    public void agregarJugador(String nombre, int puntaje) {
        Jugador jugador = new Jugador(nombre, puntaje);
        jugadores.add(jugador);
        ordenarYLimitarJugadores();
    }

    private void ordenarYLimitarJugadores() {
        jugadores.sort(Comparator.comparingInt(Jugador::getPuntaje).reversed()); // Ordena de mayor a menor puntaje

        // Si hay más de 5 jugadores, elimina los de menor puntaje para mantener solo los mejores 5
        if (jugadores.size() > 5) {
            jugadores = jugadores.subList(0, 5);
        }
    }
}