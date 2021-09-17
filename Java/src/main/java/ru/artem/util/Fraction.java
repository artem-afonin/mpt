package ru.artem.util;

public class Fraction implements Cloneable, Comparable<Fraction> {

    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) {
        initFractionNumbers(numerator, denominator);
    }

    public Fraction(String fractionString) {
        String[] splitFraction = fractionString.strip().split("/");
        if (splitFraction.length != 2) {
            throw new IllegalArgumentException("Illegal string fraction");
        }

        int numerator, denominator;
        try {
            numerator = Integer.parseInt(splitFraction[0]);
            denominator = Integer.parseInt(splitFraction[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Unable to parse number in fraction string");
        }

        initFractionNumbers(numerator, denominator);
    }

    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction square() {
        int newNumerator = numerator * numerator;
        int newDenominator = denominator * denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction inversed() {
        return new Fraction(denominator, numerator);
    }

    public Fraction negate() {
        return new Fraction(-numerator, denominator);
    }

    @Deprecated()
    public boolean greaterThan(Fraction other) {
        return subtract(other).numerator > 0;
    }

    @Override
    public int compareTo(Fraction other) {
        int numerator = subtract(other).numerator;
        if (numerator > 0) {
            return 1;
        } else if (numerator < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;

        Fraction other = (Fraction) obj;

        return numerator == other.numerator && denominator == other.denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public Fraction clone() {
        return new Fraction(numerator, denominator);
    }

    private void initFractionNumbers(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator should not be 0");
        }

        int gcdValue = MathFunction.gcd(numerator, denominator);
        if (gcdValue != 1) {
            numerator /= gcdValue;
            denominator /= gcdValue;
        }

        if (numerator < 0 && denominator < 0 || numerator > 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public String getNumeratorAsString() {
        return Integer.toString(numerator);
    }

    public int getDenominator() {
        return denominator;
    }

    public String getDenominatorAsString() {
        return Integer.toString(numerator);
    }

}
