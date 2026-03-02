package org.asohyannick;

public class BitwiseOperators {
    public static void main(String[] args) {

        int a = 0b1010; // binary 1010 = decimal 10
        int b = 0b1100; // binary 1100 = decimal 12

        System.out.println("a = " + Integer.toBinaryString(a) + " (" + a + ")"); // 1010 (10)
        System.out.println("b = " + Integer.toBinaryString(b) + " (" + b + ")"); // 1100 (12)


        int andResult = a & b;
        System.out.println("a & b = " + Integer.toBinaryString(andResult) + " (" + andResult + ")"); // 1000 (8)



        int orResult = a | b;
        System.out.println("a | b = " + Integer.toBinaryString(orResult) + " (" + orResult + ")"); // 1110 (14)


        int xorResult = a ^ b;
        System.out.println("a ^ b = " + Integer.toBinaryString(xorResult) + " (" + xorResult + ")"); // 110 (6)

        System.out.println("a ^ a = " + (a ^ a)); // 0
        System.out.println("a ^ 0 = " + (a ^ 0)); // 10 (a unchanged)

        int x = 5, y = 10;
        System.out.println("Before swap: x=" + x + ", y=" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap:  x=" + x + ", y=" + y); // x=10, y=5


        int n = 5;
        int notN = ~n;
        System.out.println("~5 = " + notN); // -6


        int val = 1;
        System.out.println("1 << 0 = " + (val << 0));  // 1   (1 * 2^0)
        System.out.println("1 << 1 = " + (val << 1));  // 2   (1 * 2^1)
        System.out.println("1 << 2 = " + (val << 2));  // 4   (1 * 2^2)
        System.out.println("1 << 3 = " + (val << 3));  // 8   (1 * 2^3)
        System.out.println("1 << 4 = " + (val << 4));  // 16  (1 * 2^4)
        System.out.println("1 << 10 = " + (val << 10));// 1024

        int number = 10;
        System.out.println("10 << 1 = " + (number << 1)); // 20 (10 * 2)
        System.out.println("10 << 2 = " + (number << 2)); // 40 (10 * 4)
        System.out.println("10 << 3 = " + (number << 3)); // 80 (10 * 8)


        System.out.println("16 >> 1 = " + (16 >> 1)); // 8  (16 / 2)
        System.out.println("16 >> 2 = " + (16 >> 2)); // 4  (16 / 4)
        System.out.println("16 >> 3 = " + (16 >> 3)); // 2  (16 / 8)
        System.out.println("16 >> 4 = " + (16 >> 4)); // 1  (16 / 16)
        System.out.println("16 >> 5 = " + (16 >> 5)); // 0

        int negative = -16;
        System.out.println("-16 >> 1 = " + (negative >> 1)); // -8 — sign preserved

        System.out.println("-16 >> 1  = " + (-16 >> 1));   // -8  (sign preserved)
        System.out.println("-16 >>> 1 = " + (-16 >>> 1));  // Large positive number

        // ─────────────────────────────────────────
        // REAL-WORLD USE CASES
        // ─────────────────────────────────────────

        // 1. PERMISSION FLAGS — the most common real backend use case
        // Each bit represents a permission using powers of 2
        final int PERMISSION_READ    = 1;       // 0001
        final int PERMISSION_WRITE   = 1 << 1;  // 0010 = 2
        final int PERMISSION_DELETE  = 1 << 2;  // 0100 = 4
        final int PERMISSION_ADMIN   = 1 << 3;  // 1000 = 8

        // Assign multiple permissions with OR
        int userPermissions = PERMISSION_READ | PERMISSION_WRITE;
        System.out.println("\nPermissions: " + Integer.toBinaryString(userPermissions)); // 11

        // Check if user has a specific permission with AND
        boolean canRead  = (userPermissions & PERMISSION_READ)   != 0;
        boolean canWrite = (userPermissions & PERMISSION_WRITE)  != 0;
        boolean canDelete= (userPermissions & PERMISSION_DELETE) != 0;

        System.out.println("Can read:   " + canRead);   // true
        System.out.println("Can write:  " + canWrite);  // true
        System.out.println("Can delete: " + canDelete); // false

        // Grant a permission with OR
        userPermissions |= PERMISSION_DELETE;
        System.out.println("After granting delete: " + Integer.toBinaryString(userPermissions)); // 111

        // Revoke a permission with AND NOT (~)
        userPermissions &= ~PERMISSION_WRITE;
        System.out.println("After revoking write: " + Integer.toBinaryString(userPermissions)); // 101

        // Toggle a permission with XOR
        userPermissions ^= PERMISSION_READ; // toggle read
        System.out.println("After toggling read: " + Integer.toBinaryString(userPermissions)); // 100

        // 2. FAST MULTIPLICATION/DIVISION BY POWERS OF 2
        int bytes = 1024;
        int kilobytes = bytes >> 10;  // divide by 1024
        int megabytes = bytes >> 20;  // divide by 1048576
        System.out.println("\n" + bytes + " bytes = " + kilobytes + " KB");

        // 3. CHECKING ODD/EVEN — faster than % 2
        int num = 42;
        boolean isEven = (num & 1) == 0; // last bit is 0 for even, 1 for odd
        boolean isOdd  = (num & 1) == 1;
        System.out.println(num + " is even: " + isEven); // true
        System.out.println(num + " is odd:  " + isOdd);  // false

        // 4. EXTRACTING COLOR CHANNELS from an RGB integer
        int rgbColor = 0xFF5733; // An orange-ish color — format: 0xRRGGBB

        int red   = (rgbColor >> 16) & 0xFF; // shift right 16 bits, keep last 8
        int green = (rgbColor >> 8)  & 0xFF; // shift right 8 bits, keep last 8
        int blue  =  rgbColor        & 0xFF; // keep last 8 bits

        System.out.println("\nColor 0xFF5733:");
        System.out.println("Red:   " + red);   // 255
        System.out.println("Green: " + green); // 87
        System.out.println("Blue:  " + blue);  // 51
    }
}