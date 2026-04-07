public class Main {

    public static void main(String[] args) {

        // =====================
        // PRIMITIVE DATA TYPES
        // =====================

        // 1. byte - whole numbers from -128 to 127
        byte myByte = 100;

        // 2. short - whole numbers (larger range than byte)
        short myShort = 32000;

        // 3. int - whole numbers (most commonly used)
        int myInt = 25;

        // 4. long - very large whole numbers (add L at the end)
        long myLong = 1000000000L;

        // 5. float - decimal numbers, single precision (add F at the end)
        float myFloat = 3.14F;

        // 6. double - decimal numbers, double precision (most commonly used)
        double myDouble = 3.14159265;

        // 7. char - single character (use single quotes)
        char myChar = 'A';

        // 8. boolean - true or false only
        boolean myBoolean = true;

        // ==========================
        // NON-PRIMITIVE DATA TYPES
        // ==========================

        // String - sequence of characters (text)
        String myString = "Hello my friends";

        // Array - stores multiple values of the same type
        int[] myArray = {1, 2, 3, 4, 5};

        // =====================
        // PRINTING THE VALUES
        // =====================

        System.out.println("byte: " + myByte);
        System.out.println("short: " + myShort);
        System.out.println("int: " + myInt);
        System.out.println("long: " + myLong);
        System.out.println("float: " + myFloat);
        System.out.println("double: " + myDouble);
        System.out.println("char: " + myChar);
        System.out.println("boolean: " + myBoolean);
        System.out.println("String: " + myString);
    }
}
```

### Output:
```
byte: 100
short: 32000
int: 25
long: 1000000000
float: 3.14
double: 3.14159265
char: A
boolean: true
String: Hello my friends