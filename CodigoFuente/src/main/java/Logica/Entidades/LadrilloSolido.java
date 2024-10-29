package Logica.Entidades;

public class LadrilloSolido extends BloqueSolido {

    public LadrilloSolido(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
    }

    @Override
    public void serAfectadoPorBola() {
        desaparecer();
    }
}
