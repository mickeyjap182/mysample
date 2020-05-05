package practice.basicfeature.generics;

public class Car {

    public static final int WEIGHT = 300;

    private String name;


    public Car(String name ){
        this.name = name;
    }

    public int getWeight() {return WEIGHT;}
    public String getName() {return name;}
}
