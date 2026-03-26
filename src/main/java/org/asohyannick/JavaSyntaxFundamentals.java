package org.asohyannick;
import java.math.BigDecimal;
public class JavaSyntaxFundamentals {

    // static constant - class level

    private  static final String VERSION = "1.0";


    // Instance  variable - object value
     private String name;
     private String description;
     private BigDecimal price;
     private BigDecimal tax;

     // Constructor
    public JavaSyntaxFundamentals(String name, String description, BigDecimal price, BigDecimal tax) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
    }

    // Instance method
    public String getInfo() {
        return String.format("Name: %s, Age: %d", name, description, price, tax);
    }

    // Static method — entry point of any Java application
    public static void main(String[] args) {

        // ═══════════════════════════════════════
        // COMMENTS
        // ═══════════════════════════════════════

        // Single-line comment

        /* Multi-line comment
           spans multiple lines */

        /**
         * Javadoc comment — generates HTML documentation
         * Used for classes, methods, and fields
         * @param args command line arguments
         */

        // ═══════════════════════════════════════
        // OPERATORS
        // ═══════════════════════════════════════

        // Arithmetic operators
        int a = 10;
        int b = 3;
        System.out.println(a + b);   // 13 — addition
        System.out.println(a - b);   // 7  — subtraction
        System.out.println(a * b);   // 30 — multiplication
        System.out.println(a / b);   // 3  — integer division (truncates!)
        System.out.println(a % b);   // 1  — modulo (remainder)

        // Assignment operators
        int x = 10;
        x += 5;   // x = x + 5  → 15
        x -= 3;   // x = x - 3  → 12
        x *= 2;   // x = x * 2  → 24
        x /= 4;   // x = x / 4  → 6
        x %= 4;   // x = x % 4  → 2
        System.out.println("x after operations: " + x); // 2

        // Increment and Decrement
        int count = 5;
        System.out.println(count++); // 5 — post-increment: uses then increments
        System.out.println(count);   // 6
        System.out.println(++count); // 7 — pre-increment: increments then uses
        System.out.println(count--); // 7 — post-decrement
        System.out.println(count);   // 6

        // Comparison operators — always return boolean
        System.out.println(10 > 5);   // true
        System.out.println(10 < 5);   // false
        System.out.println(10 >= 10); // true
        System.out.println(10 <= 9);  // false
        System.out.println(10 == 10); // true — for primitives only!
        System.out.println(10 != 5);  // true

        // Logical operators
        System.out.println(true && false); // false — AND
        System.out.println(true || false); // true  — OR
        System.out.println(!true);         // false — NOT

        // Ternary operator — compact if/else for single expressions
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println(status); // Adult

        // String concatenation with +
        String firstName = "John";
        String lastName = "Doe";
        int userAge = 30;
        String fullInfo = firstName + " " + lastName + " is " + userAge + " years old";
        System.out.println(fullInfo);

        // ═══════════════════════════════════════
        // PRINTING OUTPUT
        // ═══════════════════════════════════════

        System.out.println("Prints with newline at end");
        System.out.print("Prints without newline");
        System.out.print(" — continues on same line\n");
        System.out.printf("Formatted: %s is %d years old%n", "Alice", 25);
        // %s = String, %d = integer, %f = float, %n = newline (platform-independent)

        // Modern alternative — String.format()
        String msg = String.format("%.2f", 3.14159);
        System.out.println(msg); // 3.14

        // Java 15+ formatted() method directly on String
        System.out.println("Value: %.3f".formatted(3.14159)); // Value: 3.142
    }
}
