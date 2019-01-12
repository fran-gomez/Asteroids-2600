package shoots;

public class LaserShoot extends Shoot {

    public LaserShoot(int x, int y, double angulo, int dmg) {
        super(x, y, angulo, dmg);
    }

    public String getGraphicsPath() {
        return "src/resources/DisparoLaser.png";
    }

    @Override
    public void die() {

    }
}
