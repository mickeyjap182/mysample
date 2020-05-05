package practice.basicfeature.generics;

import practice.basicfeature.generics.Vehicle;

public class Runner {
    public static void go() {
        Vehicle<String> car = new Vehicle<>("car!");
        System.out.printf(car.getVehicleType().getClass().getName() + "\n");
        System.out.printf(car.getVehicleType() + "\n");

        Vehicle<Car> car2 = new Vehicle<>(new Car("car2!"));
        System.out.printf(car2.getVehicleType().getClass().getName() + "\n");
        System.out.printf(car2.getVehicleType().getName() + "\n");
    }
}
