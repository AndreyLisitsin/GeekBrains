package secondquarter.lesson1;

public class Cat implements Participant {
    private int maxRunningDistance;
    private int maxJumpingHeight;

    public Cat (int maxRunningDistance, int maxJumpingHeight) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingHeight = maxJumpingHeight;
    }

    public boolean run(int distance){
        if (distance <= maxRunningDistance) {
            System.out.println(this.getClass().getSimpleName() + " пробежал " + distance);
            return true;
        }
        else{
            System.out.println(this.getClass().getSimpleName() +" не пробежал " + distance);
            return false;
        }
    }

    public boolean jump(int height){
        if (height <= maxJumpingHeight) {
            System.out.println(this.getClass().getSimpleName() + " прыгнул на " + height);
            return true;
        }
        else{
            System.out.println(this.getClass().getSimpleName() +" не прыгнул" + height);
            return false;
        }
    }
}
