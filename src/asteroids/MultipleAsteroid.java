package asteroids;

public class MultipleAsteroid extends Asteroid {

    public MultipleAsteroid(int lp, int ip) {
        super(lp, ip);
    }

    @Override
    public Asteroid clone() {
        return new MultipleAsteroid(this.lifePoints, this.impactPoints);
    }

    @Override
    public String getGraphicsPath() {
        return "src/resources/asteroideII.png";
    }

    @Override
    public void die() {

    }
}
