public class Main {

    // =====================
    // METHOD WITH NO RETURN TYPE (void)
    // =====================

    static void sayHello() {
        System.out.println("Hello from the method");
    }

    // =====================
    // METHOD WITH RETURN TYPE (int)
    // =====================

    static int addNumbers() {
        int x = 10;
        int y = 20;

        // Method 1 - using a variable
        // int z = x + y;
        // return z;

        // Method 2 - return directly (shorter)
        return x + y;
    }

    // =====================
    // MAIN METHOD
    // =====================

    public static void main(String[] args) {

        // Calling void method
        sayHello();

        // Calling method with return type
        // Option 1 - store result in a variable
        int w = addNumbers();
        System.out.println("The value of w is " + w); // 30

        // Option 2 - call directly inside println
        System.out.println("The value is " + addNumbers()); // 30
    }
}
```

### Output:
```
Hello from the method
The value of w is 30
The value is 30