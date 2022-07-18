package secondquarter.lesson24;

import javax.swing.plaf.TableHeaderUI;

public class Lesson4Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) throws InterruptedException {
        oneThreadFillingArray(arr);
        towThreadFillingArray(arr);
    }

    public static void oneThreadFillingArray(float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = 1f;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }
    public static void towThreadFillingArray(float[] array) throws InterruptedException {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1f;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, h);

        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, h, h);
        });
        t1.start();
        t1.join();
        t2.start();

        long b = System.currentTimeMillis();
        System.out.println(b - a);

    }

}
