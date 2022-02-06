package ru.artem.core.util;

public final class MathFunction {

    private MathFunction() {
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static boolean doubleEqualsWithDelta(double first, double second, double delta) {
        return Math.abs(first - second) < delta;
    }

}
