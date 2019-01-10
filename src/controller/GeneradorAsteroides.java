package controller;

import asteroids.Asteroid;
import asteroids.MultipleAsteroid;
import asteroids.SimpleAsteroid;
import asteroids.UFO;
import graphics.GraphicObject;

import java.util.Collection;
import java.util.Random;

// Responsabilidad: Generar los tres tipos de asteroides de forma aleatoria para la instancia del nivel actual
public class GeneradorAsteroides {

    protected Asteroid simpleProto;
    protected Asteroid multiProto;
    protected Asteroid ufoProto;

    protected int dificultad; // Ajusta la cantidad de asteroides que se generan

    public GeneradorAsteroides(Asteroid sa, Asteroid ma, Asteroid u) {
        simpleProto = sa;
        multiProto  = ma;
        ufoProto    = u;

        dificultad = 1;
    }

    public void populateList(Collection<GraphicObject> objects) {

        int amountOfAsteroids = dificultad + 3 * (dificultad % 10);

        for (int i = 0; i < amountOfAsteroids; i++) {
            objects.add(getRandomAsteroid());
        }
    }

    public void nextWave(Collection<GraphicObject> objects) {

        dificultad++;
        populateList(objects);
    }

    private Asteroid getRandomAsteroid() {

        Asteroid nuevo;
        Random rn = new Random(System.currentTimeMillis());

        switch (rn.nextInt(10)) {
            case 0:
                nuevo = new UFO(35, 12);
                break;
            case 1: case 2: case 3:
                nuevo = new MultipleAsteroid(15, 30);
                break;
            case 4: case 5: case 6:
            case 7: case 8: case 9:
                nuevo = new SimpleAsteroid(20, 10);
                break;
            default:
                System.err.println("A ver... que paso?");
                nuevo = null;
        }

        return nuevo;
    }
}
