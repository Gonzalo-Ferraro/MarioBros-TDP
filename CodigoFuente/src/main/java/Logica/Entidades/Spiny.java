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
        if (vivo) {
            super.moverX();

            if (direccion == -1)
                sprite = entidadGrafica.getSprite("spiny-izquierda");
            else
                sprite = entidadGrafica.getSprite("spiny-derecha");
            
            observador.actualizarImagen();
        }
    }

    public void moverY() {
        if (vivo) {
            super.moverY();
        }
    }

    @Override
    public void aparecer(int x, int y) {
        super.aparecer(x, y);
        vivo = true;
    }
}
