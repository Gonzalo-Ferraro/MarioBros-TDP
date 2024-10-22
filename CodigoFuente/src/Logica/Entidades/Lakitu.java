package Logica.Entidades;

public class Lakitu extends Enemigo {

    public Lakitu(int x, int y, Sprite s){
        super(x, y, s);
    
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
        desaparecer();
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

    public void mover(){
        super.mover();
        
        if (direccion == -1)
           sprite = entidadGrafica.getSprite("lakitu-izquierda");
        else
            sprite = entidadGrafica.getSprite("lakitu-derecha");
        
        observador.actualizarImagen();
    
    }
}
