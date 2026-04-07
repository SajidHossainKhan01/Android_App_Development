// =====================
// FILE 2: Circle.java
// implements Shape
// =====================

public class Circle implements Shape {

    double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius; // π * r²
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius; // 2 * π * r
    }
}