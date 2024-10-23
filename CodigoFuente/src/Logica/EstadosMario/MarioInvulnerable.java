package Logica.EstadosMario;

import Logica.Entidades.*;

public class MarioInvulnerable extends EstadoMario {
    private EstadoMario estadoAnterior;

	public MarioInvulnerable(Personaje p, EstadoMario e) {
		super(p);
        this.estadoAnterior = e;
		
		new Thread(() -> {
			try {
				Thread.sleep(ConstantesEstados.TIEMPO_INVULNERABLE * 1000); 
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			personaje.setEstado(this.estadoAnterior);
			personaje.getJuego().getEntidadSonora().iniciarLoopMario();
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
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
            }
        } else {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
            }
        }
        
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }
	public void actualizarAlCaer(boolean derecha,boolean izquierda){
        this.derecha = derecha;
        this.izquierda = izquierda;
        Sprite spriteAsignar = null;
        if (derecha) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-movimiento-izquierda");
        } else {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-quieto-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
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
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("marionormal-saltando-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

	@Override
	public void serAfectadoPor(Estrella estrella) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(FlorDeFuego florDeFuego) {
		// Implementation here
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
	public void serAfectadoPor(SuperChampignon superChampignon) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(Goomba goomba) {
		this.AfectarA(goomba);
        goomba.desaparecer();
	}

	@Override
	public void AfectarA(LadrilloSolido ladrilloSolido) {
		// Implementation here
	}

	@Override
	public void AfectarA(BloqueDePregunta bloqueDePregunta) {
		// Implementation here
	}

	@Override
	public void AfectarA(BuzzyBeetle buzzyBeetle) {
		// Implementation here
	}

	@Override
	public void AfectarA(Spiny spiny) {
		// Implementation here
	}

	@Override
	public void AfectarA(Lakitu lakitu) {
		// Implementation here
	}

	@Override
	public void AfectarA(PiranhaPlant piranhaPlant) {
		// Implementation here
	}

	@Override
	public void AfectarA(KoopaTroopa koopaTroopa) {
		// Implementation here
	}

	@Override
	public void AfectarA(Goomba goomba) {
		// Implementation here
	}

	
	
}
