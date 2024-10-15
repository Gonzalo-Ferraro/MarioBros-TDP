package Logica.EstadosMario;

import Logica.Entidades.BloqueDePregunta;
import Logica.Entidades.BuzzyBeetle;
import Logica.Entidades.ChampignonVerde;
import Logica.Entidades.Estrella;
import Logica.Entidades.FlorDeFuego;
import Logica.Entidades.Goomba;
import Logica.Entidades.KoopaTroopa;
import Logica.Entidades.LadrilloSolido;
import Logica.Entidades.Lakitu;
import Logica.Entidades.Moneda;
import Logica.Entidades.Personaje;
import Logica.Entidades.PiranhaPlant;
import Logica.Entidades.Spiny;
import Logica.Entidades.SuperChampignon;
import Logica.Entidades.Vacio;
import Logica.Fabricas.ModoDeJuego;

public abstract class EstadoMario  {
protected Personaje personaje;
        
        public EstadoMario(Personaje p) {
            personaje = p;
        }
        
        public void serAfectadoPor(Goomba g){
            personaje.setPuntaje(personaje.getPuntaje()+60);
        }
        public abstract void serAfectadoPor(SuperChampignon s);
        public void serAfectadoPor(KoopaTroopa k){
            personaje.setPuntaje(personaje.getPuntaje()+90);
        }
        public void serAfectadoPor(PiranhaPlant p){
            personaje.setPuntaje(personaje.getPuntaje()+30);
        }
        public  void serAfectadoPor(ChampignonVerde c){
            personaje.setPuntaje((personaje.getPuntaje()+100));
        }
        public void serAfectadoPor(Lakitu l){
            personaje.setPuntaje(personaje.getPuntaje()+60);
        }
        public void serAfectadoPor(Spiny s){
            personaje.setPuntaje(personaje.getPuntaje()+600);
        }
        public void serAfectadoPor(BuzzyBeetle b){
            personaje.setPuntaje(personaje.getPuntaje()+30);
        }
        public abstract void serAfectadoPor(FlorDeFuego f);
        public abstract void serAfectadoPor(Estrella e);
        public  void serAfectadoPor(Vacio v){}
        public  void serAfectadoPor(Moneda m){
            personaje.setPuntaje(personaje.getPuntaje() + 5);
        }
        public abstract void AfectarA(Goomba g);
        public abstract void AfectarA(KoopaTroopa k);
        public abstract void AfectarA(PiranhaPlant p);
        public abstract void AfectarA(Lakitu l);
        public abstract void AfectarA(Spiny s);
        public abstract void AfectarA(BuzzyBeetle b);
        public abstract void AfectarA(BloqueDePregunta bloq);
        public abstract void AfectarA(LadrilloSolido ladrillo);
        // cambiar parametro cuando agreguemos el arreglo de sprites
        public abstract void cambiarSprite(ModoDeJuego modo );
        public void saltar(){
            personaje.saltar();
        }
        public void  espacio(){
            personaje.espacio();
        }
}
