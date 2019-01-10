package shoots;

import asteroids.Asteroid;
import controller.Visitor;
import graphics.GraphicObject;
import graphics.PlayerShip;

public abstract class Shoot extends GraphicObject {

    // << Atributos >>
    protected int damage; // Daño del disparo

    // << Constructor >>
    public Shoot(int x, int y, int dmg) {
        super(x, y);
        this.damage = dmg;
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
}
