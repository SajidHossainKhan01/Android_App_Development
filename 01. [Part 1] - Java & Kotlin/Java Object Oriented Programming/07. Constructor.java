// =====================
// CAR CLASS WITH CONSTRUCTOR
// =====================

class Car {

    // Fields (States / Attributes)
    int year;
    int speed;

    // =====================
    // CONSTRUCTOR
    // same name as the class
    // =====================

    public Car(int carSpeed, int carYear) {
        speed = carSpeed;
        year = carYear;
    }

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
        // CREATING OBJECT USING CONSTRUCTOR
        // passing speed = 100, year = 2023
        // =====================

        Car redCar = new Car(100, 2023);

        // Calling methods
        redCar.accelerate(); // speed = 100 + 10 = 110
        redCar.accelerate(); // speed = 110 + 10 = 120
        redCar.brake();      // speed = 120 - 5  = 115
    }
}
```

### Output:
```
Your new speed is: 110
Your new speed is: 120
Your new speed is: 115