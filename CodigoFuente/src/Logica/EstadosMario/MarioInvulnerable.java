package Logica.EstadosMario;

import Logica.Entidades.*;
import Logica.Fabricas.ModoDeJuego;

public class MarioInvulnerable extends EstadoMario {
    private EstadoMario estadoAnterior;

	public MarioInvulnerable(Personaje p, EstadoMario e) {
		super(p);
        this.estadoAnterior = e;
	}

	@Override
	public void setDerecha(boolean d, boolean i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setDerecha'");
	}

	@Override
	public void actualizarAlCaer(boolean derecha, boolean izquierda) {
		estadoAnterior.actualizarAlCaer(derecha, izquierda);
	}

	@Override
	public void setIzquierda(boolean d, boolean i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setIzquierda'");
	}

	@Override
	public void saltar(boolean derecha, boolean izquierda) {
		estadoAnterior.saltar(derecha, izquierda);
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
		// Implementation here
	}

	@Override
	public void serAfectadoPor(Spiny spiny) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(Lakitu lakitu) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(PiranhaPlant piranhaPlant) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(KoopaTroopa koopaTroopa) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(SuperChampignon superChampignon) {
		// Implementation here
	}

	@Override
	public void serAfectadoPor(Goomba goomba) {
		// Implementation here
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
