package shoots;

public class SimpleShoot extends Shoot {
    public SimpleShoot(int x, int y, double angulo, int dmg) {
        super(x, y, angulo, dmg);

        this.hitBox.setBounds(x, y, 5, 15);
    }

    public String getGraphicsPath() {
        return "src/resources/DisparoSimple.png";
    }

    public void move() {

        moverAdelante();
        super.move();
    }

    public void die() {

    }
}
