package secondquarter.lesson1;

public class lesson1_main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[3];
        Obstacle[] obstacles = new Obstacle[4];

        participants[0] = new Human(500,10);
        participants[1] = new Cat(700,6);
        participants[2] = new Robot(1000,2);

        obstacles[0] = new Treadmill(400);
        obstacles[1] = new Wall(1);
        obstacles[2] = new Treadmill(600);
        obstacles[3] = new Wall(3);

        for (int i = 0; i < participants.length ; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Wall) {
                    if (!participants[i].jump(obstacles[j].passAnObstacle()))
                        break;
                }
                else if(!participants[i].run(obstacles[j].passAnObstacle())) {
                    break;
                }
            }
        }

    }
}
