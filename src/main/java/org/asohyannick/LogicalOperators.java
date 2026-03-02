package org.asohyannick;

public class LogicalOperators {
    public static void main(String[] args) {
        // ─────────────────────────────────────────
        // AND  &&
        // Returns true ONLY if BOTH operands are true
        // ─────────────────────────────────────────

        System.out.println("true  && true  = " + (true  && true));  // true
        System.out.println("true  && false = " + (true  && false)); // false
        System.out.println("false && true  = " + (false && true));  // false
        System.out.println("false && false = " + (false && false)); // false

        // ─────────────────────────────────────────
        // OR  ||
        // Returns true if AT LEAST ONE operand is true
        // ─────────────────────────────────────────

        System.out.println("true  || true  = " + (true  || true));  // true
        System.out.println("true  || false = " + (true  || false)); // true
        System.out.println("false || true  = " + (false || true));  // true
        System.out.println("false || false = " + (false || false)); // false

        // ─────────────────────────────────────────
        // NOT  !
        // Inverts the boolean value
        // ─────────────────────────────────────────
        System.out.println("!true  = " + !true);  // false
        System.out.println("!false = " + !false); // true

        // ─────────────────────────────────────────
        // SHORT-CIRCUIT EVALUATION — CRITICAL CONCEPT
        // ─────────────────────────────────────────

        // Java's && and || are SHORT-CIRCUIT operators
        // They stop evaluating as soon as the result is determined

        // && short-circuit: if the LEFT side is false,
        // the RIGHT side is NEVER evaluated
        // Because false && ANYTHING = always false


        String text = null;

        if (text != null && text.length() > 0 ) {
            System.out.println("Text has content");
        } else {
            System.out.println("Text is null or empty");
        }

        // DANGEROUS — no null check first
        // if (text.length() > 0) { } // NullPointerException!

        // || short-circuit: if the LEFT side is true,
        // the RIGHT side is NEVER evaluated
        // Because true || ANYTHING = always true
        boolean hasCache = true;

        // expensiveDatabaseCall() will NEVER execute if hasCache is true
        if (hasCache || expensiveDatabaseCall()) {
            System.out.println("Data available — from cache"); // This prints
        }

        // ─────────────────────────────────────────
        // REAL BACKEND AUTHORIZATION EXAMPLES
        // ─────────────────────────────────────────

        var isAuthenticated = true;
        var isAdmin = false;
        var isOwner = true;
        var isEmailVerified = true;
        var name = "John";
        String lastName = "Smith";
        var numbersOfJohns = 5 + name;
        var isAccountLocked = false;
        // Can access resource if: authenticated AND (admin OR owner) AND not locked

        boolean canAccess = isAuthenticated  && (isAdmin || isOwner) && !isAccountLocked;
        System.out.println("Can access: " + canAccess); // true

       boolean canDeleteUser = isAuthenticated  && (isAdmin || isOwner) && isEmailVerified && !isAccountLocked;
        System.out.println("Can delete user: " + canDeleteUser); // false — not admin

        // API rate limiting check
        int requestsInLastMinute = 45;
        int rateLimit = 60;
        boolean isPremiumUser = false;
        boolean isRateLimited = !isPremiumUser && (requestsInLastMinute > rateLimit);
        System.out.println("Rate limited: " + isRateLimited); // false (45 < 60)
    }

    static boolean expensiveDatabaseCall() {
        return false;
    }
}
