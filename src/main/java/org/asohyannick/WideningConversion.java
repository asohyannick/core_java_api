package org.asohyannick;

public class WideningConversion {
    public static void main(String[] args) {
        byte b = 42;
        short s = b;    // byte → short (automatic, no cast needed)
        int i = s;      // short → int (automatic)
        long l = i;     // int → long (automatic)
        float f = l;    // long → float (automatic)
        double d = f;   // float → double (automatic)

        System.out.println("byte: " + b);    // 42
        System.out.println("short: " + s);   // 42
        System.out.println("int: " + i);     // 42
        System.out.println("long: " + l);    // 42
        System.out.println("float: " + f);   // 42.0
        System.out.println("double: " + d);  // 42.0

        printDouble(42);
        printDouble(42L);
        printDouble(42.0f);
    }
    static void printDouble(double value) {
        System.out.println("As double: " + value);
    }
}
