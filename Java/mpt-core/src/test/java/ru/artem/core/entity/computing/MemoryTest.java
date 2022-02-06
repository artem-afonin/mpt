package ru.artem.core.entity.computing;

import org.junit.jupiter.api.Test;
import ru.artem.core.entity.computing.Memory;
import ru.artem.core.entity.number.Fraction;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryTest {

    @Test
    public void initTest() {
        Memory<Fraction> memory = new Memory<>(Fraction::new);
        assertEquals(new Fraction(), memory.read());
    }

    @Test
    public void writeTest() {
        Memory<Fraction> memory = new Memory<>(Fraction::new);
        memory.write(new Fraction(42, 2));
        assertEquals(new Fraction(21, 1), memory.read());
    }

    @Test
    public void addTest() {
        Memory<Fraction> memory = new Memory<>(Fraction::new);
        memory.write(new Fraction(2, 2));
        memory.add(new Fraction(6, 1));
        assertEquals(new Fraction(7, 1), memory.read());
    }

    @Test
    public void isActiveTest() {
        Memory<Fraction> memory = new Memory<>(Fraction::new);
        memory.write(new Fraction(2, 2));
        assertTrue(memory.isActive());
        memory.clear();
        assertFalse(memory.isActive());
    }

}
