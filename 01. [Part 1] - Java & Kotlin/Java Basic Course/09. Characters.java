public class Main {

    public static void main(String[] args) {

        // 1. char - holds a single letter
        char myCharacter = 'A';

        // 2. char - holds a single number
        char myNumber = '7';

        // 3. char - holds a single symbol
        char mySymbol = '$';

        // 4. char - escape sequence for new line
        char newLine = '\n';

        // 5. char - escape sequence for tab
        char tab = '\t';

        // Printing the values
        System.out.println("Letter: " + myCharacter);
        System.out.println("Number: " + myNumber);
        System.out.println("Symbol: " + mySymbol);
        System.out.println("New line char: " + newLine + "after new line");
        System.out.println("Tab char: " + tab + "after tab");
    }
}
```

### Output:
```
Letter: A
Number: 7
Symbol: $
New line char: 
after new line
Tab char:     after tab