package Logica.Entidades;

import Logica.EstadosMario.EstadoMario;
import Logica.EstadosMario.MarioNormal;
import Logica.Juego.Juego;
import Vistas.Observer;

public class Personaje extends Entidad implements EntidadJugador {
    private Juego juego;

    protected int vidas;
    protected int puntaje;

    private boolean derecha;
    private boolean izquierda;

    private EstadoMario estado;

    public Personaje(int x, int y, Sprite sprite) {
        super(x, y, sprite);

        velocidad = 7;
        derecha = false;
        izquierda = false;
        puntaje=0;

        this.vidas=3;

        estado= new MarioNormal(this);
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getVidas(){
        return vidas;
    }

    public void setJuego(Juego j) {
        juego = j;
    }
    public void setEstado(EstadoMario estado){
        this.estado = estado;
    }
    public void setPuntaje(int punt){
        puntaje += punt;
    }

    public void mover() {
        if (derecha) {
            x += velocidad;
        }
        if (izquierda) {
            x -= velocidad;
        }

        observador.actualizarPosicionTamano();
    }

    public void setDerecha(boolean b) {
        derecha = b;
        
        if (!b && !izquierda)
        sprite = juego.getModo().getMarioQuietoDerecha();
        else if (b && izquierda)
        sprite = juego.getModo().getMarioQuietoIzquierda();
        
        actualizarSprite();
    }

    public void setIzquierda(boolean b) {
        izquierda = b;
        actualizarSprite();

        if (!b && !derecha)
            sprite = juego.getModo().getMarioQuietoIzquierda();
        else if (b && derecha)
            sprite = juego.getModo().getMarioQuietoDerecha();

        actualizarSprite();
    }

    private void actualizarSprite() {
        if (derecha && !izquierda) 
            sprite = juego.getModo().getMarioMoviendoDerecha();
        else if (izquierda && !derecha)
            sprite = juego.getModo().getMarioMoviendoIzquierda();

        observador.actualizarImagen();
    }

    public Observer getObserver() {
        return observador;
    }

    public int getVelocidadActual() {
        int velocidadActual;

        if (derecha && !izquierda) {
            velocidadActual = velocidad;
        } else if (izquierda && !derecha) {
            velocidadActual = -velocidad;
        } else {
            velocidadActual = 0;
        }

        return velocidadActual;
    }
    
    //falta implementar
    public void saltar(){}
    public void espacio(){}
    public void serAfectadoPor(ChampignonVerde champignonVerde) {
        estado.serAfectadoPor(champignonVerde);
    }


	public void serAfectadoPor(Estrella estrella) {
		estado.serAfectadoPor(estrella);
	}


	public void serAfectadoPor(FlorDeFuego florDeFuego) {
        estado.serAfectadoPor(florDeFuego);
	 
	}


	public void serAfectadoPor(BuzzyBeetle buzzyBeetle) {
	   estado.serAfectadoPor(buzzyBeetle);
	}


	public void serAfectadoPor(Spiny spiny) {
	 estado.serAfectadoPor(spiny);
	}


	public void serAfectadoPor(Lakitu lakitu) {
	 estado.serAfectadoPor(lakitu);
	}


	public void serAfectadoPor(PiranhaPlant piranhaPlant) {
	 estado.serAfectadoPor(piranhaPlant);
	}


	public void serAfectadoPor(KoopaTroopa koopaTroopa) {
	 estado.serAfectadoPor(koopaTroopa);
	}


	public void serAfectadoPor(SuperChampignon superChampignon) {
	 estado.serAfectadoPor(superChampignon);
	}


	public void serAfectadoPor(Goomba goomba) {
	 estado.serAfectadoPor(goomba);
	}


	public void AfectarA(LadrilloSolido ladrilloSolido) {
	 estado.AfectarA(ladrilloSolido);
	}


	public void AfectarA(BloqueDePregunta bloqueDePregunta) {
	 estado.AfectarA(bloqueDePregunta);
	}


	public void AfectarA(BuzzyBeetle buzzyBeetle) {
	 estado.AfectarA(buzzyBeetle);
	}


	public void AfectarA(Spiny spiny) {
	 estado.AfectarA(spiny);
	}


	public void AfectarA(Lakitu lakitu) {
	 estado.AfectarA(lakitu);
	}


	public void AfectarA(PiranhaPlant piranhaPlant) {
	 estado.AfectarA(piranhaPlant);
	}


	public void AfectarA(KoopaTroopa koopaTroopa) {
	 estado.AfectarA(koopaTroopa);
	}


	public void AfectarA(Goomba goomba) {
	 estado.AfectarA(goomba);
	}

    public void serAfectadoPor(Moneda moneda) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'serAfectadoPor'");
    }

    public void serAfectadoPor(Vacio vacio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'serAfectadoPor'");
    }


    
}
