// =====================
// FILE 3: Rectangle.java
// implements Shape
// =====================

public class Rectangle implements Shape {

    double length;
    double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}