public class Main {

    public static void main(String[] args) {

        // =====================
        // CREATING A 2D ARRAY
        // =====================

        int[][] myMatrix = new int[3][3]; // 3 rows and 3 columns

        // =====================
        // STORING VALUES IN THE 2D ARRAY
        // =====================

        // Row 0
        myMatrix[0][0] = 1;
        myMatrix[0][1] = 2;
        myMatrix[0][2] = 3;

        // Row 1
        myMatrix[1][0] = 4;
        myMatrix[1][1] = 5;
        myMatrix[1][2] = 6;

        // Row 2
        myMatrix[2][0] = 7;
        myMatrix[2][1] = 8;
        myMatrix[2][2] = 9;

        // =====================
        // ACCESSING AND PRINTING A SPECIFIC ELEMENT
        // =====================

        // Printing element at row 2, column 0 (value = 7)
        System.out.println("Element at row 2, col 0: " + myMatrix[2][0]);

        // =====================
        // ALTERNATIVE WAY TO CREATE AND INITIALIZE A 2D ARRAY
        // with predefined values
        // =====================

        int[][] myMatrix2 = {
            {1, 2, 3},  // row 0
            {4, 5, 6},  // row 1
            {7, 8, 9}   // row 2
        };

        // =====================
        // PRINTING ALL ELEMENTS USING FOR EACH LOOP
        // =====================

        for (int[] row : myMatrix2) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // new line after each row
        }
    }
}
```

### Output:
```
Element at row 2, col 0: 7
1 2 3
4 5 6
7 8 9