package controller;

import java.awt.*;
import java.util.Random;

public class RandomMovement extends MovementStrategy {
    @Override
    public Point nextPosition() {
        Random rnd = new Random();

        return new Point(rnd.nextInt(1820), rnd.nextInt(980));
    }
}
