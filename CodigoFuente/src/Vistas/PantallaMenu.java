package Vistas;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Logica.Fabricas.ModoBarbie;
import Logica.Fabricas.ModoOriginal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PantallaMenu extends JPanel {
    private ControladorVistas controladorVistas;
    private final String rutaFondo = "/Datos/sprites/menu.jpeg";
    private Image imagenFondo;
    private JButton modoNormal;
    private JButton modoBarbie;
    private JButton botonRanking;
    private JLabel labelRankingContorno;
    private JLabel labelRanking;

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
        agregarBotonesModos();
        agregarLabelRanking();
        agregarBotonRanking();
        agregarOyentes();
    }

    private void agregarOyentes() {
        agregarOyenteBotonNormal();
        agregarOyenteBotonBarbie();
        agregarOyenteBotonRanking();
    }

    private void agregarBotonesModos() {
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
        
        modoNormal.setEnabled(true);
        modoBarbie.setEnabled(true);
        // Agregar los botones al panel
        add(modoNormal);
        add(modoBarbie);
    }

    private void agregarLabelRanking() {
        labelRankingContorno = new JLabel("Ranking", SwingConstants.CENTER);
        labelRanking = new JLabel("Ranking", SwingConstants.CENTER);

        try {
            Font fuenteContorno = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);

            labelRankingContorno.setFont(fuenteContorno);
            labelRanking.setFont(fuente);

            labelRankingContorno.setForeground(Color.BLACK);
            labelRanking.setForeground(Color.WHITE);

            labelRankingContorno.setBounds(5, 480, ConstantesVistas.PANEL_ANCHO, 60);
            labelRanking.setBounds(0, 480, ConstantesVistas.PANEL_ANCHO, 60);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        labelRankingContorno.setAlignmentX(CENTER_ALIGNMENT);
        labelRanking.setAlignmentX(CENTER_ALIGNMENT);

        add(labelRanking);
        add(labelRankingContorno);
    }

    private void agregarBotonRanking() {
        botonRanking = new JButton();
        botonRanking.setBounds(550, 480, 180, 60);
        botonRanking.setContentAreaFilled(false);
        botonRanking.setOpaque(false);
        botonRanking.setBorderPainted(false);
        botonRanking.setEnabled(true);
        add(botonRanking);
    }

    private void agregarOyenteBotonNormal() {
        modoNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.accionarInicioJuego(new ModoOriginal());
            }
        });
    }

    private void agregarOyenteBotonBarbie() {
        modoBarbie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.accionarInicioJuego(new ModoBarbie());
            }
        });
    }

    private void agregarOyenteBotonRanking() {
        botonRanking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorVistas.mostrarRanking();
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
