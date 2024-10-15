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
        
        public abstract void serAfectadoPor(Goomba g);
        public abstract void serAfectadoPor(SuperChampignon s);
        public abstract void serAfectadoPor(KoopaTroopa k);
        public abstract void serAfectadoPor(PiranhaPlant p);
        public abstract void serAfectadoPor(ChampignonVerde c0);
        public abstract void serAfectadoPor(Lakitu l);
        public abstract void serAfectadoPor(Spiny s);
        public abstract void serAfectadoPor(BuzzyBeetle b);
        public abstract void serAfectadoPor(FlorDeFuego f);
        public abstract void serAfectadoPor(Estrella e);
        public abstract void serAfectadoPor(Vacio v);
        public abstract void serAfectadoPor(Moneda m);
        public abstract void AfectarA(Goomba g);
        public abstract void AfectarA(KoopaTroopa k);
        public abstract void AfectarA(PiranhaPlant p);
        public abstract void AfectarA(Lakitu l);
        public abstract void AfectarA(Spiny s);
        public abstract void AfectarA(BuzzyBeetle b);
        public abstract void AfectarA(BloqueDePregunta bloq);
        public abstract void AfectarA(LadrilloSolido ladrillo);
        public abstract void cambiarSprite(ModoDeJuego modo );
        public void saltar(){
            personaje.saltar();
        }
        public void  espacio(){
            personaje.espacio();
        }
}
