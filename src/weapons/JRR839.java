package weapons;

import shoots.Shoot;
import shoots.LaserShoot;

public class JRR839 extends Weapon {

    public JRR839(int dmg) {
        super(dmg);
    }

    @Override
    public Shoot createShoot(int x, int y) {
        return new LaserShoot(x, y, damage);
    }
}
