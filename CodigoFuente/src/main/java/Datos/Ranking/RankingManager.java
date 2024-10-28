package Datos.Ranking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class RankingManager {
    private static final String RUTA_RANKING = "src/main/java/Datos/Ranking/ranking.json";
    private Ranking ranking;
    private Gson gson;

    public RankingManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        cargarRanking();
    }

    @SuppressWarnings("resource")
    public void cargarRanking() {
        try (InputStream inputStream = Paths.get(RUTA_RANKING).toUri().toURL().openStream()) {
            String json = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            ranking = gson.fromJson(json, Ranking.class);
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo de ranking: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mostrarRanking() {
        if (ranking != null) {
            List<Jugador> jugadores = ranking.getJugadores();
            for (Jugador jugador : jugadores) {
                System.out.println("Nombre: " + jugador.getNombre() + ", Puntaje: " + jugador.getPuntaje());
            }
        } else {
            System.out.println("No se pudo cargar el ranking.");
        }
    }

    public void guardarRanking() {
        if (ranking != null) {
            try (FileWriter writer = new FileWriter(RUTA_RANKING)) {
                gson.toJson(ranking, writer);
                System.out.println("Ranking guardado exitosamente.");
            } catch (Exception e) {
                System.out.println("Error al guardar el archivo de ranking: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay ranking cargado para guardar.");
        }
    }

    public void agregarJugador(String nombre, int puntaje) {
        if (ranking != null) {
            ranking.agregarJugador(nombre, puntaje);
        } else {
            System.out.println("No se pudo agregar el jugador al ranking.");
        }
    }

    public Ranking getRanking() {
        return ranking;
    }
}