package practice.basicfeature.generics;

public class Vehicle<T> {
    private T vehicleType;
    public Vehicle(T type) {
        vehicleType = type;
    }

    public T getVehicleType() {
        return vehicleType;
    }
}
