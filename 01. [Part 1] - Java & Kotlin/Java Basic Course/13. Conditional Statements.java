public class Main {

    public static void main(String[] args) {

        int age = 15;

        // =====================
        // IF STATEMENT
        // =====================

        if (age >= 18) {
            System.out.println("You're an adult");
        }

        // =====================
        // IF - ELSE STATEMENT
        // =====================

        if (age >= 18) {
            System.out.println("You're an adult");
        } else {
            System.out.println("You're a minor");
        }

        // =====================
        // IF - ELSE IF - ELSE STATEMENT
        // =====================

        if (age > 18) {
            System.out.println("You're an adult");
        } else if (age == 60) {
            System.out.println("You're an aged person");
        } else {
            System.out.println("You're a minor");
        }
    }
}
```

### Output (when age = 15):
```
You're a minor
You're a minor
```

### Output (when age = 40):
```
You're an adult
You're an adult
```

### Output (when age = 60):
```
You're an aged person
```

---

### How Each Statement Works:
```
if (condition) {
    // executes if condition is TRUE
} else if (anotherCondition) {
    // executes if first condition is FALSE and this condition is TRUE
} else {
    // executes if ALL conditions above are FALSE
}