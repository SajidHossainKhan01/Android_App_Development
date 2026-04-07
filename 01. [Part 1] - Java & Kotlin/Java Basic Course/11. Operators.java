public class Main {

    public static void main(String[] args) {

        // =====================
        // ARITHMETIC OPERATORS
        // =====================

        System.out.println("Addition: " + (1 + 2));        // 3
        System.out.println("Subtraction: " + (5 - 2));     // 3
        System.out.println("Multiplication: " + (2 * 3));  // 6
        System.out.println("Division: " + (10 / 5));       // 2
        System.out.println("Modulus: " + (10 % 5));        // 0 (no remainder)
        System.out.println("Modulus: " + (10 % 3));        // 1 (remainder is 1)

        // =====================
        // COMPARISON OPERATORS
        // =====================

        int x = 10;

        System.out.println("x == 9: "   + (x == 9));    // false
        System.out.println("x == 10: "  + (x == 10));   // true
        System.out.println("x != 10: "  + (x != 10));   // false
        System.out.println("x != 99: "  + (x != 99));   // true
        System.out.println("x > 100: "  + (x > 100));   // false
        System.out.println("x < 100: "  + (x < 100));   // true
        System.out.println("x >= 10: "  + (x >= 10));   // true
        System.out.println("x <= 10: "  + (x <= 10));   // true

        // =====================
        // LOGICAL OPERATORS
        // =====================

        boolean isSunny = true;
        boolean needUmbrella = false;

        // AND operator - both conditions must be true
        boolean shouldGoOutside = isSunny && !needUmbrella;
        System.out.println("Should go outside: " + shouldGoOutside); // true

        // OR operator - at least one condition must be true
        boolean canPlayGames = isSunny || needUmbrella;
        System.out.println("Can play games: " + canPlayGames); // true

        // NOT operator - reverses the boolean value
        System.out.println("Is not sunny: " + !isSunny);       // false
        System.out.println("No umbrella needed: " + !needUmbrella); // true
    }
}
```

### Output:
```
Addition: 3
Subtraction: 3
Multiplication: 6
Division: 2
Modulus: 0
Modulus: 1
x == 9: false
x == 10: true
x != 10: false
x != 99: true
x > 100: false
x < 100: true
x >= 10: true
x <= 10: true
Should go outside: true
Can play games: true
Is not sunny: false
No umbrella needed: true