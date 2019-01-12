package shoots;

public class LaserShoot extends Shoot {

    public LaserShoot(int x, int y, double angulo, int dmg) {
        super(x, y, angulo, dmg);
    }

    @Override
    public String getGraphicsPath() {
        return null;
    }

    @Override
    public void die() {

    }
}
