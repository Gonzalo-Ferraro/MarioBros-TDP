package Logica.Entidades;

import java.util.HashMap;
import java.util.Map;

public class EntidadGrafica {
    protected Map<String, Sprite> mapeoSprites;

    public EntidadGrafica(){
        mapeoSprites = new HashMap<>();
    }

    public void setSprite(String nombreSprite, Sprite sprite){
        mapeoSprites.put(nombreSprite, sprite);
    }

    public Sprite getSprite(String nombreSprite){
        return mapeoSprites.get(nombreSprite);
    }
}
