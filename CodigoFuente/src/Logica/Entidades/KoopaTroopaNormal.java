package Logica.Entidades;

public class KoopaTroopaNormal implements EstadoKoopaTroopa{
        private KoopaTroopa koopa;
        private int direccion;
        private EntidadGrafica entidadGrafica;

        public KoopaTroopaNormal(KoopaTroopa k){
            koopa= k;
            direccion=-1;
        }

        public void setEntidadGrafica(EntidadGrafica e){
            entidadGrafica=e;
        }
        public void serAfectadoPor(Personaje p){
            KoopaTroopaCaparazon caparazon = new KoopaTroopaCaparazon(koopa);
            caparazon.setEntidadGrafica(entidadGrafica);
           koopa.setEstado(caparazon);

        }

        public void cambiarDireccion(){
            direccion*=-1;
        }
        public Sprite moverX(){
            if(direccion==-1){
               return entidadGrafica.getSprite("koopa-troopa-izquierda");
        }
        else
            return entidadGrafica.getSprite("koopa-troopa-derecha");
    }
}
