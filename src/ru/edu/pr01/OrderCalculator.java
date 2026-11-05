package ru.edu.pr01;

public class OrderCalculator {
    private static final double MAX_DISCOUNT_PERCENT = 30.0;
    private static final double VAT_RATE = 25.0;
    public static boolean isValid(int quantity, double unitPrice, double discountPercent) {
        return quantity > 0
                && quantity <= 10_000
                && unitPrice > 0.0
                && unitPrice <= 5_000_000.0
                && discountPercent >= 0.0
                && discountPercent <= MAX_DISCOUNT_PERCENT;
    }
    public static double calculateBase(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }
    public static double applyDiscount(double base, double discountPercent) {
        return base * (1.0 - discountPercent / 100.0);
    }
    public static double calculateVat(double discounted, double vatPercent) {
        return discounted * vatPercent / 100.0;
    }
    public static double calculateTotal(int quantity, double unitPrice, double discountPercent) {
        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        return discounted + calculateVat(discounted, VAT_RATE);
    }
}
