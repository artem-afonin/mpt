package ru.artem.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedArraySet<T> implements Set<T> {

    private static final int DEFAULT_INITIAL_SIZE = 8;

    private Object[] array;
    private int currentSize;

    public LinkedArraySet() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public LinkedArraySet(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("initial set size is negative or zero");
        }
        array = new Object[initialSize];
        currentSize = 0;
    }

    @Override
    public void put(T element) {
        if (isArrayLimit()) {
            expandArraySize();
        }
        if (indexOf(element) == -1) {
            array[currentSize] = element;
            currentSize += 1;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public void remove(T element) {
        int elementIndex = indexOf(element);
        if (elementIndex == -1) {
            return;
        } else {
            if (currentSize - 1 - elementIndex >= 0) {
                System.arraycopy(array, elementIndex + 1, array, elementIndex, currentSize - 1 - elementIndex);
            }
        }
        array[currentSize - 1] = null;
        currentSize -= 1;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < currentSize; i++) {
            if (array[i] == element || array[i].hashCode() == element.hashCode() && array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_INITIAL_SIZE];
        currentSize = 0;
    }

    @Override
    public Set<T> combine(Set<T> other) {
        LinkedArraySet<T> newSet = new LinkedArraySet<>(size() + other.size());

        for (int i = 0; i < size(); i++) {
            T element = get(i);
            newSet.put(element);
        }
        for (int i = 0; i < other.size(); i++) {
            T element = other.get(i);
            if (indexOf(element) == -1) {
                newSet.put(element);
            }
        }

        return newSet;
    }

    @Override
    public Set<T> subtract(Set<T> other) {
        LinkedArraySet<T> newSet = new LinkedArraySet<>(size());

        for (int i = 0; i < size(); i++) {
            T element = get(i);
            if (other.indexOf(element) == -1) {
                newSet.put(element);
            }
        }

        return newSet;
    }

    @Override
    public Set<T> multiply(Set<T> other) {
        LinkedArraySet<T> newSet = new LinkedArraySet<>(size());

        for (int i = 0; i < size(); i++) {
            T element = get(i);
            if (other.indexOf(element) != -1) {
                newSet.put(element);
            }
        }

        return newSet;
    }

    private boolean isArrayLimit() {
        return currentSize >= array.length;
    }

    private void expandArraySize() {
        int newSize = (int) (currentSize + currentSize * 0.618 + 1);
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, currentSize);

        array = newArray;
        currentSize = newSize;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedArraySetIterator<T>((T[]) array, currentSize);
    }

    private static class LinkedArraySetIterator<T> implements Iterator<T> {
        private final T[] array;
        private final int arrayHighBound;
        private int currentIndex;

        public LinkedArraySetIterator(T[] array, int arrayHighBound) {
            this.array = array;
            this.arrayHighBound = arrayHighBound;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < arrayHighBound;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentIndex += 1;
            return array[currentIndex - 1];
        }
    }
}
