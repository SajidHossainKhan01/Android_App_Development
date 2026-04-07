// =====================
// FILE 6: Main.java
// =====================

public class Main {

    public static void main(String[] args) {

        // Creating a Circle with radius 5.0
        Circle c = new Circle(5.0);

        // Creating a Rectangle with length 4.0 and width 6.0
        Rectangle r = new Rectangle(4.0, 6.0);

        // Creating a Triangle
        Triangle t = new Triangle(6.0, 4.0, 5.0, 5.0, 6.0);

        // Creating a Square
        Square s = new Square(4.0);

        // =====================
        // PRINTING Circle results
        // =====================
        System.out.println("Circle Area: "        + c.calculateArea());
        System.out.println("Circle Perimeter: "   + c.calculatePerimeter());

        System.out.println("---");

        // =====================
        // PRINTING Rectangle results
        // =====================
        System.out.println("Rectangle Area: "      + r.calculateArea());
        System.out.println("Rectangle Perimeter: " + r.calculatePerimeter());

        System.out.println("---");

        // =====================
        // PRINTING Triangle results
        // =====================
        System.out.println("Triangle Area: "      + t.calculateArea());
        System.out.println("Triangle Perimeter: " + t.calculatePerimeter());

        System.out.println("---");

        // =====================
        // PRINTING Square results
        // =====================
        System.out.println("Square Area: "      + s.calculateArea());
        System.out.println("Square Perimeter: " + s.calculatePerimeter());
    }
}
```

### Output:
```
Circle Area: 78.5
Circle Perimeter: 31.400000000000002
---
Rectangle Area: 24.0
Rectangle Perimeter: 20.0
---
Triangle Area: 12.0
Triangle Perimeter: 16.0
---
Square Area: 16.0
Square Perimeter: 16.0
```

---

### Shape Interface Visualization:
```
Shape (Interface - Contract)
├── calculateArea()
└── calculatePerimeter()
          ↑
      implements
    ↗   ↗   ↗   ↗
Circle  Rectangle  Triangle  Square
(each provides its own
 implementation of both methods)