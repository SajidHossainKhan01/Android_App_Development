// =====================
// FILE 3: Test.java
// inside package: anotherpack (DIFFERENT package from Car)
// =====================

package anotherpack;

import com.mastercoding.lib.Car; // import Car from different package

public class Test {

    void testing() {

        Car yellowCar = new Car(70, 2024);

        // ✅ PUBLIC - accessible from different package
        yellowCar.model = 2024;

        // ❌ PRIVATE - NOT accessible from different package
        // yellowCar.year = 2024; // ERROR!

        // ❌ PROTECTED - NOT accessible from different package
        // yellowCar.speed = 80; // ERROR!

        // ❌ DEFAULT - NOT accessible from different package
        // yellowCar.fuel = 50; // ERROR!

        // ✅ PUBLIC method - accessible from different package
        yellowCar.accelerate();

        // ❌ PRIVATE method - NOT accessible
        // yellowCar.engineDetails(); // ERROR!

        // ❌ PROTECTED method - NOT accessible from different package
        // yellowCar.refuel(); // ERROR!

        // ❌ DEFAULT method - NOT accessible from different package
        // yellowCar.brake(); // ERROR!
    }
}