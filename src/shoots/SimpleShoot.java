package shoots;

public class SimpleShoot extends Shoot {
    public SimpleShoot(int x, int y, int dmg) {
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
