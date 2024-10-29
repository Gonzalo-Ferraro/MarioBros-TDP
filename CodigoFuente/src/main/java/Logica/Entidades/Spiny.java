package Logica.Entidades;

public class Spiny extends Enemigo {
    private boolean vivo;

    public Spiny(int x, int y, Sprite s){
        super(x, y, s);
        vivo = false;
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
        if (vivo && !estaEnElAire) {
            super.moverX();

            if (direccion == -1)
                sprite = entidadGrafica.getSprite("spiny-izquierda");
            else
                sprite = entidadGrafica.getSprite("spiny-derecha");
            
            observador.actualizarImagen();
        }
    }

    @Override
    public void moverY() {
        if (vivo) {
            super.moverY();

            if (estaEnElAire) {
                sprite = entidadGrafica.getSprite("spiny-lanzado");
                observador.actualizarImagen();
            }
        }
    }

    @Override
    public void aparecer(int x, int y) {
        super.aparecer(x, y);

        vivo = true;
        velocidadY = -15;
    }

    @Override
    public void serAfectadoPorBola(Personaje p) {
        p.AfectarA(this);
        desaparecer();
    }
}
