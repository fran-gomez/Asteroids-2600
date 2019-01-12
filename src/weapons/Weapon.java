package weapons;

import shoots.Shoot;

public abstract class Weapon {

    // << Atributos >>
    protected int damage; // Daño maximo de los disparos
    protected double angulo; // Angulo de rotacion del disparo

    // << Constructor >>
    public Weapon(int dmg, double angulo) {
        this.damage = dmg;
        this.angulo = angulo;
    }

    // << Comandos >>
    public abstract Shoot createShoot(int x, int y); // Crea un disparon con un daño entre (0; damage]

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
}
