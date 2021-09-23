package practice.basicfeature.generics;

import practice.basicfeature.generics.Vehicle;

import java.util.List;

public class Runner { //
    public static final List<String> CLASS_LIST = List.of(
            "java.lang.String",
            "import practice.basicfeature.generics.Vehicle",
            "import practice.basicfeature.generics.Car",
            "import practice.basicfeature.generics.Sedan"
    );
    public static void go() {
        Vehicle<String> str = new Vehicle<>("string!");
        printContents(str);

        Vehicle<Car> car = new Vehicle<>(new Car("car!"));
        printContents(car);

        Vehicle<Sedan> sedan = new Vehicle<>(new Sedan("sedan!"));
        printContents(sedan);

        // The wildcard with a upper limit. -> Car or Sub class of the Car.
        Vehicle<? extends Car> subClassOfCar = car;
        printContents(subClassOfCar);

        subClassOfCar = sedan;
        printContents(subClassOfCar);


        // The wildcard with a lower limit. -> Sedan or Super class of the Sedan.
        Vehicle<? super Sedan> superClassOfSedan = car;
        printContents(superClassOfSedan);

        superClassOfSedan = sedan;
        printContents(superClassOfSedan);

        // dynamically cast
        String name = "aaa";
        String c = "java.lang.String";
        try {
            Object s =  Class.forName(c).cast(name);
            if(s instanceof String) {
                System.out.println("==yes==");
            } else {
                System.out.println("==no==");
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();

        }

    }

    private static void printContents(Vehicle<?> some) {
        try {
            Object someType = some.getVehicleType();
            System.out.printf(someType.getClass().getName() + "\n");
            System.out.printf(((Car) someType).getName() + "\n");

        } catch (Exception e) {
            System.out.printf(some.getVehicleType().getClass().getName() + "\n");
            System.out.printf(some.getVehicleType() + "\n");
        }
    }
}
