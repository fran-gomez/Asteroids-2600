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
        frame.getContentPane().setBackground(Color.blue);

        buildStartScreen();

        frame.pack();
        frame.setVisible(true);
    }

    private static void buildStartScreen() {

        JButton iniciar = crearBoton("Iniciar");
        JButton puntajes = crearBoton("Puntajes");
        JButton creditos = crearBoton("Creditos");
        JButton salir = crearBoton("Salir");


        iniciar.addActionListener(new iniciarJuego());


        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.black);
        panelBotones.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelBotones.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelBotones.add(iniciar);
        panelBotones.add(puntajes);
        panelBotones.add(creditos);
        panelBotones.add(salir);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panelBotones);
    }

    private static JButton crearBoton(String label) {
        JButton boton = new JButton(label);
        boton.setPreferredSize(new Dimension(150,75));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setAlignmentY(Component.CENTER_ALIGNMENT);
        return boton;
    }

    private static void startGame(JFrame frame) {
        Score score = new Score();
        Map map = new Map(score);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(score);
        frame.getContentPane().add(map);
        map.requestFocus();
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
