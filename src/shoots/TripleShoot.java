package shoots;

import controller.Visitor;

public class TripleShoot extends Shoot {

    public TripleShoot(int x, int y, double angulo, int dmg) {
        super(x, y, angulo, dmg);
    }

    @Override
    public String getGraphicsPath() {
        return null;
    }

    @Override
    public void die() {

    }

    @Override
    public void accept(Visitor v) {

    }
}
