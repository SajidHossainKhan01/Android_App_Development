// =====================
// FILE 1: Vehicle.java
// PARENT CLASS
// =====================

public class Vehicle {

    // Field
    int numberOfWheels;

    // Constructor
    public Vehicle(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    // Methods
    public void start() {
        System.out.println("Vehicle starts");
    }

    public void stop() {
        System.out.println("Vehicle stops");
    }
}