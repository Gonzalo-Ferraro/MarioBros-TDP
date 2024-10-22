package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import Logica.Entidades.*;
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
        switch (caracter) {

            //PLATAFORMAS--------------------------	

            case 'P':
                Plataforma plataformaGenerada = modo.crearPiso(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(plataformaGenerada);
                break;
            
            case '?':
                BloqueDePregunta bloqueGenerado = modo.crearBloquePregunta(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(bloqueGenerado);
                break;

            case 'S':
                Plataforma ladrilloGenerado = modo.crearLadrillo(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(ladrilloGenerado);
                break;

            case 'T':
                Plataforma tuberiaGenerada = modo.crearTuberia(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(tuberiaGenerada);
                break;

            case 't':
                Plataforma partetuberiaGenerada = modo.crearPartetuberia(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(partetuberiaGenerada);
                break;
            //POWERUPS--------------------------

            case 'e':
                Estrella estrellaGenerada = modo.crearEstrella(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE
                );
                nivel.ingresarEntidad(estrellaGenerada);
                break;

            case 'c':
            SuperChampignon superChampignonGenerado = modo.crearSuperChampignon(
                indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                indiceLinea * ConstantesVistas.TAMANO_BLOQUE
            );
            nivel.ingresarEntidad(superChampignonGenerado);
            break;

            case 'f':
                FlorDeFuego florDeFuegoGenerada = modo.crearFlorDeFuego(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE
                );
                nivel.ingresarEntidad(florDeFuegoGenerada);
                break;
            
            case 'v':
                ChampignonVerde champignonVerdeGenerado = modo.crearChampignonVerde(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE
                );
                nivel.ingresarEntidad(champignonVerdeGenerado);
                break;

            case '$':
                Moneda monedaGenerada = modo.crearMoneda(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(monedaGenerada);
                break;

            //ENEMIGOS--------------------------

            case 'g':
                Goomba goombaGenerado = modo.crearGoomba(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(goombaGenerado);
                break;

            case 'p':
                PiranhaPlant piranhaPlantGenerada = modo.crearPiranhaPlant(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(piranhaPlantGenerada);
                break;

            case 'l':
                Lakitu lakituGenerado = modo.crearLakitu(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(lakituGenerado);
                break;

            case 'k':
                KoopaTroopa koopaGenerado = modo.crearKoopaTroopa(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20 * 3
                );
                nivel.ingresarEntidad(koopaGenerado);
                break;
            
            case 'b':
               BuzzyBeetle buzzyBeetleGenerado=modo.crearBuzzyBeetle(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
               );
               nivel.ingresarEntidad(buzzyBeetleGenerado); 
               break;
            
            case 's':
                Spiny spinyGenerado = modo.crearSpiny(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
                );
                nivel.ingresarEntidad(spinyGenerado);
                break;

            //PERSONAJE--------------------------

            case 'm':
                Personaje jugador = modo.crearPersonaje(
                    indiceCaracter * ConstantesVistas.TAMANO_BLOQUE,
                    indiceLinea * ConstantesVistas.TAMANO_BLOQUE - 20
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