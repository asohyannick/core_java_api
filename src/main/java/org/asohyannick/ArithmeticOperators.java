package org.asohyannick;
public class ArithmeticOperators {
    public static void main(String[] args) {
   // ADDITION
        int a = 10;
        int b = 7;
        int result = a + b;
        System.out.println("Addition:" + result);

        // Addition with different types — type promotion happens
        // When you mix types in arithmetic, Java promotes to the larger type
        int intVal = 10;
        double doubleVal = 3.5;
        double result1 = intVal + doubleVal; // int promoted to double automatically
        System.out.println("10 + 3.5 = " + result1); // 13.5

        // Addition with long
        int maxInt = Integer.MAX_VALUE;
        long safeSum = (long) maxInt + 1; // cast to long BEFORE adding to prevent overflow
        System.out.println("Max int + 1 (safe): " + safeSum); // 2147483648

        // ─────────────────────────────────────────
        // SUBTRACTION  -
        // ─────────────────────────────────────────

        int difference = a - b;
        System.out.println(difference);

        // Subtraction resulting in negative
        int negative = b - a;
        System.out.println("3 - 10 = " + negative); // -3

        // ─────────────────────────────────────────
        // MULTIPLICATION  *
        // ─────────────────────────────────────────

        int difference1 = a * b;
        System.out.println(difference1);

        int bigA = 1_000_000;
        int bigB = 1_000_000;
        int overflowed = bigA * bigB;
        long correct = (long) bigA * bigB;
        System.out.println("1M * 1M (overflowed): " + overflowed); // garbage
        System.out.println("1M * 1M (correct): " + correct);

        // DIVISION  /  — THE MOST IMPORTANT ONE TO UNDERSTAND
        // ─────────────────────────────────────────

        // INTEGER DIVISION — truncates towards zero, does NOT round

        int divisionInt = 10 / 3;
        System.out.println("10 / 3 (int) =  " + divisionInt);

        int negative1 = -7 / 2;
        System.out.println("-7 / 2 (int) = " + negative1);

        // FLOATING POINT DIVISION — gives decimal result

        double floatingDivision = 10.0 / 3;
        System.out.println(floatingDivision);

        int itemA = 10;

        int itemB = 3;

        int wrongAnswer = itemA / itemB;

        double correctAnswer = (double) itemA / itemB;
        System.out.println(wrongAnswer);
        System.out.println(correctAnswer);

        // Division by zero behavior
        // int / 0 → ArithmeticException at runtime
        // double / 0.0 → Infinity (no exception)
        double divByZero = 10.0 / 0.0;
        System.out.println("10.0 / 0.0 = " + divByZero);         // Infinity
        System.out.println("-10.0 / 0.0 = " + (-10.0 / 0.0));    // -Infinity
        System.out.println("0.0 / 0.0 = " + (0.0 / 0.0));        // NaN

        // ─────────────────────────────────────────
        // MODULO (REMAINDER)  %
        // ─────────────────────────────────────────

        // Returns the remainder after division
        int reminder = 10 % 3;
        System.out.println(reminder);
        System.out.println(11 % 2);
        System.out.println(10 % 2);
        System.out.println(-7 % 3);
        System.out.println(7 % -3);
        // REAL BACKEND USE CASES FOR MODULO
        // 1. Check if number is even or odd
        int number = 42;
        if (number % 2 == 0)  {
            System.out.println(number + " is even");
        }

        // 2. Circular array indexing — cycling through options
       String[] days = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Satur", "Sun"};
        for ( var i = 0; i < 14; i++) {
            System.out.println(days[i % 7]);
        }
        System.out.println();

        // 3. Rate limiting — check if request count is a multiple of something

        var requestCount = 100;

        var logEveryN = 10;

        if (requestCount % logEveryN == 0) {
            System.out.println("Processed " + requestCount + " requests");
        }

        var numberOfServers = 10;
        for (var requestId = 0; requestId < numberOfServers; requestId++ ) {
            var serverIndex = requestId % numberOfServers;
            System.out.println("Request " + requestId + " → Server " + serverIndex);
        }


    }
}
