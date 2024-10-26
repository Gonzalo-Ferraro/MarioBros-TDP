package Logica.Entidades;

public class KoopaTroopaCaparazon  implements EstadoKoopaTroopa {
    private KoopaTroopa koopa;
    private EntidadGrafica entidadGrafica;

    public KoopaTroopaCaparazon(KoopaTroopa k){
        koopa = k;
    }

    @Override
    public void setEntidadGrafica(EntidadGrafica e){
        entidadGrafica = e;
    }

    @Override
    public void serAfectadoPor(Personaje p){
        koopa.desaparecer();
    }

    @Override
    public void cambiarDireccion(){
        
    }

    @Override
    public Sprite moverX(){
        return entidadGrafica.getSprite("koopa-troopa-caparazon");
    }
}
