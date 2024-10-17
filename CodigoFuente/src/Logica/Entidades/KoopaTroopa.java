package Logica.Entidades;

public class KoopaTroopa extends Enemigo {

    public KoopaTroopa(int x, int y, Sprite s){
        super(x, y, s);
       
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.AfectarA(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }
   
    //VA EN LOS ESTADOS

    public void mover(){
        super.mover();
        if(direccion == -1)
            sprite=entidadGrafica.getSprite("koopa-troopa-izquierda");
        else
            sprite=entidadGrafica.getSprite("koopa-troopa-derecha");

    observador.actualizarImagen();
    observador.actualizarPosicionTamano();
    }

}
