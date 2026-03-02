package org.asohyannick;

public class AssignmentOperators {
    public static void main(String[] args) {
        // ─────────────────────────────────────────
        // SIMPLE ASSIGNMENT  =
        // ─────────────────────────────────────────

        var age = 10;
        var married = true;
        var name = "John";

        int a, b, c;
        a = b = c = 100;
        System.out.println("a=" + a + ", b=" + b + ", c=" + c); // 100 100 100

        // ─────────────────────────────────────────
        // COMPOUND ASSIGNMENT OPERATORS
        // Each one is shorthand that performs an operation then assigns
        // ─────────────────────────────────────────

        var value = 20;
        System.out.println("Print 20: " + value);

        value += 5;
        System.out.println("Print 25: " + value);

        value -= 5;
        System.out.println("print 20: " + value);

        value *= 5;
        System.out.println("Print 100: " + value);

        value /= 2;
        System.out.println("Print 50: " + value);

        value %= 3;
        System.out.println("Print the remainder" + value);

        // ─────────────────────────────────────────
        // HIDDEN FEATURE OF COMPOUND OPERATORS
        // They contain an IMPLICIT CAST — this is important!
        // ─────────────────────────────────────────

        byte valValue = 10;

        valValue += 5;
        System.out.println("Print the value 15: " + valValue);

        short ansVal = 200;
        ansVal += 100;
        System.out.println("Print 300: " + ansVal);

        // ─────────────────────────────────────────
        // HIDDEN FEATURE OF COMPOUND OPERATORS
        // They contain an IMPLICIT CAST — this is important!
        // ─────────────────────────────────────────

        byte byteValue = 10;

        // This FAILS — adding int to byte produces int, can't assign to byte
        // byteValue = byteValue + 5; // COMPILATION ERROR!

        // This WORKS — compound operator includes implicit narrowing cast
        byteValue += 5; // Equivalent to: byteValue = (byte)(byteValue + 5)
        System.out.println("byte after +=: " + byteValue); // 15

        // Same applies to short, char
        short shortVal = 100;
        shortVal += 200; // Works — implicit cast included
        System.out.println("short after +=: " + shortVal); // 300


        // ─────────────────────────────────────────
        // BITWISE COMPOUND ASSIGNMENTS
        // ─────────────────────────────────────────
        int flags = 0b1010; // binary 1010 = 10 in decimal

        flags &= 0b1100;   // AND — flags = flags & 0b1100 → 0b1000
        System.out.println("After &=: " + Integer.toBinaryString(flags)); // 1000

        flags |= 0b0011;   // OR  — flags = flags | 0b0011 → 0b1011
        System.out.println("After |=: " + Integer.toBinaryString(flags)); // 1011

        flags ^= 0b1001;   // XOR — flags = flags ^ 0b1001 → 0b0010
        System.out.println("After ^=: " + Integer.toBinaryString(flags)); // 10

        flags <<= 2;       // Left shift — multiply by 4
        System.out.println("After <<=2: " + flags); // 8

        flags >>= 1;       // Right shift — divide by 2
        System.out.println("After >>=1: " + flags); // 4

        // ─────────────────────────────────────────
        // REAL BACKEND USE CASES FOR COMPOUND OPERATORS
        // ─────────────────────────────────────────

        // Running totals in a loop
        int totalRevenue = 0;
        int[] dailySales = {1500, 2300, 1800, 3100, 2750};
        for (int sale : dailySales) {
            totalRevenue += sale;
        }
        System.out.println("Total revenue: " + totalRevenue); // 11450

        // Permission flag management using bitwise operators
        // Each bit represents a permission
        int READ    = 0b0001;  // 1
        int WRITE   = 0b0010;  // 2
        int DELETE  = 0b0100;  // 4
        int ADMIN   = 0b1000;  // 8

        int userPermissions = 0;
        userPermissions |= READ;    // Grant read
        userPermissions |= WRITE;   // Grant write

        System.out.println("Has READ: "  + ((userPermissions & READ)  != 0));  // true
        System.out.println("Has WRITE: " + ((userPermissions & WRITE) != 0));  // true
        System.out.println("Has DELETE: "+ ((userPermissions & DELETE)!= 0));  // false

        // Building a cache key or hash counter
        int requestCount = 0;
        String[] endpoints = {"/api/users", "/api/products", "/api/orders"};
        for (String endpoint : endpoints) {
            requestCount++;
            System.out.println("Request #" + requestCount + " to " + endpoint);
        }
    }
}
