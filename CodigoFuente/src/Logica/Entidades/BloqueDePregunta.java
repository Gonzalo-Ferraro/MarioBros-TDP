package Logica.Entidades;

public class BloqueDePregunta extends BloqueSolido {

    protected PowerUp miPowerUp;
    private int powerUpx;
    private int powerUpy;

    public BloqueDePregunta(int x, int y, Sprite s,PowerUp pw){
        super(x, y, s);
        miPowerUp = pw;
            
    }

    //falta ser afectado por
    public void serAfectadoPor(Personaje p){
        
        if(miPowerUp != null){
            miPowerUp.afectarAMario(p);
            miPowerUp.desaparecer();
            miPowerUp = null;    
        }
        if(sprite != entidadGrafica.getSprite("bloque-pregunta-vacio")){
            this.sprite= entidadGrafica.getSprite("bloque-pregunta-vacio");
            this.observador.actualizarImagen();
        }

    }

    public PowerUp getPowerUp(){
        return miPowerUp;
    }

    
}
