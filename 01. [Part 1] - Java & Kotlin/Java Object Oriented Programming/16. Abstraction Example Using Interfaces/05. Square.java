// =====================
// FILE 5: Square.java
// implements Shape
// =====================

public class Square implements Shape {

    double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}