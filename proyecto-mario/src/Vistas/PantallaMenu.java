package Vistas;

import javax.swing.JPanel;

import Logica.Fabricas.ModoBarbie;
import Logica.Fabricas.ModoOriginal;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMenu extends JPanel {
    private ControladorVistas controladorVistas;
    private final String rutaFondo = "/Datos/sprites/menu.jpeg";
    private Image imagenFondo;
    private JButton modoNormal;
    private JButton modoBarbie;

    // DEBERIA TENER LA RUTA DEL MODO ORIGINAL Y MODO BARBIE
    String rutaOriginal = "x"; // LINEA 76
    String rutaBarbie = "x";   // LINEA 85

    // -------------------------------------------------------

    public PantallaMenu(ControladorVistas c) {
        super();

        controladorVistas = c;
        setLayout(null);
        
        crearFondo();
        agregarBotones();
    }

    private void crearFondo() {
        ImageIcon iconoImagen = new ImageIcon(getClass().getResource(rutaFondo));
        imagenFondo = iconoImagen.getImage();
    }

    private void agregarBotones() {
        // Crear los botones
        modoNormal = new JButton();
        modoBarbie = new JButton();

        // Establecer las posiciones y tamaños de los botones
        modoNormal.setBounds(400, 380, 400, 50);
        modoBarbie.setBounds(400, 430, 400, 50);

        modoNormal.setContentAreaFilled(false);
        modoBarbie.setContentAreaFilled(false);

        modoNormal.setOpaque(false);
        modoBarbie.setOpaque(false);

        modoNormal.setBorderPainted(false);
        modoBarbie.setBorderPainted(false);

        agregarOyenteBotonNormal();
        agregarOyenteBotonBarbie();
        
        modoNormal.setEnabled(true);
        modoBarbie.setEnabled(false);
        // Agregar los botones al panel
        add(modoNormal);
        add(modoBarbie);
    }

    private void agregarOyenteBotonNormal() {
        modoNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.accionarInicioJuego(new ModoOriginal(rutaOriginal));
            }
        });
    }

    private void agregarOyenteBotonBarbie() {
        modoBarbie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.accionarInicioJuego(new ModoBarbie(rutaBarbie));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el JPanel
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}
