package org.asohyannick;

/**
 Operator Precedence — The Complete Picture
 Precedence determines which operators are evaluated first when an expression contains multiple operators.
 This is one of the most important things to internalize because getting it wrong causes silent logic bugs.
 */
public class OperatorPrecedence {
    public static void main(String[] args) {
        // ─────────────────────────────────────────
        // PRECEDENCE TABLE (highest to lowest)
        // ─────────────────────────────────────────
        //
        // Level 1 (highest):  () [] . (postfix) ++ --
        // Level 2:            ++ -- (prefix) + - (unary) ~ !
        // Level 3:            * / %
        // Level 4:            + - (binary)
        // Level 5:            << >> >>>
        // Level 6:            < > <= >= instanceof
        // Level 7:            == !=
        // Level 8:            &
        // Level 9:            ^
        // Level 10:           |
        // Level 11:           &&
        // Level 12:           ||
        // Level 13:           ? :  (ternary)
        // Level 14 (lowest):  = += -= *= /= %= &= |= ^= <<= >>= >>>=

        // ─────────────────────────────────────────
        // MULTIPLICATION before ADDITION
        // ─────────────────────────────────────────

        var num1 = 2 + 3 * 4;
        System.out.println("My Answer is: " + num1);

        // Parentheses override — adds first: 5 * 4 = 20

        var num2 = (2 + 5) * 2;
        System.out.println("My Answer is: " + num2);

        // ─────────────────────────────────────────
        // UNARY before BINARY
        // ─────────────────────────────────────────
        // Unary minus applied to a first: (-5) * 2 = -10

        var a = 5;
        var result = (-a) * 2;
        System.out.println("My Answer is: " + result);

        // ─────────────────────────────────────────
        // RELATIONAL before EQUALITY
        // ─────────────────────────────────────────

        boolean num6 = 10 >= 5 == true;
        System.out.println("10 >= 5 == true: " + num6);

        // ─────────────────────────────────────────
        // && before ||
        // ─────────────────────────────────────────

        boolean b1 = true, b2 = false, b3 = true;

        boolean result5 = b1 || b2 && b3;
        // && evaluated first: b1 || (b2 && b3) = true || (false && true)
        //                   = true || false = true
        System.out.println("true || false && true = " + result5); // true

        boolean result6 = (b1 || b2) && b3;
        // Parentheses force || first: (true || false) && true = true && true = true
        System.out.println("(true || false) && true = " + result6); // true
        // Same result here, but with different operands the difference matters:

        boolean result7 = false || false && true;
        // Without parens: false || (false && true) = false || false = false
        System.out.println("false || false && true = " + result7); // false

        boolean result8 = (false || false) && true;
        // With parens: (false || false) && true = false && true = false
        System.out.println("(false || false) && true = " + result8); // false
        // Same here — but watch when values differ:

        // ─────────────────────────────────────────
        // ASSIGNMENT has LOWEST precedence
        // ─────────────────────────────────────────

        int x;
        x = 2 + 3 * 4;
        System.out.println("My Answer is 12: " + x);

        // ─────────────────────────────────────────
        // REAL BUG CAUSED BY PRECEDENCE MISUNDERSTANDING
        // ─────────────────────────────────────────

        int flags = 0b1100;
        int mask  = 0b0100;


        if ((flags & mask) == mask) {
            System.out.println("Mask bit is set");
        }

        // ─────────────────────────────────────────
        // THE GOLDEN RULE
        // ─────────────────────────────────────────

        // When in doubt, use parentheses.
        // Explicit parentheses:
        // 1. Make your intent crystal clear to other developers
        // 2. Prevent precedence-related bugs
        // 3. Make code self-documenting

        // Complex expression WITHOUT parentheses — hard to reason about
        boolean confusing = a > 0 && b2 || !b3 && a < 10;

        // Same expression WITH parentheses — intent is clear
        boolean clear = ( a > 0 & b2) || (!b3 && a < 10);
        System.out.println("Same result: " + (confusing == clear)); // true
    }
}
