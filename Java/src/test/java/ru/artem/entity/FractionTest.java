package ru.artem.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.artem.entity.Fraction;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    Fraction first;
    Fraction second;

    @BeforeEach
    void setup() {
        first = new Fraction("3/6");
        second = new Fraction("3/-4");
    }

    @Test
    void constructorWrongFormatTest() {
        assertThrows(IllegalArgumentException.class, () -> new Fraction("2"));
        assertThrows(IllegalArgumentException.class, () -> new Fraction("2/"));
        assertThrows(NumberFormatException.class, () -> new Fraction("1.75/2"));
        assertThrows(NumberFormatException.class, () -> new Fraction("nothing/useful"));
        assertThrows(NumberFormatException.class, () -> new Fraction("nothing/useful"));
        assertThrows(IllegalArgumentException.class, () -> new Fraction("3/0"));
    }

    @Test
    void constructorNumReducerTest() {
        assertEquals(1, first.getNumerator());
        assertEquals(2, first.getDenominator());
        assertEquals(-3, second.getNumerator());
        assertEquals(4, second.getDenominator());
    }

    @Test
    void toStringTest() {
        assertEquals("1/2", first.toString());
        assertEquals("-3/4", second.toString());
    }

    @Test
    void equalsTest() {
        assertEquals(new Fraction("24/48"), first);
        assertEquals(new Fraction("-3/4"), second);

        assertNotEquals(new Fraction("1/3"), first);
        assertNotEquals(new Fraction("3/4"), second);
    }

    @Test
    void addTest() {
        assertEquals(new Fraction("-1/4"), first.add(second));
    }

    @Test
    void subtractTest() {
        assertEquals(new Fraction("5/4"), first.subtract(second));
    }

    @Test
    void multiplyTest() {
        assertEquals(new Fraction("-3/8"), first.multiply(second));
    }

    @Test
    void divideTest() {
        assertEquals(new Fraction("-2/3"), first.divide(second));
    }

    @Test
    void squareTest() {
        assertEquals(new Fraction("1/4"), first.square());
        assertEquals(new Fraction("9/16"), second.square());
    }

    @Test
    void inversedTest() {
        assertEquals(new Fraction("2/1"), first.inversed());
        assertEquals(new Fraction("-4/3"), second.inversed());
    }

    @Test
    void negateTest() {
        assertEquals(new Fraction("-1/2"), first.negate());
        assertEquals(new Fraction("3/4"), second.negate());
    }

    @Test
    void compareToTest() {
        assertTrue(first.compareTo(second) > 0);
        assertEquals(0, new Fraction("3/5").compareTo(new Fraction("9/15")));
        assertFalse(second.compareTo(new Fraction("-4/5")) < 0);
    }

}
