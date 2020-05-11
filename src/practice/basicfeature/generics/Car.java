package practice.basicfeature.generics;

public class Car {

    public static final int WEIGHT = 300;

    private String name;
    private int weight = WEIGHT;


    public Car(String name ){
        this.name = name;
    }

    public int getWeight() { return weight; }
    public void setWeight(int wet) { weight = wet; }
    public String getName() { return name; }
}
