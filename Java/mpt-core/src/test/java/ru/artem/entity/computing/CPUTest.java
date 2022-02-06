package ru.artem.entity.computing;

import org.junit.jupiter.api.Test;
import ru.artem.entity.number.Fraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CPUTest {

    @Test
    public void initTest() {
        CPU<Fraction> cpu = new CPU<>(Fraction::new);
        assertEquals(new Fraction(), cpu.getLeftOperand());
        assertEquals(new Fraction(), cpu.getRightOperand());
    }

    @Test
    public void computationTest() {
        CPU<Fraction> cpu = new CPU<>(Fraction::new);
        cpu.setLeftOperand(new Fraction(2, 1));
        cpu.setOperation(CPU.BinaryOperation.ADD);
        cpu.setRightOperand(new Fraction(3, 1));
        cpu.applyOperation();
        cpu.setOperation(CPU.BinaryOperation.MULTIPLY);
        cpu.setRightOperand(new Fraction(4, 1));
        cpu.setFunction(CPU.UnaryFunction.SQUARE);
        cpu.applyFunction();
        cpu.applyOperation();
        assertEquals(new Fraction(80, 1), cpu.getLeftOperand());
    }

}
