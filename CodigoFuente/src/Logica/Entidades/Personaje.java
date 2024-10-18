package Logica.Entidades;

import Logica.EstadosMario.EstadoMario;
import Logica.EstadosMario.MarioNormal;
import Logica.Juego.Juego;
import Vistas.ConstantesVistas;
import Vistas.Observer;


public class Personaje extends Entidad implements EntidadJugador {
    private Juego juego;

    protected int vidas;
    protected int puntaje;
    private int velocidadY;

    private boolean estaEnElAire;

    private EstadoMario estado;

    public Personaje(int x, int y, Sprite sprite) {
        super(x, y, sprite);

        velocidadX = 7;
        velocidadY = 0;
        direccion = 0;

        puntaje = 0;

        this.vidas = 3;

        estado = new MarioNormal(this);
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
        if(puntaje + punt <= 0)
            puntaje = 0;
        else puntaje += punt;
    }

    public void setVidas(int vida){
        if(vidas + vida == 0)
            juego.perdiste();
        else vidas += vida;
    }

    public void setVelocidadY(int v){
        velocidadY = v;
    }

    public void setPosicionY(int y){
        this.y = y;
        observador.actualizarPosicionTamano();
    }

    public int getVelocidadY(){
        return velocidadY;
    }

    public void mover() {
        
        x = x + (velocidadX * direccion);

        if (estaEnElAire) {
            velocidadY += ConstantesVistas.GRAVEDAD;
            y += velocidadY;
        }
       
        observador.actualizarPosicionTamano();
    }

    public void setDireccion(int d){
        
        if( direccion==-1 && d==1 || direccion==1 && d==-1){
            velocidadX=0;
            estado.setDireccion(0);
        }
        else{
            velocidadX=7;
            direccion = d;
            estado.setDireccion(d);
        }
    }

    public void perderVida() {
        vidas--;
        juego.getEntidadSonora().reproducirSonido("muerte");
        
        if (vidas == 0) 
            juego.perdiste();
        else 
            juego.reiniciarNivel();
    }

    public void setSprite(Sprite s){
        sprite = s;
        observador.actualizarImagen();
    }

    public EntidadGrafica getEntidadGrafica() {
        return entidadGrafica;
    }
    public Observer getObserver() {
        return observador;
    }
    
    public boolean estaCayendo() {
        return estaEnElAire && velocidadY < 0;
    }

    public boolean estaEnElAire() {
        return estaEnElAire;
    }

    public void setEstaEnElAire(boolean b) {
        estaEnElAire = b;
    }

    public void saltar() {
        if (!estaEnElAire) {
            estaEnElAire = true;
            juego.getEntidadSonora().reproducirSonido("salto");
            estado.saltar();
        }
    }

    public void espacio(){
        //ver como hacer lo del efecto de bola de fuego
    }

    public void reiniciar() {
        estado = new MarioNormal(this);

        velocidadX = 7;
        velocidadY = 0;
        direccion = 0;

        x = juego.getNivelActual().getPersonaje().getX();
        y = juego.getNivelActual().getPersonaje().getY();

        observador.actualizarPosicionTamano();

        System.out.println("Reiniciando personaje");
    }

    public void serAfectadoPor(ChampignonVerde champignonVerde) {
        juego.getEntidadSonora().reproducirSonido("vida");
        estado.serAfectadoPor(champignonVerde);
    }


	public void serAfectadoPor(Estrella estrella) {
        juego.getEntidadSonora().reproducirSonido("estrella");
		estado.serAfectadoPor(estrella);
        //LUEGO DEL TIMER juego.getEntidadSonora.detenerLoopEstrella();
	}


	public void serAfectadoPor(FlorDeFuego florDeFuego) {
        juego.getEntidadSonora().reproducirSonido("powerup");
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
     juego.getEntidadSonora().reproducirSonido("powerup");
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
        juego.getEntidadSonora().reproducirSonido("moneda");
        estado.serAfectadoPor(moneda);
    }

    public void serAfectadoPor(Vacio vacio) {
        estado.serAfectadoPor(vacio);
    }

    public Juego getJuego() {
        return juego;
    }
    
}
