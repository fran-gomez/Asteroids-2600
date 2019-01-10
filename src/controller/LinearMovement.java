package controller;

import asteroids.Asteroid;

import java.awt.*;
import java.util.Random;

public class LinearMovement extends MovementStrategy {

    protected Asteroid miAsteroide;

    public LinearMovement(Asteroid miAsteroide) {
        this.miAsteroide = miAsteroide;
    }

    @Override
    public Point nextPosition() {

        Random rnd = new Random();

        int nuevoX = miAsteroide.getX();
        int nuevoY = miAsteroide.getY();

        if (rnd.nextBoolean()) { // Muevo en x e y
            nuevoX += 30;
            nuevoY += 30;
        } else { // Muevo en x o en y
            if (rnd.nextBoolean())
                nuevoX += 30;
            else
                nuevoY += 30;
        }


        return new Point(nuevoX, nuevoY);
    }
}
