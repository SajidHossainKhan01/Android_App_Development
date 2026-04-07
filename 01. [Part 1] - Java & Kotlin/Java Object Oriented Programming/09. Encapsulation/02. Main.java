// =====================
// FILE 2: Main.java
// same package
// =====================

package com.mastercoding.lib;

public class Main {

    public static void main(String[] args) {

        Car redCar = new Car(100, 2023);

        // ❌ WRONG - cannot access private fields directly
        // redCar.year = 2024;  // ERROR!
        // redCar.speed = 150;  // ERROR!

        // ✅ CORRECT - use Setters to MODIFY private fields
        redCar.setYear(2024);
        redCar.setSpeed(150);

        // ✅ CORRECT - use Getters to RETRIEVE private fields
        System.out.println("Year: " + redCar.getYear());   // 2024
        System.out.println("Speed: " + redCar.getSpeed()); // 150

        // Calling methods
        redCar.accelerate(); // speed = 150 + 10 = 160
        redCar.brake();      // speed = 160 - 5  = 155
    }
}