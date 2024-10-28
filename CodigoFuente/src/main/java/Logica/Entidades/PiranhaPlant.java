package Logica.Entidades;

public class PiranhaPlant extends Enemigo {

    protected boolean afuera;
    protected int posicionX;
    protected int posicionY;

    protected int tiempoAparicion;

    public PiranhaPlant(int x, int y, Sprite s){
        super(x, y, s);
        velocidadX = 0;
        afuera = false;

        tiempoAparicion = 0;

        posicionX = x;
        posicionY = y;
        this.x = -1000;
        this.y = -1000;
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void moverX(){
    }

    @Override
    public void moverY(){
        System.out.println();
        tiempoAparicion++;

        if(tiempoAparicion == 60 * 5){
            tiempoAparicion = 0;
            afuera = !afuera;
        }


        if(afuera){
            desaparecer();
        }
        else {
            aparecer(posicionX, posicionY);
        }

        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    

}
