package controller;

import asteroids.Asteroid;
import graphics.*;
import shoots.Shoot;

import java.util.Collection;

public class VisitorContador extends Visitor {

    protected int cantAsteroides;
    protected Collection<GraphicObject> objects;

    public VisitorContador(Collection<GraphicObject> objects) {
        cantAsteroides = 0;
        this.objects = objects;
    }

    public void visit(Asteroid a) {
        cantAsteroides++;
    }

    public int cantidadAsteroides() {
        return cantAsteroides;
    }


    public void visit(PlayerShip ps){}
    public void visit(Shoot s){}

    public void reset() {
        cantAsteroides = 0;
    }
}
