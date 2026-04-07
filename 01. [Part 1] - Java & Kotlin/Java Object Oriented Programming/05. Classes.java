// =====================
// CAR CLASS (Blueprint)
// =====================

class Car {

    // =====================
    // FIELDS (States / Attributes)
    // =====================

    int year;
    int speed;

    // =====================
    // METHODS (Behaviors)
    // =====================

    void accelerate() {
        speed = speed + 10; // increase speed by 10
    }

    void brake() {
        speed = speed - 5; // decrease speed by 5
    }
}

// =====================
// MAIN CLASS
// =====================

public class Main {

    public static void main(String[] args) {
        // Objects will be created in the next video
    }
}