package lesson6;

public abstract class  Animal {

    private  int limitForRunning;
    private  int limitForSwimming;
    private static int count;
    private String name;

    public Animal(String name) {
        this.name = name;
        count++;
        if (this instanceof Cat){
            limitForSwimming = 0;
            limitForRunning = 100;
        }
        if(this instanceof Dog){
            limitForSwimming = 10;
            limitForRunning = 200;
        }
    }

    public static int getCount() {
        System.out.println("Общее количество животных "+ count);
        return count;
    }

    public void swim(int distance){
        if (distance < limitForSwimming)
            System.out.println(name+" пробежал "+ distance);
        else
            System.out.println(this.getClass().getSimpleName()+" не может столько проплыть");
    }

    public void run(int distance){
        if (distance < limitForRunning)
            System.out.println(name+" проплыл "+ distance);
        else
            System.out.println(this.getClass().getSimpleName() + " не может столько пробежать");
    }
}
