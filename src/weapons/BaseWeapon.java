package weapons;

import shoots.Shoot;
import shoots.SimpleShoot;

public class BaseWeapon extends Weapon {

    public BaseWeapon(int dmg, double angulo) {
        super(dmg, angulo);
    }

    public Shoot createShoot(int x, int y) {
        return new SimpleShoot(x, y, angulo, damage);
    }
}
