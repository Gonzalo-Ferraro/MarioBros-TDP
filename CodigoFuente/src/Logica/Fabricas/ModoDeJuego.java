package Logica.Fabricas;
import Logica.Entidades.*;

public abstract class ModoDeJuego {
    protected String ruta;

    protected ModoDeJuego(String ruta){
        this.ruta = ruta;
    }

    public SuperChampignon crearSuperChampignon(int x, int y){
        Sprite spriteSuperChampignon = new Sprite(ruta + "/super-champignon.png");
        SuperChampignon toReturn = new SuperChampignon(x, y, spriteSuperChampignon);
        return toReturn;
    }

    public Personaje crearPersonaje(int x, int y) {
        Sprite spriteMario = new Sprite(ruta + "/mario-quieto-derecha.png");
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

    public Tuberia crearTuberia(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/tuberia.png");
        Tuberia tuberia = new Tuberia(x, y, sprite, crearPiranhaPlant(x, y));
        return tuberia;
    }

    public Moneda crearMoneda(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/moneda.gif");
        Moneda moneda = new Moneda(x, y, sprite);
        return moneda;
    }

    public PiranhaPlant crearPiranhaPlant(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/piranha-plant.gif");
        PiranhaPlant piranha = new PiranhaPlant(x, y, sprite);
        return piranha;
    }

    public Goomba crearGoomba(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/goomba.gif");
        Goomba goomba = new Goomba(x, y, sprite);
        return goomba;
    }

    public KoopaTroopa crearKoopaTroopa(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/koopa-troopa-izquierda.gif");
        KoopaTroopa koopa = new KoopaTroopa(x, y, sprite);
        return koopa;
    }

    public Fondo crearFondo(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/fondo.png");
        Fondo fondo = new Fondo(x, y, sprite);
        return fondo;
    }

    public Sprite getMarioMoviendoDerecha() {
        return new Sprite(ruta + "/mario-movimiento-derecha.gif");
    }

    public Sprite getMarioMoviendoIzquierda() {
        return new Sprite(ruta + "/mario-movimiento-izquierda.gif");
    }

    public Sprite getMarioQuietoDerecha() {
        return new Sprite(ruta + "/mario-quieto-derecha.png");
    }

    public Sprite getMarioQuietoIzquierda() {
        return new Sprite(ruta + "/mario-quieto-izquierda.png");
    }
}
