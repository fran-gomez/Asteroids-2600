package graphics;

import resources.Constantes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game {

    protected static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame();

        frame.setPreferredSize(new Dimension(Constantes.ANCHO_VENTANA,Constantes.ALTO_VENTANA));

        buildStartScreen(frame);

        frame.pack();
        frame.setVisible(true);
    }

    private static void buildStartScreen(JFrame frame) {

        JButton iniciar = crearBoton("Iniciar");
        JButton puntajes = crearBoton("Puntajes");
        JButton creditos = crearBoton("Creditos");
        JButton salir = crearBoton("Salir");
        JPanel panelBotones = new JPanel();

        iniciar.addActionListener(new iniciarJuego());

        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(iniciar);
        panelBotones.add(puntajes);
        panelBotones.add(creditos);
        panelBotones.add(salir);

        frame.setLayout(new BorderLayout());
        frame.add(panelBotones, BorderLayout.CENTER);
    }

    private static JButton crearBoton(String label) {
        JButton boton = new JButton(label);
        boton.setPreferredSize(new Dimension(150,75));
        return boton;
    }

    private static void startGame(JFrame frame) {
        Score score = new Score();
        Map map = new Map(score);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(score);
        frame.getContentPane().add(map);
    }

    private static class iniciarJuego implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            for (Component c: frame.getContentPane().getComponents()) {
                frame.remove(c);
            }

            startGame(frame);
        }
    }
}
