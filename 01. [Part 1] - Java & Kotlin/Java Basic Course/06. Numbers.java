public class Main {

    public static void main(String[] args) {

        // 1. byte - 8-bit integer (-128 to 127)
        byte x = 100;
        // byte x = 130; // ERROR! 130 is outside the byte range

        // 2. short - 16-bit integer (-32,768 to 32,767)
        short y = 7777;
        // short y = 777777; // ERROR! outside the short range

        // 3. int - 32-bit integer (most commonly used for whole numbers)
        int z = 88776655;

        // 4. long - 64-bit integer (very large whole numbers, add L at the end)
        long w = 112233445566778L;
        // long w = 112233445566778; // ERROR! integer number too large without L

        // Printing the values
        System.out.println("byte x = " + x);
        System.out.println("short y = " + y);
        System.out.println("int z = " + z);
        System.out.println("long w = " + w);
    }
}
```

### Output:
```
byte x = 100
short y = 7777
int z = 88776655
long w = 112233445566778