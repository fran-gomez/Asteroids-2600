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
    public abstract Point nextPosition(); // Devuelve el proximo punto que ocupara el asteroide
}
