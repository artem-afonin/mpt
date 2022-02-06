package ru.artem.core.util;

import java.util.ArrayList;
import java.util.Comparator;

public class SortedArrayList<E> extends ArrayList<E> {

    private final Comparator<E> comparator;

    public SortedArrayList(final Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(int index, E element) {
        this.add(element);
    }

    @Override
    public boolean add(E e) {
        final boolean result = super.add(e);
        this.sort(this.comparator);
        return result;
    }

}
