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
    public Point nextPosition(double deltaX, double deltaY) {

        Random rnd = new Random();

        int nuevoX = miAsteroide.getX();
        int nuevoY = miAsteroide.getY();

        if (rnd.nextBoolean()) { // Muevo en x e y
            nuevoX += miAsteroide.getSpeedPoints()*deltaX;
            nuevoY += miAsteroide.getSpeedPoints()*deltaY;
        } else { // Muevo en x o en y
            if (rnd.nextBoolean())
                nuevoX += miAsteroide.getSpeedPoints()*deltaX;
            else
                nuevoY += miAsteroide.getSpeedPoints()*deltaY;
        }


        return new Point(nuevoX, nuevoY);
    }
}
