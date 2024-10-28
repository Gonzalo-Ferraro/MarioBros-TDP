package Logica.Entidades;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Lakitu extends Enemigo {
    private static final int TIEMPO_SPINY = 10;

    private List<Spiny> spinys;
    private boolean lanzando = false;

    int tiempoDesdeUltimoSpiny;

    public Lakitu(int x, int y, Sprite s){
        super(x, y, s);
        spinys = new Stack<Spiny>();
        tiempoDesdeUltimoSpiny = 0;
        lanzando = false;
    }

    public void agregarSpiny(Spiny s){
        spinys.add(s);
    }

    public List<Spiny> getSpinys(){
        return spinys;
    }

    @Override
    public void serAfectadoPor(Personaje p) {
        if (!lanzando) {
            p.AfectarA(this);
            desaparecer();
        }
    }

    @Override
    public void afectarAMario(Personaje p) {
        p.serAfectadoPor(this);
    }

    public void moverX() {
        super.moverX();

        if (tiempoDesdeUltimoSpiny > 2 * 60) {
            lanzando = false;

            if (direccion == -1)
               sprite = entidadGrafica.getSprite("lakitu-izquierda");
            else
                sprite = entidadGrafica.getSprite("lakitu-derecha");
                
            observador.actualizarImagen();
        }   
    }

    public void moverY() {
        tiempoDesdeUltimoSpiny++;
        if (tiempoDesdeUltimoSpiny == 60 * TIEMPO_SPINY) {
            Random random = new Random();

            if (random.nextInt(10) < 3 && !spinys.isEmpty())
                tirarSpiny();

            tiempoDesdeUltimoSpiny = 0;
        }
    }

    private void tirarSpiny() {
        lanzando = true;

        sprite = entidadGrafica.getSprite("lakitu-lanzando");
        observador.actualizarImagen();

        Spiny s = spinys.remove(0);
        s.aparecer(x, y);
    }
}
