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
			personaje.getEntidadSonora().iniciarLoopMario();
			personaje.setPosicionY(personaje.getY()-40);
			
		}).start();

	}
	

	@Override
	public void setDerecha(boolean d, boolean i) {
        estadoAnterior.setDerecha(d, i);
    }

	@Override
	public void setIzquierda(boolean d, boolean i) {
       estadoAnterior.setIzquierda(d, i);
    }

	@Override
	public void actualizarAlCaer(boolean derecha,boolean izquierda){
      estadoAnterior.actualizarAlCaer(derecha, izquierda);
    }

	public void saltar(boolean derecha, boolean izquierda) {
      estadoAnterior.saltar(derecha, izquierda);
    }

	@Override
	public void serAfectadoPor(Estrella estrella) {
		personaje.setPuntaje(35);
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
