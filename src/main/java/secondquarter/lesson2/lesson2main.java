package secondquarter.lesson2;

import java.util.stream.Stream;

public class lesson2main {
    public static void main(String[] args) {

        String[][] s = new String[4][4];
        fillArray(s);
        s[2][3] = "sad";

        try {
            stringArrayToInt(s);
        }
        catch ( MyArrayDataException | MysizeArrayException e){
            e.printStackTrace();

        }
    }

    public static int stringArrayToInt(String[][] array) throws MyArrayDataException, MysizeArrayException {
        int count = Stream.of(array).mapToInt(s -> s.length).sum();
        int sum =0;
        if (array.length !=4 && count != 16)
                throw new MysizeArrayException();

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array.length ; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

    public static String[][] fillArray(String[][] array) {
        int count =0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                count++;
                array[i][j] = "" + count;
            }
        }
        return array;
    }
}
