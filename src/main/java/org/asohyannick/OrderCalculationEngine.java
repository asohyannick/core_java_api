package org.asohyannick;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class OrderCalculationEngine {

    // Permission constants using bit flags
    static final int PERM_VIEW = 1;
    static final  int PERM_CREATE = 1 << 1;
    static final int PERM_UPDATE = 1 << 2;
    static final int PERM_DELETE = 1 << 3;
    public static void main(String[] args) {
        // Order details
        int quantity = 3;
        BigDecimal unitPrice = new BigDecimal("49.99");
        int discountPercent = 10;
        BigDecimal taxRate = new BigDecimal("0.075");
        boolean isPremiumMember = true;
        boolean hasPromoCode = false;
        int userPermissions = PERM_VIEW | PERM_CREATE | PERM_UPDATE;

        // ── STEP 1: Permission check using bitwise operators ──
        boolean canCreateOrder = (userPermissions & PERM_CREATE) != 0;
        System.out.println("Can create order: " + canCreateOrder); // true

        if (!canCreateOrder) {
            System.out.println("403 Forbidden — insufficient permissions");
            return;
        }
        // ── STEP 2: Validate inputs using relational and logical operators ──
        boolean isValidQuantity = quantity > 0 && quantity <= 100;
        boolean isValidPrice = unitPrice != null
                && unitPrice.compareTo(BigDecimal.ZERO) > 0;
        boolean isValidDiscount = discountPercent >= 0 && discountPercent <= 100;

        if (!isValidQuantity || !isValidPrice || !isValidDiscount) {
            System.out.println("400 Bad Request — invalid order data");
            return;
        }

        // ── STEP 3: Calculate subtotal using arithmetic ──
        BigDecimal quantityBD = new BigDecimal(quantity);
        BigDecimal subtotal = unitPrice.multiply(quantityBD);

        // ── STEP 4: Apply discount using compound expressions ──
        BigDecimal discountMultiplier = BigDecimal.ONE.subtract(
                new BigDecimal(discountPercent).divide(new BigDecimal("100"))
        );
        BigDecimal discountedSubtotal = subtotal.multiply(discountMultiplier);

        // ── STEP 5: Premium member bonus using ternary ──
        BigDecimal premiumBonus = isPremiumMember
                ? discountedSubtotal.multiply(new BigDecimal("0.05"))
                : BigDecimal.ZERO;
        BigDecimal afterPremium = discountedSubtotal.subtract(premiumBonus);

        // ── STEP 6: Calculate tax ──
        BigDecimal taxAmount = afterPremium.multiply(taxRate);
        BigDecimal totalAmount = afterPremium.add(taxAmount)
                .setScale(2, RoundingMode.HALF_UP);

        // ── STEP 7: Determine shipping using logical operators ──
        boolean freeShipping = isPremiumMember
                || totalAmount.compareTo(new BigDecimal("100")) >= 0
                || hasPromoCode;
        BigDecimal shippingCost = freeShipping
                ? BigDecimal.ZERO
                : new BigDecimal("9.99");
        BigDecimal finalTotal = totalAmount.add(shippingCost);

        // ── STEP 8: Build receipt ──
        String memberStatus = isPremiumMember ? "Premium ⭐" : "Standard";
        int itemLabel = quantity;

        System.out.println("\n════════ ORDER SUMMARY ════════");
        System.out.println("Member Status:  " + memberStatus);
        System.out.printf("Items:          %d item%s @ $%s%n",
                quantity,
                (itemLabel == 1 ? "" : "s"),  // ternary for pluralization
                unitPrice);
        System.out.printf("Subtotal:       $%s%n", subtotal.setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Discount (%d%%): -$%s%n", discountPercent,
                subtotal.subtract(discountedSubtotal).setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Premium Bonus:  -$%s%n", premiumBonus.setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Tax (7.5%%):     +$%s%n", taxAmount.setScale(2, RoundingMode.HALF_UP));
        System.out.printf("Shipping:       %s%n", freeShipping ? "FREE" : "$" + shippingCost);
        System.out.println("───────────────────────────────");
        System.out.printf("TOTAL:          $%s%n", finalTotal.setScale(2, RoundingMode.HALF_UP));
        System.out.println("════════════════════════════════");

    }
}
