package ru.artem.entity.number;

public interface Number<T> extends Cloneable {
    T add(T other);

    T subtract(T other);

    T multiply(T other);

    T divide(T other);

    T inversed();

    T square();

    T clone();
}
