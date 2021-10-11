package practice.basicfeature.generics;

public class CompactCar extends Car {

    public static final int WEIGHT = 350;

    private String name;
    public CompactCar(String name) {
        super(name);
        super.setWeight(WEIGHT);
        this.name = name + "_compact.";
    }

    @Override
    public String getName() {
        return this.name + "(" + this.getName() + ")";
    }
}
