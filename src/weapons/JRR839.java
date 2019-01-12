package weapons;

import shoots.Shoot;
import shoots.LaserShoot;

public class JRR839 extends Weapon {

    public JRR839(int dmg, double angulo) {
        super(dmg, angulo);
    }

    @Override
    public Shoot createShoot(int x, int y) {
        return new LaserShoot(x, y, angulo, damage);
    }
}
