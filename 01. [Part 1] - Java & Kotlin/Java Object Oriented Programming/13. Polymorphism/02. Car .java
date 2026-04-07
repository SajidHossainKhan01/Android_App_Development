// =====================
// FILE 2: Car.java
// CHILD CLASS 1
// =====================

public class Car extends Vehicle {

    String carModel;

    public Car(String carModel) {
        super(4);
        this.carModel = carModel;
    }

    @Override
    public void start() {
        System.out.println("Car starts");
    }

    public void honk() {
        System.out.println("Beep Beep!");
    }
}