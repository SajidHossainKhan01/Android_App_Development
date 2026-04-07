public class Main {

    public static void main(String[] args) {

        // =====================
        // NORMAL FOR LOOP (no break or continue)
        // =====================

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // Output: 0 1 2 3 4 5 6 7 8 9

        // =====================
        // BREAK STATEMENT
        // stops the loop when i == 4
        // =====================

        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break; // exits the loop completely
            }
            System.out.println(i);
        }
        // Output: 0 1 2 3

        // =====================
        // CONTINUE STATEMENT
        // skips the current iteration when i == 4
        // =====================

        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue; // skips printing 4 and continues the loop
            }
            System.out.println(i);
        }
        // Output: 0 1 2 3 5 6 7 8 9
    }
}
```

### Output:

**Normal for loop:**
```
0 1 2 3 4 5 6 7 8 9
```

**With break:**
```
0 1 2 3
```

**With continue:**
```
0 1 2 3 5 6 7 8 9