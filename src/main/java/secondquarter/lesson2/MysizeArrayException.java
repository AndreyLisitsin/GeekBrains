package secondquarter.lesson2;

public class MysizeArrayException extends Exception{


    @Override
    public String getMessage() {
        return "Массив не имеет размерность 4х4";
    }
}
