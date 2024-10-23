package Logica.Entidades;

public class BuzzyBeetle extends Enemigo {

    public BuzzyBeetle(int x, int y, Sprite s){
        super(x, y, s);
    
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        p.serAfectadoPor(this);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.AfectarA(this);
    }
    
    public void moverX(){
        super.moverX();
        if(direccion==-1)
            sprite = entidadGrafica.getSprite("buzzy-beetle-izquierda");
        else
            sprite = entidadGrafica.getSprite("buzzy-beetle-derecha");

        observador.actualizarImagen();
    }

}
