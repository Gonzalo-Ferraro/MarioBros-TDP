package Logica.Entidades;

public class BloqueDePregunta extends BloqueSolido {

    protected PowerUp miPowerUp;

    public BloqueDePregunta(int x, int y, Sprite s){
        super(x, y, s);
    }

    //falta ser afectado por
    public void serAfectadoPor(Personaje p){
        
        if(miPowerUp != null){
            this.sprite= entidadGrafica.getSprite("bloque-pregunta-vacio");
            miPowerUp.afectarAMario(p);
            miPowerUp = null;
            this.observador.actualizarImagen();
        }
    }

    public void setPowerUp(PowerUp p){
        miPowerUp = p;
    }
}
