// =====================
// FILE 3: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        Car myCar = new Car("Mercedes 300");

        // Calls OVERRIDDEN start() from Car class
        myCar.start(); // Car starts

        // Calls honk() from Car class
        myCar.honk();  // Beep Beep!

        // Calls stop() from Vehicle class (NOT overridden)
        myCar.stop();  // Vehicle stops
    }
}
```

### Output:
```
Car starts
Beep Beep!
Vehicle stops
```

---

### Method Overriding Visualization:
```
Vehicle (Parent)          Car (Child)
├── start()       →       @Override start()   ← Car's version is used
│   "Vehicle starts"      "Car starts"
│
└── stop()        →       (not overridden)    ← Vehicle's version is used
    "Vehicle stops"