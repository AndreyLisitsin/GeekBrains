package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void compareNumbers() {
        int a = 15;
        int b = 10;
        String result = a>=b?"a>=b":"a<b";
        System.out.println(result);
    }

    private static void printColor() {
        int value = 500;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign(){
        int a =10;
        int b =-40;

        if (a + b > 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

}
