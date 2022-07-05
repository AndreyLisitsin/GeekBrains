package secondquarter.lesson2;

import java.io.PrintStream;

public class MyArrayDataException extends NumberFormatException {

    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i =i;
        this.j =j;
    }

    @Override
    public String getMessage() {
        return String.format("не Удалось преобразовать элеменет с индексами %s %s", i, j);
    }
}


