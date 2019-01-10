package graphics;

import resources.Constantes;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Score extends JPanel {

    // TODO Agregar el archivo con los puntajes ordenados de forma decreciente
    protected JLabel scoreLabel;
    protected int score;

    public Score() {
        super();

        score = 0;
        scoreLabel = new JLabel("Score: " + score + " (P)ause, (R)esume, (Q)uit");

        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(Constantes.ANCHO_VENTANA,30));
        this.setBackground(Color.black);
        this.setForeground(Color.white);
        this.add(scoreLabel);
    }

    public void add(int s) {
        this.score += s;
        scoreLabel.setText("Score: " + score + " (P)ause, (R)esume, (Q)uit");
    }

    public void saveScore() {

    }
}
