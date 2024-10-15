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
        // Implementation here
    }


	public void serAfectadoPor(Estrella estrella) {
		// Implementation here
	}


	public void serAfectadoPor(FlorDeFuego florDeFuego) {
		// Implementation here
	}


	public void serAfectadoPor(BuzzyBeetle buzzyBeetle) {
		// Implementation here
	}


	public void serAfectadoPor(Spiny spiny) {
		// Implementation here
	}


	public void serAfectadoPor(Lakitu lakitu) {
		// Implementation here
	}


	public void serAfectadoPor(PiranhaPlant piranhaPlant) {
		// Implementation here
	}


	public void serAfectadoPor(KoopaTroopa koopaTroopa) {
		// Implementation here
	}


	public void serAfectadoPor(SuperChampignon superChampignon) {
		// Implementation here
	}


	public void serAfectadoPor(Goomba goomba) {
		// Implementation here
	}


	public void AfectarA(LadrilloSolido ladrilloSolido) {
		// Implementation here
	}


	public void AfectarA(BloqueDePregunta bloqueDePregunta) {
		// Implementation here
	}


	public void AfectarA(BuzzyBeetle buzzyBeetle) {
		// Implementation here
	}


	public void AfectarA(Spiny spiny) {
		// Implementation here
	}


	public void AfectarA(Lakitu lakitu) {
		// Implementation here
	}


	public void AfectarA(PiranhaPlant piranhaPlant) {
		// Implementation here
	}


	public void AfectarA(KoopaTroopa koopaTroopa) {
		// Implementation here
	}


	public void AfectarA(Goomba goomba) {
		// Implementation here
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
