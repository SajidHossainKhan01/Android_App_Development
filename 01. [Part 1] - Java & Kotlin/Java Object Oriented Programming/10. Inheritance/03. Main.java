// =====================
// FILE 3: Test.java
// different package
// =====================

package anotherpack;

import com.mastercoding.lib.Car;

public class Test {

    void testing() {

        Car yellowCar = new Car(70, 2024);
// =====================
// FILE 3: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // Creating a Car object
        Car myCar = new Car("Toyota");

        // Accessing inherited fields from Vehicle
        System.out.println("Number of wheels: " + myCar.numberOfWheels); // 4

        // Accessing Car's own field
        System.out.println("Car model: " + myCar.carModel); // Toyota

        // Calling inherited methods from Vehicle
        myCar.start(); // Vehicle starts
        myCar.stop();  // Vehicle stops
    }
}
```

### Output:
```
Number of wheels: 4
Car model: Toyota
Vehicle starts
Vehicle stops
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