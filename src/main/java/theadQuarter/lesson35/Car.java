package theadQuarter.lesson35;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static volatile boolean isWin;
    private static int CARS_COUNT;
    CyclicBarrier cb = new CyclicBarrier(1);
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
           // cb.await();
            System.out.println(this.name + " готов");
            Thread.sleep(1000);
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        checkWin();
    }

    private synchronized void checkWin(){
        if (isWin == false) {
            System.out.println(name + " победил");
            isWin = true;
        }
    }
}
