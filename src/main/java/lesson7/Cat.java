package lesson7;

public class Cat {

    private String name;
    private int maxAppetite;
    private int currentAppetite;
    private Plate plate;

    public Cat(String name, int maxAppetite) {
        this.name = name;
        this.maxAppetite = maxAppetite;
        currentAppetite = maxAppetite;
    }

    public void eat(Plate plate){
        if ( plate.getCurrentCapacity() >= currentAppetite) {
            System.out.println("Кот " + name + " наелся");
            System.out.println("В тарелке осталось:"+(plate.getCurrentCapacity()- currentAppetite));
            plate.setCurrentCapacity(plate.getCurrentCapacity() - currentAppetite) ;
        }
        else {
            currentAppetite -= plate.getCurrentCapacity();
            System.out.println("Кот " + name + " не наелся, необходимо пищи, чтобы удалить голод: "+ currentAppetite);
            plate.setCurrentCapacity(0);
        }
    }
}
