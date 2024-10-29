package Logica.Entidades;

public class KoopaTroopa extends Enemigo {
    private EstadoKoopaTroopa estado;

    public KoopaTroopa(int x, int y, Sprite s){
        super(x, y, s);
        estado = new KoopaTroopaNormal(this);
    }

    @Override
    public void setEntidadGrafica(EntidadGrafica e){
        super.setEntidadGrafica(e);
        estado.setEntidadGrafica(e);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
        estado.serAfectadoPor(p);
    }

    @Override
    public void afectarAMario(Personaje p) {
        estado.afectarAMario(p);
    }

    public void setEstado(EstadoKoopaTroopa e){
        estado = e;
        observador.actualizarPosicionTamano();
        observador.actualizarImagen();
    }

    @Override
    public void moverX(){
        super.moverX();
        sprite = estado.moverX(); 
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();
    }

    @Override
    public void cambiarDireccion(){
        super.cambiarDireccion();
        estado.cambiarDireccion();
    }

    public void setVelocidadX(int x) {
        velocidadX = x;
    }

    public void setDireccion(int d) {
        direccion = d;
    }

    @Override
    public void serAfectadoPorBola(Personaje p) {
        estado.serAfectadoPor(p);
    }
}
