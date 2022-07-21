package theadQuarter.lesson31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Box<E extends Fruit> {

    private ArrayList<E> box;

    @SafeVarargs
    public Box(E... fruits){
        this.box = new ArrayList<>(List.of(fruits));
    }

    public double getWeight(){
        return box.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public boolean compare(Box<?> box){
        if (this.getWeight() == box.getWeight())
            return true;
        else
            return false;
    }

    public void sprinkleFruits(Box<E> box, E fruit){
        box.addFruits(fruit);
        this.box.remove(fruit);
    }

    public void addFruits(E fruit){
        box.add(fruit);
    }
}
