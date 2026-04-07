// =====================
// FILE 4: Triangle.java
// implements Shape
// =====================

public class Triangle implements Shape {

    double base;
    double height;
    double side1, side2, side3;

    // Constructor
    public Triangle(double base, double height,
                    double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // ½ * base * height
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}