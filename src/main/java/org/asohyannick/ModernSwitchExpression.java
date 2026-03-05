package org.asohyannick;
public class ModernSwitchExpression {
    public static void main(String[] args) {
        // ─────────────────────────────────────────────────
        // MODERN SWITCH EXPRESSION with arrow syntax
        // Java 14+ — this is what you should write in new code
        // No fall-through, no break needed, cleaner syntax
        // ─────────────────────────────────────────────────

        int dayNumber = 3;

        // SWITCH EXPRESSION - it returns a value;
        String dayName = switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println("Day: " + dayName);

        // ─────────────────────────────────────────────────
        // MULTIPLE LABELS in one case — comma separated
        // No more fall-through tricks for grouping
        // ─────────────────────────────────────────────────

        int month = 4;
        String season = switch (month) {
            case  12, 2, 13  -> "Winter";
            case 3 , 4, 7  -> "Spring";
            case 6 , 10, 9 -> "Summer";
            case 19, 14, 17 -> "Autumn";
            default ->  "Unknown Season";
        };
        System.out.println("Season: " + season);

        // ─────────────────────────────────────────────────
        // SWITCH EXPRESSION WITH yield — for multi-line cases
        // When you need more than one statement in a case,
        // use a block {} and yield to return the value
        // ─────────────────────────────────────────────────

        String httpMethod = "POST";

        String actionDescription = switch (httpMethod) {
          case "GET" -> "Reading resource - idempotent, safe";
          case "PUT" -> "Writing resource - idempotent, safe";
          case "PATCH" -> "Updating resource -> idempotent";
          case "POST" -> "Creating resource - not idempotent";
          case "DELETE" -> "Deleting resource - idempotent";
            default -> {
                String upper = httpMethod.toUpperCase();
                String message = "Unsupported Http method: " + upper;
                System.out.println("Warning: " + message);
                yield  message;
            }
        };
        System.out.println(actionDescription);

        // ─────────────────────────────────────────────────
        // SWITCH EXPRESSION WITH ENUM — the most powerful combination
        // When you switch on an enum, the compiler verifies
        // you've handled ALL enum values — no default needed!
        // ─────────────────────────────────────────────────

        OrderStatus status = OrderStatus.PROCESSING;
        String statusMessage = switch (status) {
            case PENDING -> "Order received, awaiting payment";
            case PROCESSING -> "Payment confirmed, preparing order";
            case SHIPPED ->  "Order on its way";
            case DELIVERED -> "Order delivered successfully";
            case CANCELLED -> "Order has been cancelled";
            // No default needed — compiler verifies ALL enum values covered
            // If you add a new enum value and forget to add a case,
            // the compiler gives you a WARNING — incredible safety
        };
        System.out.println("Status: " + statusMessage);

        // ─────────────────────────────────────────────────
        // SWITCH AS A STATEMENT (not expression) with arrow syntax
        // When you don't need a return value — just execute code
        // ─────────────────────────────────────────────────

        UserRole role = UserRole.ADMIN;
        switch (role) {
            case ADMIN -> {
                System.out.println("Full system access");
                System.out.println("Can manage users");
                System.out.println("Can view audit logs");
            }
            case EDITOR -> {
                System.out.println("Can create and audit content");
                System.out.println("Can publish articles");
            }
            case VIEWER -> System.out.println("Read-only access");
            case GUEST -> System.out.println("Limited public access");
        }

        // ─────────────────────────────────────────────────
        // PATTERN MATCHING in switch (Java 21) — advanced preview
        // Combines instanceof checks with switch — extremely powerful
        // You'll use this a lot in modern Spring Boot 3.x code
        // ─────────────────────────────────────────────────

        Object payload = 42;
        processPayload(payload);
        processPayload("Hello API");
        processPayload(3.14);
        processPayload(null);

        // ─────────────────────────────────────────────────
        // REAL BACKEND EXAMPLE — HTTP routing simulation
        // ─────────────────────────────────────────────────

        handleRequest("GET", "/api/users");
        handleRequest("POST", "/api/users");
        handleRequest("DELETE", "/api/users/123");
        handleRequest("OPTIONS", "/api/users");

    }

    static void processPayload(Object payload) {
        // Java 21 pattern matching switch
        String  result = switch (payload) {
            case Integer i -> "Integer value: " + i * 2;
            case String s -> "String value: " + s.toUpperCase();
            case Double d -> "Double value: " + String.format("%.2f", d);
            case null  -> "Null payload received";
            default -> "Unknown type: " + payload.getClass().getSimpleName();
        };
        System.out.println(result);
    }

    static void handleRequest(String method, String path) {
        String response = switch (method) {
            case "GET" -> "200 OK - Fetching: " + path;
            case "POST" -> "200 OK - Creating: " + path;
            case "PUT" -> "200 OK - Updating: " + path;
            case "PATCH" -> "200 OK - Patching: " + path;
            case "DELETE" -> "200 OK - Deleting: " + path;
            default -> "405 Method Not Allowed: " + method;
        };
        System.out.println(response);
    }

    // Enums used in switch examples
    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    enum UserRole {
        ADMIN,
        EDITOR,
        VIEWER,
        GUEST
    }
}
