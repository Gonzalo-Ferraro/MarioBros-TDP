package Logica.Entidades;

import javax.swing.ImageIcon;

public class Sprite {

    protected String rutaImagen;
    private ImageIcon imagen;

    public Sprite (String rutaImagen) {
        this.rutaImagen = rutaImagen;
        imagen = new ImageIcon(rutaImagen);
    }

    public String get_ruta_imagen() {
        return rutaImagen;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
}