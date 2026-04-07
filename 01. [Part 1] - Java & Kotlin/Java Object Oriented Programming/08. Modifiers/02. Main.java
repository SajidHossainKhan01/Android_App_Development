// =====================
// FILE 2: Main.java
// inside package: com.mastercoding.lib (SAME package as Car)
// =====================

package com.mastercoding.lib;

public class Main {

    public static void main(String[] args) {

        Car redCar = new Car(100, 2023);

        // ✅ PUBLIC - accessible from same package
        redCar.model = 2023;

        // ❌ PRIVATE - NOT accessible, even from same package
        // redCar.year = 2023; // ERROR!

        // ✅ PROTECTED - accessible from same package
        redCar.speed = 90;

        // ✅ DEFAULT - accessible from same package
        redCar.fuel = 100;

        // ✅ PUBLIC method - accessible from same package
        redCar.accelerate();

        // ❌ PRIVATE method - NOT accessible
        // redCar.engineDetails(); // ERROR!

        // ✅ PROTECTED method - accessible from same package
        redCar.refuel();

        // ✅ DEFAULT method - accessible from same package
        redCar.brake();
    }
}