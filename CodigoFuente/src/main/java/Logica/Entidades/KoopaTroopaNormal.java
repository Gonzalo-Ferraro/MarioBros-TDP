package Logica.Entidades;

public class KoopaTroopaNormal implements EstadoKoopaTroopa{
    private KoopaTroopa koopa;
    private int direccion;
    private EntidadGrafica entidadGrafica;

    public KoopaTroopaNormal(KoopaTroopa k){
        koopa = k;
        direccion = -1;
    }

    @Override
    public void setEntidadGrafica(EntidadGrafica e){
        entidadGrafica = e;
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        KoopaTroopaCaparazon caparazon = new KoopaTroopaCaparazon(koopa);
        caparazon.setEntidadGrafica(entidadGrafica);
        koopa.setEstado(caparazon);
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(koopa);
    }

    @Override
    public void cambiarDireccion() {
        direccion *= -1;
    }
    
    @Override
    public Sprite moverX(){
        if(direccion == -1){
            return entidadGrafica.getSprite("koopa-troopa-izquierda");
        }
        else
            return entidadGrafica.getSprite("koopa-troopa-derecha");
    }
}