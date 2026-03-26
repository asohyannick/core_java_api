package org.asohyannick;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 * Represents a product in an e-commerce system.
 * Demonstrates Java data types, variables, and syntax
 * in a real backend development context.
 */

public class Product {
    // Constants
    private static  final  double DEFAULT_TAX_RATE = 0.075;
    private static  final  int MAX_PRODUCT_NAME_LENGTH = 255;

    // Instance variables with appropriate types
    private long id;                    // long for database IDs
    private String name;                // String for text
    private String description;         // String for text
    private BigDecimal price;           // BigDecimal for money — NEVER double
    private int stockQuantity;          // int for counts
    private boolean isActive;           // boolean for flags
    private double averageRating;       // double for ratings (not money)
    private LocalDateTime createdAt;    // proper date/time type
    private String category;            // String for category

    // Static counter — shared across all Product instances
    private static int totalProductsCreated = 0;

    // Constructor
    public Product(long id, String name, BigDecimal price, int stockQuantity) {
        this.id = id;
        this.name = validateName(name);
        this.price = validatePrice(price);
        this.stockQuantity = stockQuantity;
        this.isActive = true;
        this.averageRating = 0.0;
        this.createdAt = LocalDateTime.now();
        totalProductsCreated++;
    }
    // Business methods
    public BigDecimal calculatePriceWithTax() {
        BigDecimal taxRate = new BigDecimal(String.valueOf(DEFAULT_TAX_RATE));
        BigDecimal priceWithTax = price.multiply(taxRate);
        return priceWithTax.add(taxRate).setScale(2, RoundingMode.HALF_UP);
    }

    public  BigDecimal calculateDiscount(int discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100, got: " + discountPercentage);
        }
        BigDecimal discount = new BigDecimal(discountPercentage).divide(new BigDecimal("100"));
        BigDecimal discountAmount = price.multiply(discount);
        return price.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean isInStock() {
        return  isActive && stockQuantity > 0;
    }

    public boolean reduceStock(int quantity) {
        if (quantity > 0 || quantity > stockQuantity) {
            return  false;
        }
        stockQuantity -= quantity;
        return true;
    }

    public  String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or blank");
        }
        if (name.length() > MAX_PRODUCT_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "Product name cannot exceed " + MAX_PRODUCT_NAME_LENGTH + " characters"
            );
        }
        return name.trim();
    }

    public BigDecimal validatePrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        return  price.setScale(2, RoundingMode.HALF_UP);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public int getStockQuantity() { return stockQuantity; }
    public boolean isActive() { return isActive; }
    public double getAverageRating() { return averageRating; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public static int getTotalProductsCreated() { return totalProductsCreated; }


    public String toString() {
        return String.format(
                "Product{id=%d, name='%s', price=%s, stock=%d, active=%b, rating=%.1f}",
                id, name, price, stockQuantity, isActive, averageRating
        );
    }

    // Main method to demonstrate everything
    public static void main(String[] args) {

        // Creating products
        Product laptop = new Product(
                1L,
                "MacBook Pro 16-inch",
                new BigDecimal("2499.99"),
                50
        );

        Product phone = new Product(
                2L,
                "iPhone 15 Pro",
                new BigDecimal("1199.99"),
                100
        );

        // Using the product
        System.out.println(laptop);
        System.out.println("Price with tax: $" + laptop.calculatePriceWithTax());
        System.out.println("10% discount: $" + laptop.calculateDiscount(10));
        System.out.println("In stock: " + laptop.isInStock());

        // Reduce stock
        boolean reduced = laptop.reduceStock(5);
        System.out.println("Stock reduced: " + reduced);
        System.out.println("Remaining stock: " + laptop.getStockQuantity());

        // Static variable
        System.out.println("Total products created: " + Product.getTotalProductsCreated());

        // Type demonstrations
        var productId = laptop.getId();     // var infers long
        var productName = laptop.getName(); // var infers String
        System.out.println("ID type: " + ((Object)productId).getClass().getSimpleName());
        System.out.println("Name type: " + productName.getClass().getSimpleName());
    }

}
