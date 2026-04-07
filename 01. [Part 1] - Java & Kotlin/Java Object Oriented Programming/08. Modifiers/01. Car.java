// =====================
// FILE 1: Car.java
// inside package: com.mastercoding.lib
// =====================

package com.mastercoding.lib;

public class Car {

    // PUBLIC - accessible from anywhere
    public int model;

    // PRIVATE - accessible only within Car class
    private int year;

    // PROTECTED - accessible within same package and subclasses
    protected int speed;

    // DEFAULT - accessible only within same package (no modifier)
    int fuel;

    // Constructor
    public Car(int carSpeed, int carYear) {
        speed = carSpeed;
        year = carYear;
    }

    // PUBLIC method - accessible from anywhere
    public void accelerate() {
        speed = speed + 10;
        System.out.println("Your new speed is: " + speed);
    }

    // PRIVATE method - accessible only within Car class
    private void engineDetails() {
        System.out.println("Engine details: private");
    }

    // PROTECTED method - accessible within same package and subclasses
    protected void refuel() {
        System.out.println("Refueling...");
    }

    // DEFAULT method - accessible only within same package
    void brake() {
        speed = speed - 5;
        System.out.println("Your new speed is: " + speed);
    }
}