package ru.artem.entity;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.artem.util.MathFunction.doubleEqualsWithDelta;

public class Complex implements Number<Complex> {

    public static final double DELTA = 1e-3;
    // a + bi
    // 3 - i
    // -3 + 2i
    private static final Pattern COMPLEX_REGEX = Pattern.compile("\\s*(-?\\d+(\\.\\d+)?)\\s*([-+])\\s*((\\d+(\\.\\d+)?)?i)\\s*");

    protected double real;
    protected double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real, double imaginary) {
        initComplexNumbers(real, imaginary);
    }

    public Complex(String complexString) {
        Matcher complexMatcher = COMPLEX_REGEX.matcher(complexString);
        if (!complexMatcher.matches()) {
            throw new IllegalArgumentException("Complex string does not match pattern");
        }

        String realString = complexMatcher.group(1);
        String sign = complexMatcher.group(3);
        String imaginaryString = Optional.ofNullable(complexMatcher.group(5)).orElse("1");
        if ("-".equals(sign)) {
            imaginaryString = "-" + imaginaryString;
        }

        double real = Double.parseDouble(realString);
        double imaginary = Double.parseDouble(imaginaryString);

        initComplexNumbers(real, imaginary);
    }

    public Complex add(Complex other) {
        double newReal = real + other.real;
        double newImaginary = imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex subtract(Complex other) {
        double newReal = real - other.real;
        double newImaginary = imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex multiply(Complex other) {
        double newReal = real * other.real - imaginary * other.imaginary;
        double newImaginary = real * other.imaginary + imaginary * other.real;
        return new Complex(newReal, newImaginary);
    }

    public Complex divide(Complex other) {
        double newReal = (real * other.real + imaginary * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary);
        double newImaginary = (other.real * imaginary - real * other.imaginary) / (other.real * other.real + other.imaginary * other.imaginary);
        return new Complex(newReal, newImaginary);
    }

    public Complex square() {
        return multiply(this);
    }

    public Complex inversed() {
        double newReal = real / (real * real + imaginary * imaginary);
        double newImaginary = imaginary / (real * real + imaginary * imaginary);
        return new Complex(newReal, -newImaginary);
    }

    public Complex negate() {
        return new Complex(-real, -imaginary);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public double angleRadians() {
        if (real > 0) {
            return Math.atan(imaginary / real);
        } else if (real == 0 && imaginary > 0) {
            return Math.PI / 2;
        } else if (real < 0) {
            return Math.atan(imaginary / real) + Math.PI;
        } else if (real == 0 && imaginary < 0) {
            return -(Math.PI / 2);
        } else {
            throw new RuntimeException("radians angle for complex with zero imag not implemented yet");
        }
    }

    public double angleDegrees() {
        return (angleRadians() * 57.2958) % 360;
    }

    public Complex pow(int power) {
        if (power < 1) {
            throw new RuntimeException("Not implemented yet");
        }

        double complexAbs = abs();
        double complexAbsWithPow = Math.pow(complexAbs, power);

        double angleRadians = angleRadians();
        double realPart = Math.cos(power * angleRadians);
        double imaginePart = Math.sin(power * angleRadians);

        return new Complex(complexAbsWithPow * realPart, complexAbsWithPow * imaginePart);
    }

    public Complex root(int rootValue, int rootIndex) {
        double complexAbs = Math.pow(abs(), 1d / rootValue);
        double fi = angleRadians();

        double realValue = Math.cos((fi + 2 * Math.PI * rootIndex) / (rootValue));
        double imaginaryValue = Math.sin((fi + 2 * Math.PI * rootIndex) / (rootValue));

        realValue *= complexAbs;
        imaginaryValue *= complexAbs;

        return new Complex(realValue, imaginaryValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Complex)) return false;

        Complex other = (Complex) obj;

        return doubleEqualsWithDelta(real, other.real, DELTA) && doubleEqualsWithDelta(imaginary, other.imaginary, DELTA);
    }

    @Override
    public String toString() {
        if (imaginary > 1 || (imaginary > 0 && imaginary < 1)) {
            return real + " + " + imaginary + "i";
        } else if (imaginary == 1) {
            return real + " + i";
        } else if (imaginary == 0) {
            return Double.toString(real);
        } else if (imaginary == -1) {
            return real + " - i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    @Override
    public Complex clone() {
        return new Complex(real, imaginary);
    }

    private void initComplexNumbers(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}
