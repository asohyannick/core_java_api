package org.asohyannick;

import java.util.ArrayList;

public class AutoboxingUnboxing {
   public  static void main(String[] args) {
       // Every primitive has a corresponding Wrapper Class (reference type)
       // byte    → Byte
       // short   → Short
       // int     → Integer
       // long    → Long
       // float   → Float
       // double  → Double
       // char    → Character
       // boolean → Boolean

       // Why do wrapper classes exist?
       // 1. Collections like ArrayList can only hold objects, not primitives
       // 2. Utility methods (Integer.parseInt, Integer.MAX_VALUE, etc.)
       // 3. To represent "no value" with null (primitives can't be null)
       // 4. Generics require reference types

       // AUTOBOXING — Java automatically converts primitive to wrapper

       int primitiveInt = 42;
       Integer wrappedInt = primitiveInt;       // Java does: Integer.valueOf(42)

       double primitiveDouble = 3.14;
       Double wrappedDouble = primitiveDouble;  // Java does: Double.valueOf(3.14)

       boolean primitiveBool = true;
       Boolean wrappedBool = primitiveBool;     // Java does: Boolean.valueOf(true)


       System.out.println("Wrapped int: " + wrappedInt);
       System.out.println("Wrapped double: " + wrappedDouble);

       // UNBOXING - Java automatically converts wrapper to primitive
       Integer boxedValue = Integer.valueOf(100);
       int unboxedValue = boxedValue;  // Java does: boxedValue.intValue()
       System.out.println("Unboxed value: " + unboxedValue);

       // Autoboxing in Collections - happens automatically
       ArrayList<Integer> numbers = new ArrayList<>();
       numbers.add(1);
       numbers.add(2);
       numbers.add(3);
       System.out.println(numbers);

       int first = numbers.get(0); // Integer automatically unboxed to int
       System.out.println("First: " + first);

       Integer nullableInt = null;
       if (nullableInt != null) {
           int safe = nullableInt;
       }

       Integer a = 127;
       Integer b = 127;
       System.out.println(a == b);

       Integer c = 128;
       Integer d = 128;
       System.out.println(c == d);
       System.out.println(c.equals(d));
       System.out.println(Integer.MAX_VALUE);
       System.out.println(Integer.MIN_VALUE);
       System.out.println(Integer.parseInt("42"));
       System.out.println(Integer.toHexString(255));
       System.out.println(Integer.toOctalString(8));
       System.out.println(Double.parseDouble("3.14"));
       System.out.println(Boolean.parseBoolean("true"));
   }
}
