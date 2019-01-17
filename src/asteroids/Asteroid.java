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
    protected int speedPoints;  // Velocidad de movimiento

    protected MovementStrategy mov; // Controlador de posicion

    // << Constructor >>
    public Asteroid(int lp, int ip) {
        // Ponemos el asteroide en una posicion aleatoria del mapa
        super(MyRandom.nextInt(Constantes.ANCHO_VENTANA), MyRandom.nextInt(Constantes.ALTO_VENTANA));

        this.lifePoints = lp;
        this.impactPoints = ip;
        this.speedPoints = MyRandom.nextInt(5);

        this.mov = new LinearMovement(this);
        this.deltaX = getDeltaX(this.position.x);
        this.deltaY = getDeltaY(this.position.y);
    }

    // << Consultas >>
    public int getLifePoints() {
        return lifePoints;
    }
    public int getSpeedPoints() {
        return speedPoints;
    }

    // << Comandos >>
    public void move() {
        // Calculamos la proxima posicion del asteroide, y lo movemos
        this.position = mov.nextPosition(deltaX, deltaY);
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
        deltaX = -deltaX;
        deltaY = -deltaY;
    }

    public void colisionar(Shoot s) {
        s.die();
    }

    public void colisionar(Asteroid a){}

    public abstract Asteroid clone();


    private int getDeltaX(int ancho) {
        if (ancho <= Constantes.ANCHO_VENTANA/2)
            return 1;
        else
            return -1;
    }

    private int getDeltaY(int alto) {
        if (alto <= Constantes.ALTO_MAPA/2)
            return 1;
        else
            return -1;
    }

    // Generador de numeros estatico
    private static class MyRandom {

        public static int nextInt(int max) {
            Random r = new Random(System.currentTimeMillis());
            int valor = r.nextInt(max);

            if (valor > 0)
                return valor;
            else
                return r.nextInt(max);
        }
    }
}
