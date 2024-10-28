package Logica.Entidades;

public class Tuberia extends Plataforma {

    protected PiranhaPlant mPiranha;

    public Tuberia(int x, int y, Sprite s, PiranhaPlant piranha) {
        super(x, y, s);
        mPiranha = piranha;
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        // no hace nada
    }

    public PiranhaPlant getPiranhaPlant() {
        return mPiranha;
    }
}
