package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Logica.Entidades.BloqueSolido;
import Logica.Entidades.Plataforma;
import Logica.Fabricas.ModoDeJuego;
import Logica.Juego.Nivel;
import Vistas.ConstantesVistas;

public class GeneradorDeNiveles {
    private ModoDeJuego modo;
    private Nivel nivel;


    public Nivel generarNivel(ModoDeJuego m, int n) {
        nivel = new Nivel(n);
        modo = m;

        parsearNivel();

        return nivel;
    }

    private void parsearNivel() {
        String rutaArchivo = nivel.getRutaNivel();

        try (BufferedReader lector = new BufferedReader(new FileReader(getClass().getResource(rutaArchivo).getPath()))) {
            String linea;
            int indiceLinea = 0;

            while ((linea = lector.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    generarEntidad(indiceLinea, i, linea.charAt(i));
                }
                indiceLinea++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generarEntidad(int indiceLinea, int indiceCaracter, Character caracter) {
        Plataforma plataformaGenerada;
        switch (caracter) {
            case 'p':
                plataformaGenerada = modo.crearPiso(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE
                );
                nivel.getPlataformas().add(plataformaGenerada);
                break;
        
            default:
                break;
        }
    }
}