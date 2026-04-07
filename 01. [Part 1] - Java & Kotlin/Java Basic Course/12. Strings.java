public class Main {

    public static void main(String[] args) {

        // =====================
        // CREATING STRINGS
        // =====================

        String sayHello = "Hello";
        String myFriends = "My friends";

        // =====================
        // PRINTING STRINGS
        // =====================

        System.out.println(sayHello);        // prints: Hello
        System.out.println(myFriends);       // prints: My friends

        // =====================
        // CONCATENATION
        // =====================

        // Combining two strings using the + operator
        System.out.println(sayHello + " " + myFriends); // prints: Hello My friends

        // =====================
        // STRING LENGTH
        // =====================

        // Finding the length of a string using the length() method
        int length = myFriends.length();
        System.out.println("Length is: " + length); // prints: Length is 10
    }
}
```

### Output:
```
Hello
My friends
Hello My friends
Length is: 10