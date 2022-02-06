package ru.artem.core.entity.polynomial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.artem.core.entity.polynomial.Monomial;

import static org.junit.jupiter.api.Assertions.*;

public class MonomialTest {

    private Monomial monomialDefault;

    private final int paramBase = 4;
    private final int paramExp = 6;
    Monomial monomialWithParams;

    @BeforeEach
    public void setup() {
        monomialDefault = new Monomial();
        monomialWithParams = new Monomial(paramBase, paramExp);
    }

    @Test
    public void initTest() {
        assertEquals(0, monomialDefault.getBase());
        assertEquals(0, monomialDefault.getExp());

        assertThrows(IllegalArgumentException.class, () -> new Monomial(1, -1));
    }

    @Test
    public void derivativeTest() {
        Monomial derivative = monomialWithParams.derivative();
        assertEquals(paramBase * paramExp, derivative.getBase());
        assertEquals(paramExp - 1, derivative.getExp());

        monomialWithParams.setExp(0);
        derivative = monomialWithParams.derivative();
        assertEquals(0, derivative.getBase());
        assertEquals(0, derivative.getExp());
    }

    @Test
    public void evaluateTest() {
        assertEquals(4, monomialWithParams.evaluate(1));
        assertEquals(62500, monomialWithParams.evaluate(5));
    }

    @Test
    public void equalsTest() {
        assertEquals(monomialWithParams, monomialWithParams);
        assertNotEquals(42, monomialWithParams);
        assertEquals(new Monomial(paramBase, paramExp), monomialWithParams);
    }

    @Test
    public void toStringTest() {
        assertEquals(paramBase + "x^" + paramExp, monomialWithParams.toString());
        assertEquals(Integer.toString(paramBase), new Monomial(paramBase, 0).toString());
        assertEquals("", new Monomial(0, paramExp).toString());
    }

}
