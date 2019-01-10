package weapons;

import shoots.Shoot;

public abstract class Weapon {

    // << Atributos >>
    protected int damage; // Daño maximo de los disparos

    // << Constructor >>
    public Weapon(int dmg) {
        damage = dmg;
    }

    // << Comandos >>
    public abstract Shoot createShoot(int x, int y); // Crea un disparon con un daño entre (0; damage]
}
