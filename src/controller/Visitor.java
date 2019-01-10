package controller;

import asteroids.Asteroid;
import graphics.PlayerShip;
import shoots.Shoot;

public abstract class Visitor {

    public abstract void visit(PlayerShip ps);
    public abstract void visit(Asteroid a);
    public abstract void visit(Shoot s);
}
