package practice.basicfeature.novice.extendsinterface.abstruct;

public class CompactCar extends Car {

    public static final int WEIGHT = 350;
    public CompactCar(String name) {
        super(name);
        super.setWeight(WEIGHT);
    }

//    @Override
//    public String getName() {
//        return super.getName();
//    }
}
