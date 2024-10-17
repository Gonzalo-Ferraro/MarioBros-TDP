package Logica.Entidades;

public abstract class Enemigo extends Entidad implements AfectablePorMario, AfectadorAMario {

    protected Enemigo(int x, int y, Sprite s){
        super(x, y, s);
        direccion = -1;
        velocidad = 2;
    }

    public void mover(){
        x += direccion*velocidad;
        System.out.println("Moviendo enemigo, direccion: " + direccion+"velocidad: "+velocidad);
        observador.actualizarImagen();
        observador.actualizarPosicionTamano();

    }

    public void cambiarDireccion(){
        if(direccion == -1)
            direccion = 1;
        else
            direccion = -1;

    }
}
