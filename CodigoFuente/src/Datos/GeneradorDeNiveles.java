package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import Logica.Entidades.BloqueDePregunta;
import Logica.Entidades.Fondo;
import Logica.Entidades.Goomba;
import Logica.Entidades.KoopaTroopa;
import Logica.Entidades.Moneda;
import Logica.Entidades.Personaje;
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
        agregarFondo();

        return nivel;
    }

    private void parsearNivel() {
        String rutaArchivo = nivel.getRutaNivel();

        try (BufferedReader lector = new BufferedReader(new FileReader(getClass().getResource(rutaArchivo).getPath()))) {
            LinkedList<String> lineas = new LinkedList<>();
            String linea;

            while ((linea = lector.readLine()) != null) {
                lineas.addFirst(linea);
            }

            for (int indiceLinea = 0; indiceLinea < lineas.size(); indiceLinea++) {
                String lineaActual = lineas.get(indiceLinea);
                for (int i = 0; i < lineaActual.length(); i++) {
                    generarEntidad(indiceLinea, i, lineaActual.charAt(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generarEntidad(int indiceLinea, int indiceCaracter, Character caracter) {
        switch (caracter) {
            case 'P':
                Plataforma plataformaGenerada = modo.crearPiso(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getPlataformas().add(plataformaGenerada);
                break;
            
            case '?':
                BloqueDePregunta bloqueGenerado = modo.crearBloquePregunta(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getPlataformas().add(bloqueGenerado);
                break;

            case 'S':
                Plataforma ladrilloGenerado = modo.crearLadrillo(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getPlataformas().add(ladrilloGenerado);
                break;

            case 'T':
                Plataforma tuberiaGenerada = modo.crearTuberia(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getPlataformas().add(tuberiaGenerada);
                break;

            case '$':
                Moneda monedaGenerada = modo.crearMoneda(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getPowerUps().add(monedaGenerada);
                break;

            case 'g':
                Goomba goombaGenerado = modo.crearGoomba(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getEnemigos().add(goombaGenerado);
                break;

            case 'k':
                KoopaTroopa koopaGenerado = modo.crearKoopaTroopa(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE + ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.getEnemigos().add(koopaGenerado);
                break;

            case 'm':
                Personaje jugador = modo.crearPersonaje(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE +  ConstantesVistas.TAMANO_BLOQUE + 20
                );
                nivel.setPersonaje(jugador);
                break;
            default:
                break;
        }
    }

    private void agregarFondo() {
        Fondo fondo = modo.crearFondo(0, 0);
        nivel.setFondo(fondo);
    }   
}