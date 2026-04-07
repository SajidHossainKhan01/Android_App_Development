// =====================
// FILE 5: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // Creating objects
        Car v1 = new Car("BMW");
        Truck v2 = new Truck(6);

        // =====================
        // Calling Car methods
        // =====================
        v1.startEngine();  // Starting the car engine
        v1.accelerate();   // Accelerating the car
        v1.brake();        // Applying the car brake
        v1.stopEngine();   // Stopping the car engine

        System.out.println("---");

        // =====================
        // Calling Truck methods
        // =====================
        v2.startEngine();  // Starting the truck engine
        v2.accelerate();   // Accelerating the truck
        v2.brake();        // Applying the truck brake
        v2.stopEngine();   // Stopping the truck engine
        v2.operate();      // Truck is operating
        v2.shutdown();     // Truck is shutting down
    }
}
```

### Output:
```
Starting the car engine
Accelerating the car
Applying the car brake
Stopping the car engine
---
Starting the truck engine
Accelerating the truck
Applying the truck brake
Stopping the truck engine
Truck is operating
Truck is shutting down