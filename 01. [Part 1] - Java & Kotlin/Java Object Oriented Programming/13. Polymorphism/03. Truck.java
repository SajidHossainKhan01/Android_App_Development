// =====================
// FILE 3: Truck.java
// CHILD CLASS 2
// =====================

public class Truck extends Vehicle {

    // Constructor
    public Truck(int numberOfWheels) {
        super(numberOfWheels);
    }

    // Overriding start() from Vehicle
    @Override
    public void start() {
        System.out.println("Truck starts");
    }
}