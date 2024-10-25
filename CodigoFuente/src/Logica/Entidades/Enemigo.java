package Logica.Entidades;

import Vistas.ConstantesVistas;

public abstract class Enemigo extends Entidad implements AfectablePorMario, AfectadorAMario {

    protected boolean estaEnElAire;
    protected  int velocidadY;

    protected Enemigo(int x, int y, Sprite s){
        super(x, y, s);
        direccion = -1;
        velocidadX = 2;
        velocidadY = 0;
    }

    public void moverX() {
        x += direccion * velocidadX;
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    public int getVelocidadX() {
        return direccion * velocidadX;
    }

    public void moverY() {
        if (estaEnElAire) {
            velocidadY += ConstantesVistas.GRAVEDAD;
            y += velocidadY;

            if(y > ConstantesVistas.VENTANA_ALTO){
                //me cai al vacio
                desaparecer();
            }
        }

        observador.actualizarPosicionTamano();
    }

    public void setEstaEnElAire(boolean b) {
        estaEnElAire = b;
    }

    public void cambiarDireccion(){
        direccion = direccion * -1;
    }
}
