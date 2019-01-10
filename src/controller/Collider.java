package controller;

import graphics.GraphicObject;

import java.util.Collection;

// Responsabilidad: Verificar la colision entre dos objetos graficos del mapa
public class Collider {

    protected Collection<GraphicObject> objectsToColide;

    public Collider(Collection<GraphicObject> objects) {

        this.objectsToColide = objects;
    }

    public synchronized void checkCollisions() {

        for (GraphicObject o1: objectsToColide) {
            for (GraphicObject o2 : objectsToColide) {
                if (!o1.equals(o2) && o1.intersects(o2))
                    o1.accept(new VisitorColision(o2));


                if (o2.getLifePoints() <= 0)
                    o2.die();
            }

            if (o1.getLifePoints() <= 0)
                o1.die();
        }
    }
}
