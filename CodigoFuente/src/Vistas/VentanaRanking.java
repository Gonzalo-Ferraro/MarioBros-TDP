package Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Datos.Ranking.Jugador;
import Datos.Ranking.Ranking;

public class VentanaRanking extends JFrame {
    private Ranking ranking;
    private JPanel panelRanking;

    public VentanaRanking(Ranking ranking) {
        super("Ranking");
        this.ranking = ranking;

        configurarPantalla();
        agregarEtiquetas();
    }

    private void configurarPantalla() {
        setSize(ConstantesVistas.VENTANA_RANKING_ANCHO, ConstantesVistas.VENTANA_RANKING_ALTO);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelRanking = new JPanel();
        panelRanking.setLayout(null);
        panelRanking.setSize(ConstantesVistas.VENTANA_RANKING_ANCHO, ConstantesVistas.VENTANA_RANKING_ALTO);
        panelRanking.setVisible(true);

        panelRanking.setBackground(new Color(79, 128, 248));

        setContentPane(panelRanking);

        setVisible(true);
    }

    public void agregarEtiquetas() {
        int posicion = 1;
        for (Jugador jugador : ranking.getJugadores()) {
            agregarEtiqueta(jugador, posicion);
            posicion++;
        }
    }

    public void agregarEtiqueta(Jugador jugador, int posicion) {
        JLabel etiquetaContorno = new JLabel(jugador.getNombre() + " - " + jugador.getPuntaje(), SwingConstants.CENTER);
        JLabel etiqueta = new JLabel(jugador.getNombre() + " - " + jugador.getPuntaje(), SwingConstants.CENTER);

        try {
            Font fuenteContorno = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(ConstantesVistas.RUTA_FUENTE)).deriveFont(Font.BOLD, 22f);

            etiquetaContorno.setFont(fuenteContorno);
            etiqueta.setFont(fuente);

            etiquetaContorno.setForeground(Color.BLACK);
            etiqueta.setForeground(Color.WHITE);

            int espacio = 50;
            etiquetaContorno.setBounds(5, 50 * posicion + espacio * (posicion - 1), ConstantesVistas.VENTANA_RANKING_ANCHO, 60);
            etiqueta.setBounds(0, 50 * posicion + espacio * (posicion - 1), ConstantesVistas.VENTANA_RANKING_ANCHO, 60);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        etiquetaContorno.setAlignmentX(CENTER_ALIGNMENT);
        etiqueta.setAlignmentX(CENTER_ALIGNMENT);

        panelRanking.add(etiqueta);
        panelRanking.add(etiquetaContorno);

        panelRanking.revalidate();
        panelRanking.repaint();
    }
}
