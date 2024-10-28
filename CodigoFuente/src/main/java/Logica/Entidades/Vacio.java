package Logica.Entidades;

public class Vacio extends Plataforma implements AfectadorAMario {

    @Override
    public void afectarAMario(Personaje personaje) {
        personaje.serAfectadoPor(this);
    }

    // CHECKEAR QUE SEA ASI

    public Vacio(int x, int y, Sprite s){
        super(x, y, s);
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        // HARD CODE
        System.out.println("estoy en vacio");
        p.serAfectadoPor(this);
    }

    

}
