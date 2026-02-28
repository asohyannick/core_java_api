package org.asohyannick;

public class NarrowingConversion {

    public static void main(String[] args) {
        // Narrowing goes from larger to smaller type
        // Data CAN be lost — Java forces you to be explicit with a cast
        // This is your acknowledgment that you know what you're doing

        double d = 9.99;
        int i = (int) d;    // Explicit cast required — truncates, NOT rounds
        System.out.println("double 9.99 cast to int: " + i); // 9 — decimal truncated!

        long bigNumber = 1_000_000_000_000L;
        int smallNumber = (int) bigNumber; // Data loss! int can't hold this value
        System.out.println("long 1 trillion cast to int: " + smallNumber); // garbage value

        int intValue = 65;
        char charValue = (char) intValue;
        System.out.println("int 65 cast to char: " + charValue); // A

        double price = 29.99;
        int roundedPrice = (int) Math.round(price); // Round then cast
        System.out.println("Rounded price: " + roundedPrice); // 30

        // PRACTICAL EXAMPLE — division
        int totalScore = 7;
        int numberOfStudents = 2;

        // Integer division — result truncated to whole number
        int wrongAverage = totalScore / numberOfStudents;
        System.out.println("Integer division: " + wrongAverage); // 3 — WRONG!

        // Cast to double BEFORE dividing to get decimal result
        double correctAverage = (double) totalScore / numberOfStudents;
        System.out.println("Correct average: " + correctAverage); // 3.5

        // Alternatively
        double alsoCorrect = totalScore / (double) numberOfStudents;
        System.out.println("Also correct: " + alsoCorrect); // 3.5
    }

}
