package controller;

import asteroids.Asteroid;
import graphics.GraphicObject;
import graphics.PlayerShip;
import shoots.Shoot;

public class VisitorColision extends Visitor {

    protected GraphicObject objetoColisionado;

    public VisitorColision(GraphicObject go) {
        objetoColisionado = go;
    }

    @Override
    public void visit(PlayerShip ps) {
        objetoColisionado.colisionar(ps);
    }

    @Override
    public void visit(Asteroid a) {
        objetoColisionado.colisionar(a);
    }

    @Override
    public void visit(Shoot s) {
        objetoColisionado.colisionar(s);
    }
}
