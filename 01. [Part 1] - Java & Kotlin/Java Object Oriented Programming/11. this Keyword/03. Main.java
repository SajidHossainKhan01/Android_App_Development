// =====================
// FILE 3: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // Creating a Car object
        Car myCar = new Car("Mercedes 300");

        // =====================
        // ACCESSING INHERITED properties from Vehicle
        // =====================
        System.out.println("Number of wheels: " + myCar.numberOfWheels); // 4

        // =====================
        // ACCESSING Car's OWN property
        // =====================
        System.out.println("Car model: " + myCar.carModel); // Mercedes 300

        // =====================
        // CALLING INHERITED methods from Vehicle
        // =====================
        myCar.start(); // Vehicle starts

        // =====================
        // CALLING Car's OWN method
        // =====================
        myCar.honk();  // Beep Beep!

        // =====================
        // CALLING INHERITED method from Vehicle
        // =====================
        myCar.stop();  // Vehicle stops
    }
}
```

### Output:
```
Number of wheels: 4
Car model: Mercedes 300
Vehicle starts
Beep Beep!
Vehicle stops
```

---

### Class Structure Visualization:
```
Vehicle (Parent Class)
├── Field:   numberOfWheels
├── Method:  start()
└── Method:  stop()
        ↑
     extends
        ↑
Car (Child Class)
├── Inherited: numberOfWheels, start(), stop()
├── Own Field:  carModel       ← bold in Android Studio
└── Own Method: honk()         ← bold in Android Studio