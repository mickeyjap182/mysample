package practice.basicfeature.generics;

/**
 * This Class is a limit of generics class type.
 *
 * Wildcard type
 * @param <T>
 */
public class Vehicle<T> {

    private T vehicleType;

    /** arguments is wild card */
    public Vehicle(T type) {
        vehicleType = type;
    }

    /** */
    public T getVehicleType() {
        return vehicleType;
    }
}
