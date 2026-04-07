public class Main {

    public static void main(String[] args) {

        // =====================
        // CREATING AND FILLING THE ARRAY
        // =====================

        int[] numbersArray = new int[5];

        numbersArray[0] = 10;
        numbersArray[1] = 20;
        numbersArray[2] = 30;
        numbersArray[3] = 40;
        numbersArray[4] = 50;

        // =====================
        // FOR EACH LOOP
        // iterates through all elements in the array
        // =====================

        for (int num : numbersArray) {
            System.out.println(num);
        }
    }
}
```

### Output:
```
10
20
30
40
50