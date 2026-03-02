package org.asohyannick;
public class UnaryOperator {
    public static void main(String[] args) {
        // ─────────────────────────────────────────
        // UNARY PLUS  +  and  UNARY MINUS  -
        // ────────────────────────────────────────
        int positive = +42;   // explicitly positive (rarely used, mostly for clarity)
        int negative = -42;   // negates the value
        int value = 10;
        int negated = -value; // negates a variable

        System.out.println("Positive: " + positive); // 42
        System.out.println("Negative: " + negative); // -42
        System.out.println("Negated: " + negated);   // -10

        // Negating a negative gives positive
        var x = -5;
        System.out.println("-(-5) = " + (-x)); // 5

        // ─────────────────────────────────────────
        // INCREMENT  ++  and  DECREMENT  --
        // ─────────────────────────────────────────

        // These are where most beginner confusion happens
        // There are TWO forms: PRE and POST
        // POST-INCREMENT  i++
        // Returns the CURRENT value THEN increments

        var postOutput = 5;
        var result = postOutput++;
        System.out.println("post-increment result: " + result); // 5
        System.out.println("a after post-increment: " + postOutput);

        // PRE-INCREMENT  ++i
        // Increments FIRST THEN returns the NEW value

        var num1 = 10;
        var num2 = ++num1;
        System.out.println("pre-increment result: " + num2);
        System.out.println("after pre-increment: " + num1);

        int b = 5;
        int preResult = ++b;           // b becomes 6 first, preResult gets 6
        System.out.println("pre-increment result: " + preResult); // 6
        System.out.println("b after pre-increment: " + b);        // 6

        // POST-DECREMENT  i--
        int c = 10;
        int postDec = c--;             // postDec gets 10, c becomes 9
        System.out.println("post-decrement result: " + postDec); // 10
        System.out.println("c after post-decrement: " + c);      // 9

        // PRE-DECREMENT  --i
        int d = 10;
        int preDec = --d;             // d becomes 9 first, preDec gets 9
        System.out.println("pre-decrement result: " + preDec); // 9
        System.out.println("d after pre-decrement: " + d);     // 9


        var num5 = 20;
        var numResult = --num5;
        System.out.println(numResult);
        System.out.println(num5);

        // ─────────────────────────────────────────
        // UNDERSTANDING THE DIFFERENCE IN EXPRESSIONS
        // ─────────────────────────────────────────

        // This is where it gets interesting — behavior inside expressions
        int m = 5;
        int n = 5;

        // These produce DIFFERENT results even though m == n
        System.out.println("Post: " + m++); // prints 5, THEN m becomes 6
        System.out.println("Pre:  " + ++n); // n becomes 6 FIRST, then prints 6
        System.out.println("m = " + m);     // 6
        System.out.println("n = " + n);     // 6

        // A classic tricky expression — understanding this deeply matters
        int p = 5;
        int trickResult = p++ + ++p;
        // Step 1: p++ evaluates to 5 (current), p becomes 6
        // Step 2: ++p increments p to 7, evaluates to 7
        // Step 3: 5 + 7 = 12
        System.out.println("Trick result: " + trickResult); // 12
        System.out.println("p after trick: " + p);          // 7

        var z = 10;
        var newResult = z++ + ++z;
        System.out.println(newResult);
        System.out.println(z);

        var counter = 0;
        counter++;
        counter--;

        for (var i = 0; i < 5; i++) {
            System.out.println(i);
        }

        var isActive = true;
        var isNotActive =  !isActive;
        System.out.println(isActive);
        System.out.println(isNotActive);
        System.out.println("isActive: " + isActive);       // true
        System.out.println("isNotActive: " + isNotActive); // false

        var isEmpty = false;
        if (!isEmpty) {
            System.out.println("Collection is not empty — safe to process");
        } else {
            System.out.println("Keep learning Java buddy!");
        }

        var doubleNegated = !!true;
        System.out.println("Double negated: " + doubleNegated);

        boolean isAuthenticated = checkAuth();
        boolean  hasPermission = checkPermission();

        if (!isAuthenticated) {
            System.out.println("Authorized user:  401");
            return;
        }

        if (!hasPermission) {
            System.out.println("You're not permitted to access this resource: 403");
        }
        System.out.println("20 OK. Proceeding...");
    }

    static boolean checkAuth() {
        return true;
    }

    static boolean checkPermission() {
        return true;
    }
}
