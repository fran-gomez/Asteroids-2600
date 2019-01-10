package graphics;

import resources.Constantes;

import javax.swing.*;
import java.awt.*;


public class Game {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        JFrame frame = new JFrame();
        Score score = new Score();
        Map map = new Map(score);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(score);
        frame.getContentPane().add(map);

        frame.setPreferredSize(new Dimension(Constantes.ANCHO_VENTANA,Constantes.ALTO_VENTANA));

        frame.pack();
        frame.setVisible(true);

    }
}
