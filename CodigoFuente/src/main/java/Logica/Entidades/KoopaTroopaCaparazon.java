package Logica.Entidades;

public class KoopaTroopaCaparazon  implements EstadoKoopaTroopa {
    private KoopaTroopa koopa;
    private EntidadGrafica entidadGrafica;
    private boolean rebotando;

    public KoopaTroopaCaparazon(KoopaTroopa k) {
        koopa = k;
        rebotando = false;
        koopa.setVelocidadX(0);
    }

    @Override
    public void setEntidadGrafica(EntidadGrafica e) {
        entidadGrafica = e;
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        koopa.desaparecer();
    }

    @Override
    public void afectarAMario(Personaje p) {
        if (!rebotando) {
            rebotando = true;

            int direccionKoopa = (p.getVelocidadX() >= 0) ? 1 : -1;

            koopa.setDireccion(direccionKoopa);
            koopa.setVelocidadX(ConstantesEntidades.VELOCIDAD_KOOPA_TROOPA_CAPARAZON);
        } else {
            p.serAfectadoPor(koopa);
        }
    }

    @Override
    public void cambiarDireccion() {
        
    }

    @Override
    public Sprite moverX(){
        return entidadGrafica.getSprite("koopa-troopa-caparazon");
    }
}
