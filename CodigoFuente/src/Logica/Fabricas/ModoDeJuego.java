package Logica.Fabricas;
import Logica.Entidades.*;
import Vistas.ConstantesVistas;

import java.util.Random;

public abstract class ModoDeJuego {
    protected String ruta;

    protected ModoDeJuego(String ruta){
        this.ruta = ruta;
    }

    
    
    public Personaje crearPersonaje(int x, int y) {
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("marionormal-quieto-derecha", new Sprite(ruta + "/mario-quieto-derecha.png"));
        entidadGrafica.setSprite("marionormal-quieto-izquierda", new Sprite(ruta + "/mario-quieto-izquierda.png"));
        entidadGrafica.setSprite("marionormal-movimiento-derecha", new Sprite(ruta + "/mario-movimiento-derecha.gif"));
        entidadGrafica.setSprite("marionormal-movimiento-izquierda", new Sprite(ruta + "/mario-movimiento-izquierda.gif"));
        entidadGrafica.setSprite("marionormal-saltando-derecha", new Sprite(ruta + "/mario-saltando-derecha.png"));
        entidadGrafica.setSprite("marionormal-saltando-izquierda", new Sprite(ruta + "/mario-saltando-izquierda.png"));
        entidadGrafica.setSprite("mariosuper-quieto-derecha", new Sprite(ruta + "/supermario-quieto-derecha.png"));
        entidadGrafica.setSprite("mariosuper-quieto-izquierda", new Sprite(ruta + "/supermario-quieto-izquierda.png"));
        entidadGrafica.setSprite("mariosuper-movimiento-derecha", new Sprite(ruta + "/supermario-movimiento-derecha.gif"));
        entidadGrafica.setSprite("mariosuper-movimiento-izquierda", new Sprite(ruta + "/supermario-movimiento-izquierda.gif"));
        entidadGrafica.setSprite("mariosuper-saltando-derecha", new Sprite(ruta + "/supermario-saltando-derecha.png"));
        entidadGrafica.setSprite("mariosuper-saltando-izquierda", new Sprite(ruta + "/supermario-saltando-izquierda.png"));
        entidadGrafica.setSprite("marioflordefuego-quieto-derecha", new Sprite(ruta + "/marioflordefuego-quieto-derecha.png"));
        entidadGrafica.setSprite("marioflordefuego-quieto-izquierda", new Sprite(ruta + "/marioflordefuego-quieto-izquierda.png"));
        entidadGrafica.setSprite("marioflordefuego-movimiento-derecha", new Sprite(ruta + "/marioflordefuego-movimiento-derecha.gif"));
        entidadGrafica.setSprite("marioflordefuego-movimiento-izquierda", new Sprite(ruta + "/marioflordefuego-movimiento-izquierda.gif"));
        entidadGrafica.setSprite("marioflordefuego-saltando-derecha", new Sprite(ruta + "/marioflordefuego-saltando-derecha.png"));
        entidadGrafica.setSprite("marioflordefuego-saltando-izquierda", new Sprite(ruta + "/marioflordefuego-saltando-izquierda.png"));
        entidadGrafica.setSprite("marioflordefuego-lanzando-derecha", new Sprite(ruta + "/marioflordefuego-lanzando-derecha.png"));
        entidadGrafica.setSprite("marioflordefuego-lanzando-izquierda", new Sprite(ruta + "/marioflordefuego-lanzando-izquierda.png"));
        Personaje personaje = new Personaje(x, y, entidadGrafica.getSprite("marionormal-quieto-derecha"));
        personaje.setEntidadGrafica(entidadGrafica);
        return personaje;
    }

    public BloqueSolido crearPiso(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/piso.png");
        BloqueSolido bloque = new BloqueSolido(x, y, sprite);
        return bloque;
    }

    public BloqueDePregunta crearBloquePregunta(int x, int y) {
        
           
        Random r = new Random();

        int resultado = r.nextInt(7);
        PowerUp aSetear = null;


        switch (resultado) {
            case 0:
                aSetear = new Moneda(x, y - ConstantesVistas.TAMANO_BLOQUE + 20, new Sprite(ruta + "/moneda.gif"));
            break;

            case 1:
                aSetear = new ChampignonVerde(x, y - ConstantesVistas.TAMANO_BLOQUE + 20 , new Sprite(ruta + "/champinonverde.png"));
            break;

            case 3:
                aSetear = new FlorDeFuego(x, y - ConstantesVistas.TAMANO_BLOQUE + 20, new Sprite(ruta + "/flordefuego.gif"));
            break;

            case 4:
                aSetear = new Estrella(x, y - ConstantesVistas.TAMANO_BLOQUE + 20, new Sprite(ruta + "/estrella.gif"));
            break;
        }

        Sprite sprite = new Sprite(ruta + "/bloque-pregunta.gif");
        BloqueDePregunta bloque = new BloqueDePregunta(x, y, sprite,aSetear);
        EntidadGrafica entidadGrafica = new EntidadGrafica();

        entidadGrafica.setSprite("bloque-pregunta-vacio", new Sprite(ruta+ "/bloque-pregunta-after-hit.png"));  
        bloque.setEntidadGrafica(entidadGrafica);       

        return bloque;
    }

