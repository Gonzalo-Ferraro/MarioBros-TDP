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
    private final String rutaFondo = "/Datos/sprites/pantalla-menu.png";
    private Image imagenFondo;
    private JButton modoNormal;
    private JButton modoBarbie;
    private JButton botonRanking;
    private JLabel labelModoNormalContorno;
    private JLabel labelModoNormal;
    private JLabel labelModoBarbieContorno;
    private JLabel labelModoBarbie;
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
        agregarLabelsModos();
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
        modoNormal.setBounds(400, 330, 400, 60);
        modoBarbie.setBounds(400, 390, 400, 60);

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

    private void agregarLabelsModos() {
        labelModoNormalContorno = new JLabel("Modo Normal", SwingConstants.CENTER);
        labelModoNormal = new JLabel("Modo Normal", SwingConstants.CENTER);
        labelModoBarbieContorno = new JLabel("Modo Barbie", SwingConstants.CENTER);
        labelModoBarbie = new JLabel("Modo Barbie", SwingConstants.CENTER);

        try {
            Font fuenteContorno = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);

            labelModoNormalContorno.setFont(fuenteContorno);
            labelModoNormal.setFont(fuente);
            labelModoBarbieContorno.setFont(fuenteContorno);
            labelModoBarbie.setFont(fuente);

            labelModoNormalContorno.setForeground(Color.BLACK);
            labelModoNormal.setForeground(Color.WHITE);
            labelModoBarbieContorno.setForeground(Color.BLACK);
            labelModoBarbie.setForeground(Color.WHITE);

            labelModoNormalContorno.setBounds(5, 330, ConstantesVistas.PANEL_ANCHO, 60);
            labelModoNormal.setBounds(0, 330, ConstantesVistas.PANEL_ANCHO, 60);
            labelModoBarbieContorno.setBounds(5, 390, ConstantesVistas.PANEL_ANCHO, 60);
            labelModoBarbie.setBounds(0, 390, ConstantesVistas.PANEL_ANCHO, 60);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        labelModoNormalContorno.setAlignmentX(CENTER_ALIGNMENT);
        labelModoNormal.setAlignmentX(CENTER_ALIGNMENT);
        labelModoBarbieContorno.setAlignmentX(CENTER_ALIGNMENT);
        labelModoBarbie.setAlignmentX(CENTER_ALIGNMENT);

        add(labelModoNormal);
        add(labelModoNormalContorno);
        add(labelModoBarbie);
        add(labelModoBarbieContorno);
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

            labelRankingContorno.setBounds(5, 450, ConstantesVistas.PANEL_ANCHO, 60);
            labelRanking.setBounds(0, 450, ConstantesVistas.PANEL_ANCHO, 60);

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
        botonRanking.setBounds(550, 450, 180, 60);
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
