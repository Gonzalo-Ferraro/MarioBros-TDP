package Logica.Entidades;

import java.util.Random;

public class Tuberia extends Plataforma {

    protected PiranhaPlant mPiranha;

    public Tuberia(int x, int y, Sprite s, PiranhaPlant piranha) {
        super(x, y, s);
        generarPiranhaAleatoria(x, y, piranha);
    }

    private void generarPiranhaAleatoria(int x, int y, PiranhaPlant p) {
        Random random = new Random();
        if (random.nextBoolean()) { // 50% de probabilidad de generar una PiranhaPlant
            mPiranha = p;
        }
    }
}
