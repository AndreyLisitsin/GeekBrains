package lesson2;

public class Lesson2 {

    public static void main(String[] args) {

    }

    private static boolean sumOfTwoElements(int a, int b) {
        if ((a+b)>=10 && (a+b)<=20)
            return true;
        else
            return false;
    }

    private static void isPositiveNumber(int a){
        if (a>=0)
            System.out.println("Число " + a + " положительное");
        else
            System.out.println("Число " + a + " отрицательное");
    }

    private static boolean isNegativeNumber(int a){
        return a <= 0;
    }

    private static void printStringByCount(String s, int count){
        for (int i = 0; i < count; i++) {
            System.out.println(s);
        }
    }

    private static boolean isLeapYear(int year){
        if ((year % 4 ==0 && year % 100 !=0) || (year % 100 ==0 && year % 400 ==0))
            return true;
        else
            return false;
    }
}
