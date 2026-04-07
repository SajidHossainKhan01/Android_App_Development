public class Main {

    public static void main(String[] args) {

        // 1. Boolean - can only be true or false

        // Example 1: is it raining?
        boolean isRaining = true;
        // boolean isRaining = false; // means it's not raining

        // Example 2: has the player collected all coins?
        boolean allCoinsCollected = false;
        // When the player collects all coins, update to true
        allCoinsCollected = true;

        // Printing the values
        System.out.println("Is it raining? " + isRaining);
        System.out.println("All coins collected? " + allCoinsCollected);
    }
}
```

### Output:
```
Is it raining? true
All coins collected? true