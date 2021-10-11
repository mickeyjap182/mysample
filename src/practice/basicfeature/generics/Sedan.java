package practice.basicfeature.generics;

public class Sedan extends Car {

    public static final int WEIGHT = 450;

    private String name;

    public Sedan(String name) {
        super(name);
        super.setWeight(WEIGHT);
        this.name = name + "_compact.";
    }

    @Override
    public String getName() {
        return this.name + "(" + this.getName() + ")";
    }
}
