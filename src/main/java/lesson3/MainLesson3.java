package lesson3;

import java.util.Arrays;

public class MainLesson3 {

    public static void main(String[] args) {

        // Задание 1
        int [] array = new int[]{0,0,1,1,1,0,1,1,0,0,0,0,1,1};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1:0;
        }

        // Задание 2
        int [] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i]=i+1;
        }

        // Задание 3
        int [] newArray = new int[]{1,5,3,2,11,4,5,2,4,8,9,1,15};
        for (int i = 0; i < newArray.length; i++){
            if (newArray[i] < 6)
                newArray[i] *= 2;
        }

        // Задание 4
        int[][] secondArray = new int[10][10];
        for (int i = 0; i < secondArray.length ; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (i + j == 9) {
                    secondArray[i][j] = 1;
                }
                if (i == j) {
                    secondArray[i][j] = 1;
                }
            }
        }
    }

    // Задание 5
    private static int [] makingNewMassive(int len, int initValue){
        int[] array = new int[len];
        Arrays.fill(array, initValue);
        return array;
    }

    //Задание 6
    private static void findMaxAndMinArgs(int [] array){
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length ; i++) {
            if(array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }
        System.out.printf("min: %d, max: %d", min, max );
    }

    //Задание 7
    private static boolean isEqueleSumBetweenRightAndLeftSightOfArray(int [] array){
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < array.length-1 ; i++) {
            for (int j = 0; j < array.length -1 -i; j++) {
                leftSum += array[j];
            }
            rightSum += array[array.length-i-1];
            if (rightSum == leftSum)
                break;
            else {
                leftSum = 0;
            }
        }
        return leftSum == rightSum;
    }

    //Задание 8
    private static void rotateValueInArray(int[] array, int n){
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int val = array[array.length - 1];
                for (int j = array.length; j >= 1; j--) {
                    if (j == 1)
                        array[0] = val;
                    else
                        array[j - 1] = array[j - 2];
                }
            }
        }
        else {
            for (int i = 0; i < -n; i++) {
                int val = array[0];
                for (int j = 0; j < array.length; j++) {
                    if (j == array.length - 1)
                        array[array.length - 1] = val;
                    else
                        array[j] = array[j + 1];
                }
            }
        }
    }
}