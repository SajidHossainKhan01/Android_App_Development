public class Main {

    public static void main(String[] args) {

        // =====================
        // IMPLICIT TYPE CASTING (Automatic - no data loss)
        // =====================

        // Converting int to double automatically
        int numInt = 10;
        double numDouble = numInt; // implicitly cast from int to double
        System.out.println("int value: " + numInt);
        System.out.println("double value: " + numDouble); // prints 10.0

        // =====================
        // EXPLICIT TYPE CASTING (Manual - possible data loss)
        // =====================

        // Converting double to int manually
        double pi = 3.14;
        int numPi = (int) pi; // explicitly cast from double to int
        System.out.println("double pi: " + pi);
        System.out.println("int numPi: " + numPi); // prints 3 (decimal part is lost)

        // =====================
        // TYPE CASTING BETWEEN DIFFERENT DATA TYPES
        // =====================

        // Adding an integer to a character (using ASCII table)
        int myInt = 5;
        char myChar = 'A'; // 'A' has ASCII value of 65
        char myResult = (char) (myChar + myInt); // 65 + 5 = 70 = 'F'
        System.out.println("char result: " + myResult); // prints F
    }
}
```

### Output:
```
int value: 10
double value: 10.0
double pi: 3.14
int numPi: 3
char result: F