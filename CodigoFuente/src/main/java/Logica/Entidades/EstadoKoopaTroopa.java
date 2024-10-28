package Logica.Entidades;

public interface EstadoKoopaTroopa {
    public void serAfectadoPor(Personaje p);
    public Sprite moverX();
    public void cambiarDireccion();
    public void setEntidadGrafica(EntidadGrafica e);
    
    

}
