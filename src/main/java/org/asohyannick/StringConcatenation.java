package org.asohyannick;

import java.util.List;

public class StringConcatenation {
    public static void main(String[] args) {
        // + with Strings triggers concatenation — not addition
        var firstName = "John";
        var lastName = "Smith";
        var fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // ─────────────────────────────────────────
        // THE TRICKY PART — mixing + with numbers and Strings
        // ─────────────────────────────────────────

        // Evaluation goes LEFT to RIGHT
        // Once Java sees a String operand, + becomes concatenation from that point
        System.out.println("Sum: " + 1 + 2);
        // "Sum: " + 1 → "Sum: 1" (concatenation)
        // "Sum: 1" + 2 → "Sum: 12" (concatenation again!)
        // Result: "Sum: 12" (NOT "Sum: 3"!)
        System.out.println("Answer: " + 7  + 3);
        System.out.println("New Answer: " + ( 7 + 3));
        // Parentheses force 1+2=3 first, then concatenation
        // Result: "Sum: 3"

        var num1 = 10;
        int num2 = 10;
        System.out.println("Sum" + num1 + num2);
        System.out.println("Answer: " + ( num1 + num2));

        System.out.println(1 + 3 + " is the sum");
        // 1 + 2 = 3 (both ints, addition)
        // 3 + " is the sum" = "3 is the sum" (concatenation)
        // Result: "3 is the sum"

        System.out.println(1 + 2 + " = " + 1 + 2);
        // 1 + 2 = 3 (int + int = int)
        // 3 + " = " = "3 = " (int + String = String)
        // "3 = " + 1 = "3 = 1" (String + int = String)
        // "3 = 1" + 2 = "3 = 12" (String + int = String)
        // Result: "3 = 12" — surprising!

        // ─────────────────────────────────────────
        // ANY TYPE concatenated with String becomes String
        // ─────────────────────────────────────────

        var flag = true;
        var number = 42;
        var price = 9.99;
        var letter = 'A';
        Object obj = null;

        System.out.println("flag: " + flag);     // flag: true
        System.out.println("number: " + number); // number: 42
        System.out.println("price: " + price);   // price: 9.99
        System.out.println("letter: " + letter); // letter: A
        System.out.println("obj: " + obj);       // obj: null (null becomes "null")

        // ─────────────────────────────────────────
        // PERFORMANCE — StringBuilder vs + in loops
        // ─────────────────────────────────────────


        // String + in loop — creates a new String object every iteration
        // This is O(n²) complexity — gets slow for large n

        var badResult = "";
        for (int i = 0; i < 10; i++) {
            badResult = badResult + i + ", ";
        }
        System.out.println("Bad way: " + badResult);

        // StringBuilder — modifies the same object, O(n) complexity

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(", ");  // Method chaining — same StringBuilder
        }

        // StringBuilder methods
        StringBuilder builder = new StringBuilder();
        builder.append("World");
        builder.insert(5, ", ");
        builder.replace(7, 12, "Java");
        builder.delete(5, 6);
        builder.reverse();
        System.out.println(builder.toString());

        // Modern Java — String.join() for clean concatenation
        String joined = String.join(", ", "apple", "banana", "cherry");
        String newJoined = String.join(" | ", joined);
        System.out.println(newJoined);

        List<String>  items = List.of("apple", "banana", "cherry");
        String fromList = String.join(" | ", items);
        System.out.println(fromList);
    }
}
