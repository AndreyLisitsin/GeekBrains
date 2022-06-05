package lesson6;

public class Dog extends Animal{

    private static int count;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        System.out.println("Общее количество собак: "+count);
        return count;
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
    }

    @Override
    public void run(int distance) {
        super.run(distance);
    }
}
