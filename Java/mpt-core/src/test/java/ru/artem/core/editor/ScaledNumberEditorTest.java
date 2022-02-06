package ru.artem.core.editor;

import org.junit.jupiter.api.Test;
import ru.artem.core.editor.ScaledNumberEditor;
import ru.artem.core.entity.number.ScaledNumber;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class ScaledNumberEditorTest {

    @Test
    void constructorTest() throws NoSuchFieldException, IllegalAccessException {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        Field scaledNumberField = editor.getClass().getDeclaredField("scaledNumberBuffer");
        scaledNumberField.setAccessible(true);
        ScaledNumber scaledNumber = (ScaledNumber) scaledNumberField.get(editor);
        assertEquals(0.0, scaledNumber.getNumber(), 1e-7);
    }

    @Test
    void appendTest() {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        editor.appendNumber("1");
        editor.appendNumber("0");
        editor.appendNumber("1");
        editor.appendDelimiter();
        editor.appendNumber("1");
        editor.appendNumber("1");
        assertEquals("101.11", editor.toString());
        editor.appendNumber("1");
        editor.appendNumber("0");
        editor.appendNumber("1");
        assertEquals("101.11101", editor.toString());
        editor.appendNumber("1");
        assertEquals("101.11101", editor.toString());
    }

    @Test
    void appendThrowsTest() {
        ScaledNumberEditor editor1 = new ScaledNumberEditor(2);
        editor1.appendNumber("2");
        assertThrows(RuntimeException.class, editor1::toString);

        ScaledNumberEditor editor2 = new ScaledNumberEditor(16);
        assertThrows(RuntimeException.class, () -> editor2.appendNumber("7F"));

        ScaledNumberEditor editor3 = new ScaledNumberEditor(16);
        editor3.appendNumber("5");
        editor3.appendNumber("F");
        editor3.appendNumber("2");
        editor3.appendDelimiter();
        editor3.appendDelimiter();
        editor3.appendNumber("2");
        assertThrows(IllegalArgumentException.class, editor3::toString);
    }

    @Test
    void isZeroTest() {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        editor.appendNumber("0");
        assertTrue(editor.isZero());

        editor.appendNumber("1");
        editor.appendDelimiter();
        editor.appendNumber("1");
        assertFalse(editor.isZero());

        editor.clear();
        editor.appendNumber("0");
        assertTrue(editor.isZero());
    }

    @Test
    void signTest() {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        editor.appendNumber("0");
        assertEquals("0", editor.toString());
        editor.sign();
        assertEquals("-0", editor.toString());
        editor.sign();
        assertEquals("0", editor.toString());

        editor.clear();
        editor.appendNumber("1");
        editor.appendNumber("1");
        editor.appendDelimiter();
        editor.appendNumber("0");
        editor.appendNumber("1");
        assertEquals("11.01", editor.toString());
        editor.sign();
        assertEquals("-11.01", editor.toString());
        editor.sign();
        assertEquals("11.01", editor.toString());
    }

    @Test
    void removeLastTest() {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        editor.appendNumber("1");
        editor.appendNumber("1");
        editor.appendDelimiter();
        editor.appendNumber("0");
        editor.removeLast();
        editor.appendNumber("1");
        assertEquals("11.1", editor.toString());

        editor.sign();
        editor.removeLast();
        editor.removeLast();
        assertEquals("-11", editor.toString());
        editor.sign();
        editor.appendDelimiter();
        editor.appendNumber("0");
        editor.appendNumber("0");
        editor.appendNumber("1");
        editor.appendNumber("1");
        editor.removeLast();
        assertEquals("11.001", editor.toString());
    }

    @Test
    void editTest() {
        ScaledNumberEditor editor = new ScaledNumberEditor(2);
        editor.appendNumber("1");
        editor.appendNumber("1");
        assertEquals("11", editor.toString());

        editor.edit(5.375);
        assertEquals("101.011", editor.toString());
    }

}
