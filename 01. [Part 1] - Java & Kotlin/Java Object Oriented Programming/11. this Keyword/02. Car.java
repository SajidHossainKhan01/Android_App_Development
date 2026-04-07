// =====================
// FILE 2: Car.java
// CHILD CLASS (Subclass / Derived Class)
// =====================

public class Car extends Vehicle {

    // Car specific field
    String carModel;

    // Constructor
    public Car(String carModel) {
        super(4); // calls Vehicle constructor - cars have 4 wheels
        this.carModel = carModel;
        // OR if using different variable name:
        // String modelOfCar -> no need for 'this' keyword
    }

    // Car specific method
    public void honk() {
        System.out.println("Beep Beep!");
    }
}