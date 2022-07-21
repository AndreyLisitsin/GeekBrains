package theadQuarter.lesson31;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLesson31<E> {
    private E[] arr;

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(new Apple(45),
                new Apple(25),
                new Apple(15),
                new Apple(75),
                new Apple(10),
                new Apple(35));
        Apple apple = new Apple(74);
        appleBox.addFruits(apple);
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>(new Orange(12),
                new Orange(15),
                new Orange(16),
                new Orange(17),
                new Orange(18),
                new Orange(20));

        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
    }

    public MainLesson31(E... objects){
        this.arr = objects;
    }
    
    public ArrayList<E> createList(){
        return new ArrayList<>(List.of(arr));
    }

    public void replaceElements(E first, E second){
        E swap = second;
        second = first;
        first = swap;

    }
}
