package lesson7;

public class Plate {

    private int MaxCapacity;
    private int CurrentCapacity;
    private String NameOfFood;

    public Plate(int maxCapacity, String nameOfFood) {
        this.MaxCapacity = maxCapacity;
        this.NameOfFood = nameOfFood;
        CurrentCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return CurrentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        CurrentCapacity = currentCapacity;
    }

    public void addFood(int food){
        CurrentCapacity += food;
    }
}
