package org.asohyannick;

public class ForLoop {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────────
        // BASIC for LOOP ANATOMY
        // for (initialization; condition; update) { body }
        // ─────────────────────────────────────────────────

        //    ┌─ initialization (runs ONCE before loop starts)
        //    │        ┌─ condition (checked BEFORE each iteration)
        //    │        │         ┌─ update (runs AFTER each iteration)
        //    │        │         │
        for (int i = 0; i <= 11; i++) {
            System.out.println(i + " ");
        }
        System.out.println();

        // Step-by-step execution trace:
        // 1. int i = 0           → initialization, runs once
        // 2. i < 5 → true        → check condition, enter body
        // 3. print 0             → execute body
        // 4. i++  → i becomes 1  → execute update
        // 5. i < 5 → true        → check condition, enter body
        // 6. print 1             → execute body
        // 7. i++ → i becomes 2   → execute update
        // ... continues...
        // 11. i < 5 → false      → condition fails, loop ends

        // ─────────────────────────────────────────────────
        // COUNTING BACKWARD
        // ─────────────────────────────────────────────────
        for(int i = 10; i >= 0; i--) {
            System.out.println(i + " ");
        }

        // ─────────────────────────────────────────────────
        // CUSTOM INCREMENT
        // ─────────────────────────────────────────────────

        // Count by 2

        for (int i = 0; i <= 100; i += 5) {
            System.out.println(i + " ");
        }

        // ─────────────────────────────────────────────────
        // LOOP VARIABLE SCOPE
        // The loop variable i only exists INSIDE the loop
        // ─────────────────────────────────────────────────

        for (int i = 0; i < 3; i++) {
            System.out.println("i inside loop: " + i);
        }
        // System.out.println(i); // COMPILATION ERROR — i is out of scope

        // If you need the counter value after the loop, declare it outside
        int finalCount = 0;
        for (finalCount = 0; finalCount < 5; finalCount++) {
            // loop body
        }
        System.out.println("Final count: " + finalCount); // 5

        // Multiplication table
        System.out.println("\nMultiplication Table (1-5):");
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.printf("%4d", row * col); // formatted output
            }
            System.out.println(); // new line after each row
        }

        int[][] matrix = {
                {1, 2, 3},
                {2, 5, 6},
                {7, 8, 9}
        };
        System.out.println("\nMatrix:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%3d", matrix[row][col]);
            }
            System.out.println();
        }
        // ─────────────────────────────────────────────────
        // MULTIPLE VARIABLES in for loop
        // ─────────────────────────────────────────────────

        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i=" + i + ", j=" + j);
        }
        // i=0, j=10
        // i=1, j=9
        // i=2, j=8
        // i=3, j=7
        // i=4, j=6

        // ─────────────────────────────────────────────────
        // INFINITE LOOP — and how to break out of it
        // ─────────────────────────────────────────────────
        int attempt = 0;
        for (;;) {
            attempt++;
            if (attempt >= 3) {
                System.out.println("Max attempts reached");
                break; // exits the loop
            }
            System.out.println("Attempt: " + attempt);
        }

        // ─────────────────────────────────────────────────
        // REAL BACKEND USE CASES
        // ─────────────────────────────────────────────────

        // 1. Processing a paginated dataset
        // 1. Processing a paginated dataset
        int totalRecords = 95;
        int pageSize = 10;
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        System.out.println("\nPagination:");
        for (int page = 1; page <= totalPages; page++) {
            int offset = (page - 1) * pageSize;
            int limit = Math.min(pageSize, totalRecords - offset);
            System.out.printf("Page %d: offset=%d, limit=%d%n", page, offset, limit);
        }

        // 2. Retry logic with exponential backoff
        int maxRetries = 5;
        System.out.println("\nRetry with exponential backoff:");
        for (int retry = 0; retry < maxRetries; retry++) {
            long waitMs = (long) Math.pow(2, retry) * 100; // 100, 200, 400, 800, 1600ms
            System.out.printf("Retry %d — waiting %dms before next attempt%n",
                    retry + 1, waitMs);
        }

        // Building a response array
        int[] fibonacci = new int[10];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        System.out.print("\nFibonacci: ");
        for (int num : fibonacci) {
            System.out.print(num + " "); // 0 1 1 2 3 5 8 13 21 34
        }
        System.out.println();
    }
}
