package Logica.Entidades;

import Vistas.ConstantesVistas;

public class BolaDeFuego extends Entidad {
    private int direccion;
    private int velocidadY;
    private int choques;
    private boolean viva;

    public BolaDeFuego(int x, int y, Sprite s, int direccion) {
        super(x, y, s);
        this.direccion = direccion;
        velocidadY = 0;
        choques = 0;
        viva = true;
        velocidadX = ConstantesEntidades.VELOCIDAD_BOLA_DE_FUEGO;
    }

    public void moverX() {
        x += direccion * velocidadX;
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    public void setVelocidadY(int v) {
        velocidadY = v;
    }

    public int getVelocidadX() {
        return direccion * velocidadX;
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void moverY() {
        velocidadY += ConstantesVistas.GRAVEDAD;
        y += velocidadY;

        observador.actualizarPosicionTamano();
    }

    public void reboteSuelo() {
        velocidadY = ConstantesEntidades.VELOCIDAD_REBOTE_BOLA_DE_FUEGO;
    }

    public void cambiarDireccion() {
        direccion = direccion * -1;
    }

    public void setPosicionY(int y) {
        this.y = y;
    }

    public int getChoques() {
        return choques;
    }

    public boolean getViva() {
        return viva;
    }

    public void choque() {
        choques++;
    }

    @Override
    public void desaparecer() {
        super.desaparecer();
        viva = false;
    }
}
