// =====================
// FILE 3: Car.java
// implements VehicleInterface
// =====================

public class Car implements VehicleInterface {

    String carModel;

    public Car(String carModel) {
        this.carModel = carModel;
    }

    // =====================
    // MUST implement ALL methods
    // from VehicleInterface
    // =====================

    @Override
    public void startEngine() {
        System.out.println("Starting the car engine");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping the car engine");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating the car");
    }

    @Override
    public void brake() {
        System.out.println("Applying the car brake");
    }
}