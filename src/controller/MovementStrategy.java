package controller;

import java.awt.*;

public abstract class MovementStrategy {

    // << Atributos >>
    protected Point movementDirection; // Vector unitario que indica el angulo de movimiento

    // << Constructor >>
    public MovementStrategy() {
        movementDirection = new Point(0,0);
    }

    // << Consultas >>
    public abstract Point nextPosition(double deltaX, double deltaY); // Devuelve el proximo punto que ocupara el asteroide
}
