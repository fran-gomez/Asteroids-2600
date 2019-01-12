package shoots;

import asteroids.Asteroid;
import controller.Visitor;
import graphics.GraphicObject;
import graphics.PlayerShip;

public abstract class Shoot extends GraphicObject {

    // << Atributos >>
    protected int damage;    // Daño del disparo
    protected double angulo; // Angulo de rotacion del proyectil

    // << Constructor >>
    public Shoot(int x, int y, double angulo, int dmg) {
        super(x, y);
        this.damage = dmg;

        this.angulo = angulo;
        this.deltaX = Math.sin(angulo);
        this.deltaY = Math.cos(angulo);
    }

    // << Consultas >>
    public int getLifePoints() {
        return 1;
    }

    // << Comandos >>
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void colisionar(Asteroid a) {
        a.receiveDamage(damage);
    }

    public void colisionar(Shoot s){}
    public void colisionar(PlayerShip ps){}

    protected void moverAdelante() {
        this.position.x += 5*deltaX;
        this.position.y -= 5*deltaY;
    }
}
