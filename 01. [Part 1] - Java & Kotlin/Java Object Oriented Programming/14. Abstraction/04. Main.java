// =====================
// FILE 4: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // ❌ CANNOT create object from abstract class
        // Vehicle v3 = new Vehicle(4); // ERROR!

        // ✅ Polymorphism - parent reference, child object
        Vehicle v1 = new Car("BMW");
        Vehicle v2 = new Truck(6);

        // Calling overridden start() methods
        v1.start(); // Car starts
        v2.start(); // Truck starts

        // Calling implemented abstract brake() methods
        v1.brake(); // Applying mechanical brake
        v2.brake(); // Applying hydraulic brake

        // Calling inherited stop() method
        v1.stop();  // Vehicle stops
        v2.stop();  // Vehicle stops
    }
}
```

### Output:
```
Car starts
Truck starts
Applying mechanical brake
Applying hydraulic brake
Vehicle stops
Vehicle stops
```

---

### Abstract Class Visualization:
```
abstract class Vehicle
├── numberOfWheels
├── start()          → regular method (has body)
├── stop()           → regular method (has body)
└── brake()          → abstract method (NO body - MUST be overridden)
          ↑
       extends
      ↗       ↖
  Car               Truck
  @Override         @Override
  brake()           brake()
  "mechanical"      "hydraulic"