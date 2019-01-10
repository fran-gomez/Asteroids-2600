package shoots;

public class LaserShoot extends Shoot {

    public LaserShoot(int x, int y, int dmg) {
        super(x, y, dmg);
    }

    @Override
    public String getGraphicsPath() {
        return null;
    }

    @Override
    public void die() {

    }
}
