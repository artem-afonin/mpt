package ru.artem.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedArraySetTest {

    @Test
    void constructorTest() {
        assertDoesNotThrow((ThrowingSupplier<LinkedArraySet<Integer>>) LinkedArraySet::new);
        assertDoesNotThrow(() -> new LinkedArraySet<Integer>(16));
        assertDoesNotThrow(() -> new LinkedArraySet<Integer>(1));
        assertThrows(IllegalArgumentException.class, () -> new LinkedArraySet<Integer>(0));
        assertThrows(IllegalArgumentException.class, () -> new LinkedArraySet<Integer>(-42));
    }

    @Test
    void putTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        assertIterableEquals(List.of(1, 2, 3), set);
        set.put(1);
        set.put(4);
        assertIterableEquals(List.of(1, 2, 3, 4), set);
    }

    @Test
    void getTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        set.put(1);
        set.put(4);
        assertEquals(1, set.get(0));
        assertEquals(2, set.get(1));
        assertEquals(3, set.get(2));
        assertEquals(4, set.get(3));
    }

    @Test
    void removeTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        set.put(1);
        set.put(4);

        set.remove(3);
        set.remove(1);
        set.put(3);
        set.remove(2);
        assertIterableEquals(List.of(4, 3), set);
    }

    @Test
    void indexOfTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        set.put(1);
        set.put(4);
        assertEquals(3, set.indexOf(4));
        assertEquals(2, set.indexOf(3));
        assertEquals(1, set.indexOf(2));
        assertEquals(0, set.indexOf(1));
    }

    @Test
    void sizeTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        set.put(1);
        set.put(4);
        assertEquals(4, set.size());
    }

    @Test
    void clearTest() {
        LinkedArraySet<Integer> set = new LinkedArraySet<>();
        set.put(1);
        set.put(2);
        set.put(3);
        set.put(2);
        set.put(1);
        set.put(4);
        set.clear();
        set.put(42);
        assertEquals(1, set.size());
        set.clear();
        assertEquals(0, set.size());
    }

    @Test
    void combineTest() {
        LinkedArraySet<Integer> set1 = new LinkedArraySet<>();
        LinkedArraySet<Integer> set2 = new LinkedArraySet<>();

        set1.put(1);
        set1.put(2);
        set1.put(3);
        set1.put(4);

        set2.put(3);
        set2.put(4);
        set2.put(5);
        set2.put(6);

        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5, 6), set1.combine(set2));
    }

    @Test
    void subtractTest() {
        LinkedArraySet<Integer> set1 = new LinkedArraySet<>();
        LinkedArraySet<Integer> set2 = new LinkedArraySet<>();

        set1.put(1);
        set1.put(2);
        set1.put(3);
        set1.put(4);

        set2.put(3);
        set2.put(4);
        set2.put(5);
        set2.put(6);

        assertIterableEquals(Arrays.asList(1, 2), set1.subtract(set2));
        assertIterableEquals(Arrays.asList(5, 6), set2.subtract(set1));
    }

    @Test
    void multiplyTest() {
        LinkedArraySet<Integer> set1 = new LinkedArraySet<>();
        LinkedArraySet<Integer> set2 = new LinkedArraySet<>();

        set1.put(1);
        set1.put(2);
        set1.put(3);
        set1.put(4);

        set2.put(3);
        set2.put(4);
        set2.put(5);
        set2.put(6);

        set1.multiply(set2).forEach(System.out::println);
        assertIterableEquals(Arrays.asList(3, 4), set1.multiply(set2));
    }

}
