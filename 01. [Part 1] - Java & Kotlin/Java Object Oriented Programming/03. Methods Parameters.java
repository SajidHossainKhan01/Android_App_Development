public class Main {

    // =====================
    // METHOD WITH PARAMETERS
    // =====================

    static int addNumbers(int x, int y) {
        return x + y;
    }

    // =====================
    // MAIN METHOD
    // =====================

    public static void main(String[] args) {

        // Calling the method with arguments 10 and 20
        int sum = addNumbers(10, 20);
        System.out.println("The value of sum is " + sum); // 30

        // You can also pass different arguments
        int sum2 = addNumbers(100, 200);
        System.out.println("The value of sum2 is " + sum2); // 300

        // Or use directly inside println
        System.out.println("Result: " + addNumbers(5, 7)); // 12
    }
}
```

### Output:
```
The value of sum is 30
The value of sum2 is 300
Result: 12