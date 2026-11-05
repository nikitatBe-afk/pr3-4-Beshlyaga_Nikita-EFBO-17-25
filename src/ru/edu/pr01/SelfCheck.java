package ru.edu.pr01;

public class SelfCheck {
    public static void main(String[] args) {

        // Проверка методов расчёта
        boolean ok = false;

        try {
            ok = (
                OrderCalculator.calculateBase(2, 100.0) == 200.0
                &&
                Math.abs(
                    OrderCalculator.calculateTotal(2, 100.0, 10.0) - 225.0
                ) < 0.001
            );
        } catch (Exception e) {
            System.out.println("FAIL exception " + e.getMessage());
        }

        System.out.println(ok ? "PASS" : "FAIL complete TODO methods");


        // Проверка значений из sample.csv
        try {
            System.out.println(
                OrderCalculator.isValid(12, 2490.50, 5)
                ? "PASS CSV 1"
                : "FAIL CSV 1"
            );

            System.out.println(
                OrderCalculator.isValid(100, 150.00, 0)
                ? "PASS CSV 2"
                : "FAIL CSV 2"
            );

            System.out.println(
                !OrderCalculator.isValid(0, 1000, 10)
                ? "PASS CSV 3"
                : "FAIL CSV 3"
            );

            System.out.println(
                !OrderCalculator.isValid(5, -20, 5)
                ? "PASS CSV 4"
                : "FAIL CSV 4"
            );

            System.out.println(
                !OrderCalculator.isValid(3, 999.99, 35)
                ? "PASS CSV 5"
                : "FAIL CSV 5"
            );

        } catch (Exception e) {
            System.out.println("FAIL CSV exception " + e.getMessage());
        }
    }
}
