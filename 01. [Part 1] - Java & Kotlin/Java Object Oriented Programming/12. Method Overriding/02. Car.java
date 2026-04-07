// =====================
// FILE 2: Car.java
// CHILD CLASS (Subclass)
// =====================

public class Car extends Vehicle {

    // Car specific field
    String carModel;

    // Constructor
    public Car(String carModel) {
        super(4);
        this.carModel = carModel;
    }

    // =====================
    // METHOD OVERRIDING
    // overrides start() from Vehicle
    // =====================

    @Override
    public void start() {
        System.out.println("Car starts"); // overrides "Vehicle starts"
    }

    // stop() is NOT overridden
    // so it will use Vehicle's stop() method

    // Car specific method
    public void honk() {
        System.out.println("Beep Beep!");
    }
}