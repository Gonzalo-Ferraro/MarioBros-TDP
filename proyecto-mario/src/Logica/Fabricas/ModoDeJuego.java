package Logica.Fabricas;
import Logica.Entidades.*;

public abstract class ModoDeJuego {
    protected String ruta;

    protected ModoDeJuego(String ruta){
        this.ruta = ruta;
    }

    public SuperChampignon crearSuperChampignon(int x, int y){
        Sprite spriteSuperChampignon = new Sprite(ruta + "/superChampignon.png");
        SuperChampignon toReturn = new SuperChampignon(x, y, spriteSuperChampignon);
        return toReturn;
    }

    public Personaje crearPersonaje(int x, int y) {
        Sprite spriteMario = new Sprite(ruta + "/mario-derecha.png");
        Personaje personaje = new Personaje(x, y, spriteMario);
        return personaje;
    }

    public BloqueSolido crearPiso(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/piso.png");
        BloqueSolido bloque = new BloqueSolido(x, y, sprite);
        return bloque;
    }

    public BloqueDePregunta crearBloquePregunta(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/bloque-pregunta.gif");
        BloqueDePregunta bloque = new BloqueDePregunta(x, y, sprite);
        return bloque;
    }

    public BloqueSolido crearLadrillo(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/ladrillo.png");
        BloqueSolido bloque = new BloqueSolido(x, y, sprite);
        return bloque;
    }
}
