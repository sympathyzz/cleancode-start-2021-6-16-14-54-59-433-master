package com.tw.academy.basic.$2_magic_number;

public class FareCalculation {

    public double calculate(double originalPrice, double cumulativeExpensesThisMonth) {
        if (cumulativeExpensesThisMonth >= 100 && cumulativeExpensesThisMonth < 150) {
            return originalPrice * 0.8;
        }
        if (cumulativeExpensesThisMonth >= 150 && cumulativeExpensesThisMonth < 400) {
            return originalPrice * 0.5;
        }
        return originalPrice;
    }
}
