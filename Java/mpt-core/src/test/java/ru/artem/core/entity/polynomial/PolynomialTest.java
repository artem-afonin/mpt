package ru.artem.core.entity.polynomial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.artem.core.entity.polynomial.Monomial;
import ru.artem.core.entity.polynomial.Polynomial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolynomialTest {

    @Test
    void initTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(1, 1));
        polynomial.appendMonomial(new Monomial(-2, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> polynomial.appendMonomial(new Monomial(2, -1)));
    }

    @Test
    void powerTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(1, 1));
        polynomial.appendMonomial(new Monomial(4, 2));
        polynomial.appendMonomial(new Monomial(-2, 0));
        assertEquals(2, polynomial.getPower());
    }

    @Test
    void baseTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(1, 1));
        polynomial.appendMonomial(new Monomial(4, 2));
        polynomial.appendMonomial(new Monomial(-2, 0));
        assertEquals(4, polynomial.getBase(2));
    }

    @Test
    void clearTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(1, 1));
        polynomial.appendMonomial(new Monomial(4, 2));
        polynomial.appendMonomial(new Monomial(-2, 0));
        polynomial.clear();
        assertEquals(new Polynomial(), polynomial);
    }

    @Test
    void mathTest() {
        var polynomial1 = new Polynomial();
        polynomial1.appendMonomial(new Monomial(1, 1));
        polynomial1.appendMonomial(new Monomial(-2, 0));
        var polynomial2 = new Polynomial();
        polynomial2.appendMonomial(new Monomial(3, 1));
        polynomial2.appendMonomial(new Monomial(1, 0));
        var polynomial3 = new Polynomial();
        polynomial3.appendMonomial(new Monomial(4, 1));
        polynomial3.appendMonomial(new Monomial(-3, 0));
        assertEquals("8x + -4", polynomial1.add(polynomial2).add(polynomial3).toString());
        assertEquals("-6x", polynomial1.subtract(polynomial2).subtract(polynomial3).toString());
        assertEquals("12x^3 + -29x^2 + 7x + 6", polynomial1.multiply(polynomial2).multiply(polynomial3).toString());
    }

    @Test
    void derivativeTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(5, 3));
        polynomial.appendMonomial(new Monomial(-2, 2));
        polynomial.appendMonomial(new Monomial(-5, 0));
        assertEquals("15x^2 + -4x", polynomial.derivative().toString());
    }

    @Test
    void evaluateTest() {
        var polynomial = new Polynomial();
        polynomial.appendMonomial(new Monomial(5, 3));
        polynomial.appendMonomial(new Monomial(-2, 2));
        polynomial.appendMonomial(new Monomial(5, 0));
        assertEquals(122, polynomial.evaluate(3));
    }

}
