public class Main {

    // =====================
    // METHOD OVERLOADING
    // Same name, different parameters
    // =====================

    // Method 1 - accepts two integers
    static int addNumbers(int x, int y) {
        return x + y;
    }

    // Method 2 - accepts two doubles
    static double addNumbers(double z, double w) {
        return z + w;
    }

    // =====================
    // MAIN METHOD
    // =====================

    public static void main(String[] args) {

        // Calling addNumbers with integers -> Method 1 is called
        int sumInt = addNumbers(10, 20);
        System.out.println("Int sum: " + sumInt); // 30

        // Calling addNumbers with doubles -> Method 2 is called
        double sumDouble = addNumbers(10.7, 20.3);
        System.out.println("Double sum: " + sumDouble); // 31.0
    }
}
```

### Output:
```
Int sum: 30
Double sum: 31.0