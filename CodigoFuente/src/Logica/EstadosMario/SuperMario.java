package Logica.EstadosMario;

import Logica.Entidades.*;
import Vistas.ConstantesVistas;

public class SuperMario extends EstadoMario {
    
    public SuperMario(Personaje p) {
        super(p);
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        actualizarSprite();
        personaje.getObserver().actualizarImagen();
    }
    
    @Override
    public void serAfectadoPor(Goomba g) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

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
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-quieto-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-quieto-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-movimiento-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-movimiento-izquierda");
            }
        } else {
            if (!derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-derecha");
            } else if (derecha && izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-izquierda");
            } else if (derecha && !izquierda) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-derecha");
            } else if (izquierda && !derecha) {
                spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-izquierda");
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
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-movimiento-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-movimiento-izquierda");
        } else {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-quieto-derecha");
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
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-derecha");
        } else if (izquierda) {
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-izquierda");
        }else{
            spriteAsignar = personaje.getEntidadGrafica().getSprite("mariosuper-saltando-derecha");
        }
        personaje.setSprite(spriteAsignar);
        personaje.getObserver().actualizarImagen();
    }

    @Override
    public void serAfectadoPor(SuperChampignon s) {
        personaje.setPuntaje( 50);
    }

    @Override
    public void serAfectadoPor(KoopaTroopa k) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

    @Override
    public void serAfectadoPor(PiranhaPlant p) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

    @Override
    public void serAfectadoPor(Lakitu l) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

    @Override
    public void serAfectadoPor(Spiny s) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

    @Override
    public void serAfectadoPor(BuzzyBeetle b) {
        personaje.setEstado(new MarioNormal(personaje)); 
        personaje.setPosicionY(personaje.getY() - ConstantesVistas.TAMANO_BLOQUE);
        personaje.retroceder();
    }

    @Override
    public void serAfectadoPor(FlorDeFuego f) {
       
    }

    @Override
    public void serAfectadoPor(Estrella e) {
        personaje.setPuntaje(30);
        personaje.getEntidadSonora().reproducirSonido("estrella");
        personaje.setEstado(new MarioInvulnerable(personaje, this));
    }

    @Override
    public void AfectarA(Goomba g) {
    }

    @Override
    public void AfectarA(KoopaTroopa k) {
        
    }

    @Override
    public void AfectarA(PiranhaPlant p) {
        
    }

    @Override
    public void AfectarA(Lakitu l) {
        
    }

    @Override
    public void AfectarA(Spiny s) {
        
    }

    @Override
    public void AfectarA(BuzzyBeetle b) {
        
    }

    @Override
    public void AfectarA(BloqueDePregunta bloq) {
        bloq.serAfectadoPor(personaje);
    }

    @Override
    public void AfectarA(LadrilloSolido ladrillo) {
        ladrillo.desaparecer();
    }

    

    
    

}
