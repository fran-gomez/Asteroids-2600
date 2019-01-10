package asteroids;

public class UFO extends Asteroid {

    public UFO(int lp, int ip) {
        super(lp, ip);
    }

    @Override
    public Asteroid clone() {
        return new UFO(lifePoints, impactPoints);
    }

    @Override
    public String getGraphicsPath() {
        return "src/resources/ufo.png";
    }

    @Override
    public void die() {

    }
}
