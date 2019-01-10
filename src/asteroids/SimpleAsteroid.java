package asteroids;

public class SimpleAsteroid extends Asteroid {

    public SimpleAsteroid(int lp, int ip) {
        super(lp, ip);
    }

    @Override
    public Asteroid clone() {
        return new SimpleAsteroid(lifePoints, impactPoints);
    }

    @Override
    public String getGraphicsPath() {
        return "src/resources/asteroideI.png";
    }

    @Override
    public void die() {

    }
}
