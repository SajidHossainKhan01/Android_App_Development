// =====================
// FILE 4: Truck.java
// implements VehicleInterface
// can also implement multiple interfaces
// =====================

public class Truck implements VehicleInterface, MachineInterface {

    int numberOfWheels;

    public Truck(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    // =====================
    // MUST implement ALL methods
    // from VehicleInterface
    // =====================

    @Override
    public void startEngine() {
        System.out.println("Starting the truck engine");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping the truck engine");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating the truck");
    }

    @Override
    public void brake() {
        System.out.println("Applying the truck brake");
    }

    // =====================
    // MUST implement ALL methods
    // from MachineInterface
    // =====================

    @Override
    public void operate() {
        System.out.println("Truck is operating");
    }

    @Override
    public void shutdown() {
        System.out.println("Truck is shutting down");
    }
}