package Logica.Fabricas;
import Logica.Entidades.*;

public abstract class ModoDeJuego {
    protected String ruta;

    protected ModoDeJuego(String ruta){
        this.ruta = ruta;
    }

    public SuperChampignon crearSuperChampignon(int x, int y){
        Sprite spriteSuperChampignon = new Sprite(ruta + "/superChampignon.png");
        SuperChampignon toReturn = new SuperChampignon(x, y, spriteSuperChampignon);
        return toReturn;
    }

    
}
