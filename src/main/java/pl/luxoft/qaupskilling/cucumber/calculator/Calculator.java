package pl.luxoft.qaupskilling.cucumber.calculator;

public class Calculator {
    public static int subtract(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public static int multiply(int factor1, int factor2) {
        return factor1 * factor2;
    }

    public static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

    public int add(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
