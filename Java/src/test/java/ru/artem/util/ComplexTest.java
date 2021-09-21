package ru.artem.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ComplexTest {

    @Test
    void constructorWithStringTest() {
        Complex complex;

        complex = new Complex("3.2 + 3.1i");
        assertEquals(3.2, complex.getReal(), Complex.DELTA);
        assertEquals(3.1, complex.getImaginary(), Complex.DELTA);

        complex = new Complex("3.2 - 2.1i");
        assertEquals(3.2, complex.getReal(), Complex.DELTA);
        assertEquals(-2.1, complex.getImaginary(), Complex.DELTA);

        complex = new Complex("-3 + 2.1i");
        assertEquals(-3, complex.getReal(), Complex.DELTA);
        assertEquals(2.1, complex.getImaginary(), Complex.DELTA);

        complex = new Complex("-3.2 - 2i");
        assertEquals(-3.2, complex.getReal(), Complex.DELTA);
        assertEquals(-2, complex.getImaginary(), Complex.DELTA);

        complex = new Complex("3 + i");
        assertEquals(3, complex.getReal(), Complex.DELTA);
        assertEquals(1, complex.getImaginary(), Complex.DELTA);

        complex = new Complex("3 - i");
        assertEquals(3, complex.getReal(), Complex.DELTA);
        assertEquals(-1, complex.getImaginary(), Complex.DELTA);
    }

    @Test
    void equalsTest() {
        Complex complex = new Complex("-3 - i");
        assertNotEquals(new Complex("4 + 2i"), complex);
        assertEquals(new Complex("-3 - i"), complex);
        assertEquals(new Complex("-3 - 1i"), complex);
        assertEquals(new Complex(-3, -1), complex);
    }

    @Test
    void toStringTest() {
        assertEquals("-3.0 + 4.0i", new Complex(-3, 4).toString());
        assertEquals("-3.0 + 0.75i", new Complex(-3, 0.75).toString());
        assertEquals("-3.0 + i", new Complex(-3, 1).toString());
        assertEquals("-3.0 - i", new Complex(-3, -1).toString());
        assertEquals("-3.0", new Complex(-3, 0).toString());
        assertEquals("-3.0 - 42.0i", new Complex(-3, -42).toString());
    }

    @Test
    void addTest() {
        Complex complex = new Complex("2 + i");
        assertEquals(new Complex(4, 2), complex.add(complex));
    }

    @Test
    void subtractTest() {
        Complex first = new Complex("4 - 3i");
        Complex second = new Complex("-1 - i");
        assertEquals(new Complex(5, -2), first.subtract(second));
        assertEquals(new Complex(-5, 2), second.subtract(first));
    }

    @Test
    void multiplyTest() {
        Complex first = new Complex("-2 + 5i");
        Complex second = new Complex("5 - i");
        assertEquals(new Complex(-5, 27), first.multiply(second));
    }

    @Test
    void divideTest() {
        Complex first = new Complex("-2 + 5i");
        Complex second = new Complex("5 - i");
        assertEquals(new Complex(-15d / 26d,  23d / 26d), first.divide(second));
    }

    @Test
    void squareTest() {
        Complex complex = new Complex("5 - i");
        assertEquals(new Complex(24, -10), complex.square());
    }

    @Test
    void inversedTest() {
        Complex complex = new Complex("-2 + 6i");
        assertEquals(new Complex(-0.05, -0.15), complex.inversed());
    }

    @Test
    void negateTest() {
        Complex complex = new Complex("-2 + 6i");
        assertEquals(new Complex(2, -6), complex.negate());
    }

    @Test
    void absTest() {
        Complex complex = new Complex("3 - 7i");
        assertEquals(Math.sqrt(58), complex.abs());
    }

    @Test
    void angleRadiansTest() {
        assertEquals(-0.404891786285083423, new Complex(7, -3).angleRadians(), Complex.DELTA);
        assertEquals(1.5707963267948966192, new Complex(0, 2).angleRadians(), Complex.DELTA);
        assertEquals(2.3561944901923449288, new Complex(-2, 2).angleRadians(), Complex.DELTA);
        assertEquals(-1.570796326794896619, new Complex(0, -3).angleRadians(), Complex.DELTA);
    }

    @Test
    void angleDegreesTest() {
        assertEquals(45d, new Complex(1, 1).angleDegrees(), 1e-2);
        assertEquals(-6.78d, new Complex(42, -5).angleDegrees(), 1e-2);
    }

    @Test
    void powTest() {
        assertEquals(new Complex(-1d / 2d, Math.sqrt(3) / 2d), new Complex(1d / 2d, Math.sqrt(3) / 2d).pow(20));
    }

    @Test
    void rootTest() {
        Complex complex = new Complex("3 + 6i");
        assertEquals(new Complex(1.5481, 0.43978), complex.root(4, 0));
        assertEquals(new Complex(-0.4398, 1.5481), complex.root(4, 1));
        assertEquals(new Complex(-1.5481, -0.4398), complex.root(4, 2));
        assertEquals(new Complex(0.43978, -1.5481), complex.root(4, 3));
    }

}
