package ru.artem.core.collection;

public interface Set<T> extends Iterable<T> {

    void put(T element);

    T get(int index);

    void remove(T element);

    int indexOf(T element);

    int size();

    boolean isEmpty();

    void clear();

    Set<T> combine(Set<T> other);

    Set<T> subtract(Set<T> other);

    Set<T> multiply(Set<T> other);

}
