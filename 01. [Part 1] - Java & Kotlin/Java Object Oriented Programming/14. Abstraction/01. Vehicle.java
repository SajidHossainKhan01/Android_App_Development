// =====================
// FILE 1: Vehicle.java
// ABSTRACT PARENT CLASS
// =====================

public abstract class Vehicle {

    // Field
    int numberOfWheels;

    // Constructor
    public Vehicle(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    // Regular methods - already implemented
    public void start() {
        System.out.println("Vehicle starts");
    }

    public void stop() {
        System.out.println("Vehicle stops");
    }

    // =====================
    // ABSTRACT METHOD
    // no body - must be implemented by child classes
    // =====================
    public abstract void brake();
}