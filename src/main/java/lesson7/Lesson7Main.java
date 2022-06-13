package lesson7;

public class Lesson7Main {
    public static void main(String[] args) {

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Василий",25);
        cats[1] = new Cat("Мурка",17);
        cats[2] = new Cat("Котопёс",56);
        cats[3] = new Cat("Просто кот",25);

        Plate plate = new Plate(100,"wiskas");

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }
    }
}
