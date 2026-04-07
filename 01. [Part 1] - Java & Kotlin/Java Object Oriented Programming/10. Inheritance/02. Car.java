// =====================
// FILE 2: Car.java
// CHILD CLASS (Subclass / Derived Class)
// inherits from Vehicle
// =====================

public class Car extends Vehicle {

    // Car specific field
    String carModel;

    // Constructor
    public Car(String carModel) {
        super(4); // calls Vehicle constructor, cars always have 4 wheels
        this.carModel = carModel;
    }
}