    public LadrilloSolido crearLadrillo(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/ladrillo.png");
        LadrilloSolido bloque = new LadrilloSolido(x, y, sprite);
        return bloque;
    }

    public Tuberia crearTuberia(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/tuberia.png");
        Tuberia tuberia = new Tuberia(x, y, sprite, crearPiranhaPlant(x, y));
        return tuberia;
    }

    public BloqueSolido crearPartetuberia(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/parte-tuberia.png");
        BloqueSolido partetuberia = new BloqueSolido(x, y, sprite);
        return partetuberia;
    }

    public PiranhaPlant crearPiranhaPlant(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/piranha-plant.gif");
        PiranhaPlant piranha = new PiranhaPlant(x, y, sprite);
        return piranha;
    }

    public Goomba crearGoomba(int x, int y) {
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("goomba", new Sprite(ruta + "/goomba.gif"));
        entidadGrafica.setSprite("goomba-eliminado", new Sprite(ruta + "/goomba-eliminado.gif"));
        Goomba goomba = new Goomba(x, y, entidadGrafica.getSprite("goomba"));
        goomba.setEntidadGrafica(entidadGrafica);
        return goomba;
    }

    public BuzzyBeetle crearBuzzyBeetle(int x,int y){
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("buzzy-beetle-izquierda", new Sprite(ruta + "/buzzy-beetle-izquierda.gif"));
        entidadGrafica.setSprite("buzzy-beetle-derecha", new Sprite(ruta + "/buzzy-beetle-derecha.gif"));
        entidadGrafica.setSprite("buzzy-beetle-caparazon", new Sprite(ruta + "/buzzy-beetle-caparazon.gif"));
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(x, y, entidadGrafica.getSprite("buzzy-beetle-izquierda"));
        buzzyBeetle.setEntidadGrafica(entidadGrafica);
        return buzzyBeetle;
    }

    public KoopaTroopa crearKoopaTroopa(int x, int y) {
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("koopa-troopa-izquierda", new Sprite(ruta + "/koopa-troopa-izquierda.gif"));
        entidadGrafica.setSprite("koopa-troopa-derecha", new Sprite(ruta + "/koopa-troopa-derecha.gif"));
        entidadGrafica.setSprite("koopa-troopa-caparazon", new Sprite(ruta + "/koopa-troopa-caparazon.gif"));
        KoopaTroopa koopa = new KoopaTroopa(x, y, entidadGrafica.getSprite("koopa-troopa-izquierda"));
        koopa.setEntidadGrafica(entidadGrafica);
        return koopa;
    }

    public Lakitu crearLakitu(int x, int y) {
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("lakitu-izquierda", new Sprite(ruta + "/lakitu-izquierda.png"));
        entidadGrafica.setSprite("lakitu-derecha", new Sprite(ruta + "/lakitu-derecha.png"));
        entidadGrafica.setSprite("lakitu-lanzando", new Sprite(ruta + "/lakitu-lanzando.png"));
        Lakitu lakitu = new Lakitu(x, y, entidadGrafica.getSprite("lakitu-izquierda"));
        lakitu.setEntidadGrafica(entidadGrafica);
        return lakitu;
    }

    public Spiny crearSpiny(int x, int y) {
        EntidadGrafica entidadGrafica = new EntidadGrafica();
        entidadGrafica.setSprite("spiny-izquierda", new Sprite(ruta + "/spiny-izquierda.gif"));
        entidadGrafica.setSprite("spiny-derecha", new Sprite(ruta + "/spiny-derecha.gif"));
        entidadGrafica.setSprite("spiny-lanzado", new Sprite(ruta + "/spiny-lanzado.gif"));
        Spiny spiny = new Spiny(x, y, entidadGrafica.getSprite("spiny-izquierda"));
        spiny.setEntidadGrafica(entidadGrafica);
        return spiny;
    }


    public Estrella crearEstrella(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/estrella.gif");
        Estrella estrella = new Estrella(x, y, sprite);
        return estrella;
    }

    public SuperChampignon crearSuperChampignon(int x, int y){
        Sprite spriteSuperChampignon = new Sprite(ruta + "/superchampinon.png");
        SuperChampignon toReturn = new SuperChampignon(x, y, spriteSuperChampignon);
        return toReturn;
    }
    
    public Moneda crearMoneda(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/moneda.gif");
        Moneda moneda = new Moneda(x, y, sprite);
        return moneda;
    }

    public ChampignonVerde crearChampignonVerde(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/champinonverde.png");
        ChampignonVerde champignon = new ChampignonVerde(x, y, sprite);
        return champignon;
    }

    public FlorDeFuego crearFlorDeFuego(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/flordefuego.gif");
        FlorDeFuego flor = new FlorDeFuego(x, y, sprite);
        return flor;
    }

    public Vacio crearVacio(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/vacio.png");
        Vacio vacio = new Vacio(x, y, sprite);
        return vacio;
    }

    public Fondo crearFondo(int x, int y) {
        Sprite sprite = new Sprite(ruta + "/fondo.png");
        Fondo fondo = new Fondo(x, y, sprite);
        return fondo;
    }


}
