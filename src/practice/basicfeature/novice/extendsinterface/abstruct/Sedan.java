package practice.basicfeature.novice.extendsinterface.abstruct;

public class Sedan extends Car {

    public static final int WEIGHT = 450;
    public Sedan(String name) {
        super(name);
        super.setWeight(WEIGHT);
    }

//    @Override
//    public String getName() {
//        return super.getName();
//    }
}
