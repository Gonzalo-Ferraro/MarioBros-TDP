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
        this.x = posicionX;
        this.y = posicionY;
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
    public void moverX() {
    }

    @Override
    public void moverY() {
        tiempoAparicion++;

        if (tiempoAparicion == 60 * 5) {
            tiempoAparicion = 0;
            afuera = !afuera;
        }

        if (afuera && y > posicionY)
            y -= 1;
        else if (!afuera && y < posicionY + ConstantesEntidades.ALTO_PIRHANA_PLANT)
            y += 1;

        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    @Override
    public void serAfectadoPorBola(Personaje p) {
        p.AfectarA(this);
        desaparecer();
    }
}
