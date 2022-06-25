package secondquarter.lesson1;

public class Wall implements Obstacle{

    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public int passAnObstacle() {
        return wallHeight;
    }
}
