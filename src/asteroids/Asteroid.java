package asteroids;

import controller.LinearMovement;
import controller.MovementStrategy;
import controller.Visitor;
import graphics.GraphicObject;
import graphics.PlayerShip;
import resources.Constantes;
import shoots.Shoot;

import java.util.Random;

public abstract class Asteroid extends GraphicObject {

    // << Atributos >>
    protected int lifePoints;   // Puntos de vida
    protected int impactPoints; // Daño por choque

    protected MovementStrategy mov; // Controlador de posicion

    // << Constructor >>
    public Asteroid(int lp, int ip) {
        // Ponemos el asteroide en una posicion aleatoria del mapa
        super(MyRandom.nextInt(Constantes.ANCHO_VENTANA), MyRandom.nextInt(Constantes.ALTO_VENTANA));

        this.lifePoints = lp;
        this.impactPoints = ip;

        this.mov = new LinearMovement(this);
    }

    // << Consultas >>
    public int getLifePoints() {
        return lifePoints;
    }

    // << Comandos >>
    public void move() {
        // Calculamos la proxima posicion del asteroide, y lo movemos
        this.position = mov.nextPosition();
        super.move();
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public void receiveDamage(int dmg) {
        this.lifePoints -= dmg;
    }

    public void colisionar(PlayerShip ps) {
        ps.receiveDamage(impactPoints);
    }

    public void colisionar(Shoot s) {
        s.die();
    }

    public void colisionar(Asteroid a){}

    public abstract Asteroid clone();


    // Generador de numeros estatico
    private static class MyRandom {

        public static int nextInt(int max) {
            Random r = new Random(System.currentTimeMillis());

            return r.nextInt(max);
        }
    }
}
