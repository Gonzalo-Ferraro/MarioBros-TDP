package Logica.EstadosMario;

import Logica.Entidades.*;
import Vistas.ConstantesVistas;

public class MarioInvulnerable extends EstadoMario {
    private EstadoMario estadoAnterior;

	public MarioInvulnerable(Personaje p, EstadoMario e) {
		super(p);
        this.estadoAnterior = e;

		personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE/2);

		actualizarSprite();
        personaje.getObserver().actualizarImagen();

		new Thread(() -> {
			try {
				Thread.sleep(ConstantesEstados.TIEMPO_INVULNERABLE * 1000); 
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			personaje.setEstado(this.estadoAnterior);
			personaje.getEntidadSonora().iniciarLoopMario();
			personaje.setPosicionY(personaje.getY() + ConstantesVistas.TAMANO_BLOQUE/2);
			
		}).start();
	}

	@Override
	public void setDerecha(boolean d, boolean i) {
    	derecha = d;
        izquierda = i;
        actualizarSprite();
    }

	@Override
	public void setIzquierda(boolean d, boolean i) {
    	derecha = d;
        izquierda = i;
        actualizarSprite();
	}

	private void actualizarSprite() {
        Sprite spriteAsignar = null;

        if (!personaje.estaEnElAire()) {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-quieto-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-quieto-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-movimiento-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-movimiento-izquierda");
            }
        } else {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-izquierda");
            }
        }
        
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

	@Override
	public void actualizarAlCaer(boolean derecha,boolean izquierda){
		this.derecha = derecha;
        this.izquierda = izquierda;
        Sprite spriteAsignar = null;
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-movimiento-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-movimiento-izquierda");
        } else {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-quieto-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

	@Override
	public void lanzarBolaDeFuego() {
		//No hace nada porque el enunciado es aburrido
	}

	public void saltar(boolean derecha, boolean izquierda) {
		this.derecha = derecha;
        this.izquierda = izquierda;
        personaje.setVelocidadY(ConstantesEstados.SALTO_MARIO_SUPER);
        actualizarSpriteSaltar();
    }

	private void actualizarSpriteSaltar() {
        Sprite spriteAsignar = null;
        
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marioestrella-saltando-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

	@Override
	public void serAfectadoPor(Estrella estrella) {
		personaje.setPuntaje(35);
	}

	@Override
	public void serAfectadoPor(FlorDeFuego florDeFuego) {
		personaje.setPuntaje(5);
	}

	@Override
	public void serAfectadoPor(SuperChampignon superChampignon) {
		personaje.setPuntaje(10);
	}

	@Override
	public void serAfectadoPor(BuzzyBeetle buzzyBeetle) {
		this.AfectarA(buzzyBeetle);
        buzzyBeetle.desaparecer();
	}

	@Override
	public void serAfectadoPor(Spiny spiny) {
		this.AfectarA(spiny);
        spiny.desaparecer();
	}

	@Override
	public void serAfectadoPor(Lakitu lakitu) {
		this.AfectarA(lakitu);
        lakitu.desaparecer();
	}

	@Override
	public void serAfectadoPor(PiranhaPlant piranhaPlant) {
		this.AfectarA(piranhaPlant);
        piranhaPlant.desaparecer();
	}

	@Override
	public void serAfectadoPor(KoopaTroopa koopaTroopa) {
		this.AfectarA(koopaTroopa);
        koopaTroopa.desaparecer();
	}

	@Override
	public void serAfectadoPor(Goomba goomba) {
		this.AfectarA(goomba);
        goomba.desaparecer();
	}

	@Override
	public void AfectarA(LadrilloSolido ladrillo) {
		
	}
}
