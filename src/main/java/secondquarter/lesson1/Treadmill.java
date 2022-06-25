package secondquarter.lesson1;

public class Treadmill implements Obstacle{

    private int treadmillDistance;

    public Treadmill(int treadmillDistance) {
        this.treadmillDistance = treadmillDistance;
    }

    @Override
    public int passAnObstacle() {
        return treadmillDistance;
    }
}
