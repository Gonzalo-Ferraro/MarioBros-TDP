package Logica.Entidades;

import Vistas.ConstantesVistas;

public class BloqueDePregunta extends BloqueSolido {

    protected PowerUp miPowerUp;

    public BloqueDePregunta(int x, int y, Sprite s){
        super(x, y, s);            
    }

    @Override
    public void serAfectadoPor(Personaje p){
        
        if(miPowerUp != null){
            
            miPowerUp.aparecer(this.x + 5, this.y - ConstantesVistas.TAMANO_BLOQUE + 20);
            miPowerUp = null;    
        }
        if(sprite != entidadGrafica.getSprite("bloque-pregunta-vacio")){
            this.sprite = entidadGrafica.getSprite("bloque-pregunta-vacio");
            this.observador.actualizarImagen();
        }

    }

    public PowerUp getPowerUp(){
        return miPowerUp;
    }

    public void setPowerUp(PowerUp p){
        miPowerUp = p;
    }
    
    
}
