package Logica.Entidades;

public abstract class Enemigo extends Entidad implements AfectablePorMario, AfectadorAMario {

    protected Enemigo(int x, int y, Sprite s){
        super(x, y, s);
        direccion = -1;
        velocidadX = 2;
    }

    public void mover() {
        x += direccion * velocidadX;
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    public void cambiarDireccion(){
        if (direccion == -1)
            direccion = 1;
        else
            direccion = -1;
    }
}
