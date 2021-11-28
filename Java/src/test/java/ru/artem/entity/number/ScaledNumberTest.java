package ru.artem.entity.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaledNumberTest {

    @Test
    void stringConstructorAndToStringTest() {
        ScaledNumber first = new ScaledNumber("2d3A213.1ca", 16, 6);
        ScaledNumber second = new ScaledNumber("2d3A213", 16, 2);

        assertEquals("2D3A213.1C9FF9", first.toString());
        first.setAccuracy(2);
        assertEquals("2D3A213.1C", first.toString());
        first.setAccuracy(0);
        assertEquals("2D3A213", first.toString());
        assertEquals("2D3A213.00", second.toString());
    }

    @Test
    void numberConstructorTest() {
        ScaledNumber number = new ScaledNumber(6.25, 2, 2);
        assertEquals("110.01", number.toString());
    }

    @Test
    void addTest() {
        ScaledNumber firstNumber = new ScaledNumber(6.25, 2, 2);
        ScaledNumber secondNumber = new ScaledNumber("0.1", 2, 2);
        assertEquals("110.11", firstNumber.add(secondNumber).toString());
        assertEquals("110.11", secondNumber.add(firstNumber).toString());
        assertEquals("1.00", secondNumber.add(secondNumber).toString());
    }

    @Test
    void subtractTest() {
        ScaledNumber firstNumber = new ScaledNumber(6.25, 2, 2);
        ScaledNumber secondNumber = new ScaledNumber("0.1", 2, 2);
        assertEquals("101.11", firstNumber.subtract(secondNumber).toString());
        assertEquals("-101.11", secondNumber.subtract(firstNumber).toString());
        assertEquals("0.00", firstNumber.subtract(firstNumber).toString());
        assertEquals("0.00", secondNumber.subtract(secondNumber).toString());
    }

    @Test
    void multiplyTest() {
        ScaledNumber firstNumber = new ScaledNumber(6.5, 2, 2);
        ScaledNumber secondNumber = new ScaledNumber(-0.5, 2, 2);
        assertEquals("-11.01", firstNumber.multiply(secondNumber).toString());
        assertEquals("-11.01", secondNumber.multiply(firstNumber).toString());
    }

    @Test
    void divideTest() {
        ScaledNumber firstNumber = new ScaledNumber(6.5, 2, 2);
        ScaledNumber secondNumber = new ScaledNumber(0.5, 2, 2);
        assertEquals("1101.00", firstNumber.divide(secondNumber).toString());
    }

    @Test
    void inversedTest() {
        ScaledNumber number = new ScaledNumber(8, 2, 4);
        assertEquals("0.0010", number.inversed().toString());
    }

    @Test
    void squareTest() {
        ScaledNumber number = new ScaledNumber(3.5, 2, 4);
        assertEquals("1100.0100", number.square().toString());
    }

}
