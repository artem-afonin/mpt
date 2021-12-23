package ru.artem.entity.polynomial;

public class Monomial {

    private int base;
    private int exp;

    public Monomial() {
        this(0, 0);
    }

    public Monomial(int base, int exp) {
        setBase(base);
        setExp(exp);
    }

    public Monomial add(Monomial other) {
        if (exp == other.exp)
            return new Monomial(base + other.base, exp);
        else
            throw new RuntimeException("Can not add Monomial with different exponents");
    }

    public Monomial subtract(Monomial other) {
        if (exp == other.exp)
            return new Monomial(base - other.base, exp);
        else
            throw new RuntimeException("Can not subtract Monomial with different exponents");
    }

    public Monomial multiply(Monomial other) {
        return new Monomial(base * other.base, exp + other.exp);
    }

    public Monomial divide(Monomial other) {
        return new Monomial(base / other.base, exp + other.exp);
    }

    public Monomial derivative() {
        if (exp == 0)
            return new Monomial(0, 0);
        else
            return new Monomial(base * exp, exp - 1);
    }

    public int evaluate(int x) {
        if (exp == 0)
            return base;
        else if (exp == 1)
            return base * x;
        else
            return base * (int) Math.pow(x, exp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monomial)) return false;
        Monomial other = (Monomial) o;
        return base == other.base && exp == other.exp;
    }

    @Override
    public String toString() {
        if (base == 0)
            return "";
        if (exp == 0)
            return Integer.toString(base);
        if (exp == 1)
            return String.format("%dx", base);
        else
            return String.format("%dx^%d", base, exp);
    }

    private static void validateExp(int exp) {
        if (exp < 0)
            throw new IllegalArgumentException("Exponent should be positive or zero");
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        validateExp(exp);
        this.exp = exp;
    }

}
