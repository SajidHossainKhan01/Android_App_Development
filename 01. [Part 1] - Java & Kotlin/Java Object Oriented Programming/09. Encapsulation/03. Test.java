// =====================
// FILE 3: Test.java
// different package
// =====================

package anotherpack;

import com.mastercoding.lib.Car;

public class Test {

    void testing() {

        Car yellowCar = new Car(70, 2024);

        // ❌ WRONG - cannot access private fields directly
        // yellowCar.year = 2025;  // ERROR!
        // yellowCar.speed = 200;  // ERROR!

        // ✅ CORRECT - use Setters to MODIFY private fields
        yellowCar.setYear(2025);
        yellowCar.setSpeed(200);

        // ✅ CORRECT - use Getters to RETRIEVE private fields
        System.out.println("Year: " + yellowCar.getYear());   // 2025
        System.out.println("Speed: " + yellowCar.getSpeed()); // 200
    }
}