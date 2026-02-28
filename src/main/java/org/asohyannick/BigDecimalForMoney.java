package org.asohyannick;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalForMoney {
    public static void main(String[] args) {
        // WHY BIGDECIMAL?
        // Floating point types (float, double) cannot represent many
        // decimal fractions exactly in binary — they approximate
        double wrong = 0.1 + 0.2;
        System.out.println("double: 0.1 + 0.2 = " + wrong); // 0.30000000000000004

        // BigDecimal represents exact decimal arithmetic
        // ALWAYS create from String, never from double

        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        BigDecimal correct = bd1.add(bd2);
        System.out.println("BigDecimal: 0.1 + 0.2 = " + correct); // 0.3 exactly!

       BigDecimal price = new BigDecimal("0.1");
       BigDecimal taxRate = new BigDecimal("0.3");
       BigDecimal tax = price.multiply(taxRate);
       BigDecimal totalPrice = price.add(tax);

       BigDecimal roundedTotal = totalPrice.setScale(2, RoundingMode.HALF_UP);
       System.out.println("Price" + price);
       System.out.println("Tax" + tax);
       System.out.println("Total" + roundedTotal);


        BigDecimal fromDouble = new BigDecimal(0.1); // Don't do this!
        System.out.println("From double: " + fromDouble);

        // BigDecimal arithmetic operations
        BigDecimal a = new BigDecimal("100.00");
        BigDecimal b = new BigDecimal("3.00");

        System.out.println("Add: " + a.add(b));           // 103.00
        System.out.println("Subtract: " + a.subtract(b)); // 97.00
        System.out.println("Multiply: " + a.multiply(b)); // 300.00
        System.out.println("Divide: " + a.divide(b, 2, RoundingMode.HALF_UP));

    }
}
