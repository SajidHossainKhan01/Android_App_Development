// =====================
// FILE 1: Car.java
// =====================

package com.mastercoding.lib;

public class Car {

    // PRIVATE fields - cannot be accessed directly from outside
    private int year;
    private int speed;

    // Constructor
    public Car(int carSpeed, int carYear) {
        speed = carSpeed;
        year = carYear;
    }

    // =====================
    // GETTERS
    // used to RETRIEVE private fields
    // =====================

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }

    // =====================
    // SETTERS
    // used to MODIFY private fields
    // =====================

    public void setYear(int newYear) {
        year = newYear;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    // Methods
    public void accelerate() {
        speed = speed + 10;
        System.out.println("Your new speed is: " + speed);
    }

    public void brake() {
        speed = speed - 5;
        System.out.println("Your new speed is: " + speed);
    }
}