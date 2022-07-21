package theadQuarter.lesson31;

public class Fruit {

    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }
    public Fruit(){
        this.weight = 0.5f;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
