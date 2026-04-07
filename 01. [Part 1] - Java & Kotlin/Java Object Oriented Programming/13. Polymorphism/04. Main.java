// =====================
// FILE 4: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // =====================
        // POLYMORPHISM
        // Vehicle reference -> Car/Truck object
        // =====================

        // V1 is a Vehicle reference but holds a Car object
        Vehicle v1 = new Car("BMW");

        // V2 is a Vehicle reference but holds a Truck object
        Vehicle v2 = new Truck(6);

        // Same method start() behaves differently
        // based on the actual object type
        v1.start(); // Car starts
        v2.start(); // Truck starts

        v1.stop();  // Vehicle stops
        v2.stop();  // Vehicle stops
    }
}
```

### Output:
```
Car starts
Truck starts
Vehicle stops
Vehicle stops
```

---

### Polymorphism Visualization:
```
        Vehicle (Parent)
        ├── start()  "Vehicle starts"
        └── stop()   "Vehicle stops"
               ↑
           extends
          ↗       ↖
    Car               Truck
    @Override         @Override
    start()           start()
    "Car starts"      "Truck starts"


Vehicle v1 = new Car("BMW");   → calls Car's   start()
Vehicle v2 = new Truck(6);     → calls Truck's start()