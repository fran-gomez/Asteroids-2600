package shoots;

public class TripleShoot extends Shoot {

    public TripleShoot(int x, int y, double angulo, int dmg) {
        super(x, y, angulo, dmg);
    }

    public String getGraphicsPath() {
        return "src/resources/DisparoTriple.png";
    }

    @Override
    public void die() {

    }
}
