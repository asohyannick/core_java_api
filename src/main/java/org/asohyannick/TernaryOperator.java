package org.asohyannick;

public class TernaryOperator {
    public static void main(String[] args) {
        // SYNTAX: condition ? valueIfTrue : valueIfFalse

        // ─────────────────────────────────────────
        // BASIC USAGE
        // ─────────────────────────────────────────

        int age = 20;

        // Traditional if/else
        String status;
        if (age >= 18) {
            status = "Adult";
        } else {
            status = "Minor";
        }
        String result = (age >= 18) ? "Adult" : "Infant";
        System.out.println(status);
        System.out.println(result);

        // ─────────────────────────────────────────
        // TERNARY WITH DIFFERENT TYPES
        // ─────────────────────────────────────────

        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        int min = (a < b) ? a : b;
        System.out.println("Max: " + max); // 20
        System.out.println("Min: " + min); // 10

        // With method calls
        double value = -3.14;
        double absolute = (value >= 0) ? value : -value;
        System.out.println("Absolute: " + absolute); // 3.14

        var score = 75;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "F";
        System.out.println("Grade: " + grade); // C
        // When nesting gets complex — use if/else instead for readability
        // Deep nesting kills readability — ALWAYS prefer clarity over brevity

        // ─────────────────────────────────────────
        // NULL SAFETY WITH TERNARY
        // ─────────────────────────────────────────

        String username = null;
        String displayName = (username != null) ? username : "Anonymous";
        System.out.println("Display: " + displayName); // Anonymous
        // Getting a value with fallback

        String configValue = System.getProperty("app.timeout");
        int timeout = (configValue != null) ? Integer.parseInt(configValue) : 30;
        System.out.println("Timeout: " + timeout + "s"); // 30s

        // ─────────────────────────────────────────
        // TERNARY IN STRING FORMATTING
        // ─────────────────────────────────────────
        int itemCount = 1;
        System.out.println("You have " + itemCount + " item" + (itemCount == 1 ? "" : "s"));

        // ─────────────────────────────────────────
        // REAL BACKEND USE CASES
        // ─────────────────────────────────────────

        // HTTP response status text

        // HTTP response status text

        var statusCode = 200;
        String statusText = (statusCode >= 200 && statusCode <= 300) ? "Success" : "Error";
        // Default values for optional request parameters

        String sortedDirection = null;
        String resolvedDirection = (sortedDirection  != null) ? sortedDirection : "ASC";

        var featuredEnabled = true;

        String endpoint = featuredEnabled ? "api/v2/users" : "api/v1/auth";
        System.out.println("Status: " + statusText);    // success
        System.out.println("Sort: " + resolvedDirection);    // ASC
        System.out.println("Endpoint: " + endpoint);    // /api/v2/user

        var isDebug = true;
        System.out.println("[" + (isDebug ? "Debug" : "Not Debug") + "] Server started");

    }
}
