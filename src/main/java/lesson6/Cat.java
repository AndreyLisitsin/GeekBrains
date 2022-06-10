package lesson6;

public class Cat extends Animal{

    private static int count;

    public Cat(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        System.out.println("Общее количество кошек "+ count);
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
