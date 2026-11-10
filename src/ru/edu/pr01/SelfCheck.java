package ru.edu.pr01;

public class SelfCheck {
    private static int total = 0;
    private static int passed = 0;

    private static void check(String name, boolean condition) {
        total++;
        if (condition) {
            passed++;
            System.out.println("PASS " + name);
        } else {
            System.out.println("FAIL " + name);
        }
    }

    public static void main(String[] args) {
        try {
            // Проверка методов расчёта
            check(
                "calculateBase",
                OrderCalculator.calculateBase(2, 100.0) == 200.0
            );
            check(
                "calculateTotal",
                Math.abs(OrderCalculator.calculateTotal(2, 100.0, 10.0) - 225.0) < 0.001
            );

            // Проверка всех строк из sample.csv
            check("CSV 1", OrderCalculator.isValid(12, 2490.50, 5));
            check("CSV 2", OrderCalculator.isValid(100, 150.00, 0));
            check("CSV 3", !OrderCalculator.isValid(0, 1000, 10));
            check("CSV 4", !OrderCalculator.isValid(5, -20, 5));
            check("CSV 5", !OrderCalculator.isValid(3, 999.99, 35));

            // Дополнительные проверки точных границ диапазонов
            check("quantity lower included", OrderCalculator.isValid(1, 100.0, 10.0));
            check("quantity upper included", OrderCalculator.isValid(10_000, 100.0, 10.0));
            check("quantity above upper", !OrderCalculator.isValid(10_001, 100.0, 10.0));

            check("unitPrice lower excluded", !OrderCalculator.isValid(1, 0.0, 10.0));
            check("unitPrice upper included", OrderCalculator.isValid(1, 5_000_000.0, 10.0));
            check("unitPrice above upper", !OrderCalculator.isValid(1, 5_000_000.01, 10.0));

            check("discount below lower", !OrderCalculator.isValid(1, 100.0, -0.01));
            check("discount upper included", OrderCalculator.isValid(1, 100.0, 30.0));
            check("discount above upper", !OrderCalculator.isValid(1, 100.0, 30.01));
        } catch (Exception e) {
            System.out.println("FAIL exception " + e.getMessage());
        }

        System.out.println((passed == total ? "PASS " : "FAIL ") + passed + "/" + total);
    }
}
