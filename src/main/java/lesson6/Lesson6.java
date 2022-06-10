package lesson6;

public class Lesson6 {
    public static void main(String[] args) {
        Cat cat = new Cat("barsik");
        cat.run(10);
        Dog dog = new Dog("cookie");
        dog.run(20);
        cat.swim(50);

        Animal.getCount();
        Dog.getCount();
        Cat.getCount();
        dog.swim(50);
    }
}
