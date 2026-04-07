public class Main {

    public static void main(String[] args) {

        int dayOfWeek = 3;

        // =====================
        // SWITCH STATEMENT
        // =====================

        switch (dayOfWeek) {

            case 1:
                System.out.println("It's Sunday");
                break;

            case 2:
                System.out.println("It's Monday");
                break;

            case 3:
                System.out.println("It's Tuesday");
                break;

            default:
                System.out.println("Unknown");
        }
    }
}
```

### Output (when dayOfWeek = 3):
```
It's Tuesday
```

### Output (when dayOfWeek = 8):
```
Unknown
```

---

### How the Switch Statement Works:
```
switch (variable) {
    case value1:
        // executes if variable == value1
        break;
    case value2:
        // executes if variable == value2
        break;
    default:
        // executes if NO case matches
}