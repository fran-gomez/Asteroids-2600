package weapons;

import shoots.Shoot;
import shoots.TripleShoot;

public class GBM614 extends Weapon {

    public GBM614(int dmg, double angulo) {
        super(dmg, angulo);
    }

    @Override
    public Shoot createShoot(int x, int y) {
        return new TripleShoot(x, y, angulo, damage);
    }
}