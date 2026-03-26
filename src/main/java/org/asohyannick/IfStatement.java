package org.asohyannick;

public class IfStatement {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────────
        // BASIC if
        // ─────────────────────────────────────────────────
        int statusCode = 404;
        if(statusCode == 404) {
            System.out.println("Resource not found!");
        }

        // ─────────────────────────────────────────────────
        // CRITICAL DIFFERENCE FROM JAVASCRIPT
        // Java's if condition MUST be a boolean expression
        // There is NO truthy/falsy concept in Java
        // ────────────────────────────────────────────────

        int count = 0;
        String name = null;

        // JavaScript style — DOES NOT COMPILE in Java
        // if (count) { }      // COMPILATION ERROR — int is not boolean
        // if (name) { }       // COMPILATION ERROR — String is not boolean
        // if (1) { }          // COMPILATION ERROR — int is not boolean

        // Java style — explicit boolean expression required

        if (count == 0) {
            System.out.println("Count is zero.");
        }

        if (name != null) {
            System.out.println("Name is:" + name);
        }

        // ─────────────────────────────────────────────────
        // if-else — two paths
        // ─────────────────────────────────────────────────

        int httpStatus = 200;
        if (httpStatus >= 200  && httpStatus <= 300) {
            System.out.println("Success response");
        } else {
            System.out.println("Non-success response");
        }

        // ─────────────────────────────────────────────────
        // if-else if-else LADDER — multiple paths
        // ─────────────────────────────────────────────────

        int responseCode = 200;

        if (responseCode >= 100 && responseCode < 200) {
            System.out.println("1xx Informational");
        } else if (responseCode >= 200 && responseCode < 300) {
            System.out.println("2xx Success");
        } else if (responseCode >= 300 && responseCode < 400)  {
            System.out.println("3xx Redirectional");
        } else  if (responseCode >= 400 & responseCode < 500) {
            System.out.println("4xx Client Error");
        } else if (responseCode >= 500 && responseCode < 600) {
            System.out.println("5xx Server Error");
        } else  {
            System.out.println("Unknown Status Code");
        }

        // Important: Java evaluates conditions TOP to BOTTOM
        // and stops at the FIRST true condition
        // Order matters — put more specific conditions first

        // ─────────────────────────────────────────────────
        // SINGLE LINE if — braces optional for single statement
        // BUT always use braces — it prevents bugs
        // ─────────────────────────────────────────────────

        // Technically valid — no braces for single statement

        if (count == 0)
            System.out.println("Count is zero");

        // But this is DANGEROUS — Apple's "goto fail" bug in SSL
        // was caused by this exact pattern
        // Always use braces — it's a professional standard

        if (count == 0) {
            System.out.println("Count is Zero");
        }

        // ─────────────────────────────────────────────────
        // NESTED if — if inside another if
        // ─────────────────────────────────────────────────

        var isAuthenticated = true;
        var hasRole = true;
        var isActive = true;

        if (isAuthenticated) {
            if (hasRole) {
                if (isActive) {
                    System.out.println("Full access granted");
                } else  {
                    System.out.println("Account inactive - limited access");
                }
            }  else  {
                System.out.println("No role assigned");
            }
        } else  {
            System.out.println("401 Unauthorized");
        }

        // The above is perfectly valid but gets hard to read quickly
        // In real code, prefer EARLY RETURNS or GUARD CLAUSES
        // to flatten nested conditions — we'll see this shortly

        // ─────────────────────────────────────────────────
        // GUARD CLAUSES — The Professional Pattern
        // Validate and return early to avoid deep nesting
        // This is the standard pattern in Spring Boot services
        // ────────────────────────────────────────────────

        processRequest("user123", "ADMIN", true);
        processRequest(null, "USER", true);
        processRequest("user456", "USER", false);
    }
    // BAD — deeply nested, hard to read
    static void processRequestNested(
            String userId,
            String role,
            boolean isActive
    )  {
        if (userId != null) {
            if (!userId.isBlank()) {
                if (role != null) {
                    if (isActive) {
                        System.out.println("Processing request for: " + userId);
                    } else  {
                        System.out.println("Account not active!");
                    }
                } else  {
                    System.out.println("No role provided");
                }
            } else  {
                System.out.println("User ID is blank");
            }
        } else  {
            System.out.println("User Id is null");
        }
    }

    // GOOD — guard clauses, flat structure, professional standard
    static void processRequest(String userId, String role, boolean isActive) {
        // Guard clause 1 - validate userId
        if (userId == null || userId.isBlank()) {
            System.out.println("400 Bad Request - userId is required");
            return;
        }

        // Guard clause 2 - validate role
        if (role == null) {
            System.out.println("400 Bad Request - role is required");
            return;
        }

        // Guard clause 3 - check active status
        if (!isActive) {
            System.out.println("403 Forbidden - account  not actiev for: " + userId);
            return;
        }
        // Happy path — all validations passed
        // No nesting needed — flat, clean, readable
        System.out.println("Processing request for: " + userId + "[ " + role + "]");
    }
}
