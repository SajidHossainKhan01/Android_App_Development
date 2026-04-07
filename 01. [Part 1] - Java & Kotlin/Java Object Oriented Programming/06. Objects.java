// =====================
// CAR CLASS (Blueprint)
// =====================

class Car {

    // Fields (States / Attributes)
    int year;
    int speed;

    // Methods (Behaviors)
    void accelerate() {
        speed = speed + 10;
        System.out.println("Your new speed is: " + speed);
    }

    void brake() {
        speed = speed - 5;
        System.out.println("Your new speed is: " + speed);
    }
}

// =====================
// MAIN CLASS
// =====================

public class Main {

    public static void main(String[] args) {

        // =====================
        // CREATING AN OBJECT
        // =====================

        Car redCar = new Car();

        // =====================
        // SETTING ATTRIBUTES
        // =====================

        redCar.speed = 180;
        redCar.year = 2023;

        // =====================
        // CALLING METHODS
        // =====================

        redCar.accelerate(); // speed = 180 + 10 = 190
        redCar.accelerate(); // speed = 190 + 10 = 200
        redCar.brake();      // speed = 200 - 5  = 195
    }
}
```

### Output:
```
Your new speed is: 190
Your new speed is: 200
Your new speed is: 195