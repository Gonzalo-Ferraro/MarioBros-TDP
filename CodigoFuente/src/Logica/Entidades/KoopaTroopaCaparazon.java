package Logica.Entidades;

public class KoopaTroopaCaparazon  implements EstadoKoopaTroopa {
    private KoopaTroopa koopa;
    private EntidadGrafica entidadGrafica;

    public KoopaTroopaCaparazon(KoopaTroopa k){
        koopa= k;
    }

    public void setEntidadGrafica(EntidadGrafica e){
        entidadGrafica=e;
    }

    public void serAfectadoPor(Personaje p){
        koopa.desaparecer();
    }

    public void cambiarDireccion(){
        
    }

    public Sprite moverX(){
        return entidadGrafica.getSprite("koopa-troopa-caparazon");
    }

}
