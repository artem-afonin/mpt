package ru.artem.core.entity.computing;

import ru.artem.core.entity.number.Number;

import java.util.function.Supplier;

public class Memory<T extends Number<T>> {

    private final Supplier<T> defaultSupplier;
    private Number<T> number;
    private boolean active;

    public Memory(Supplier<T> defaultValueSupplier) {
        defaultSupplier = defaultValueSupplier;
        clear();
    }

    public void write(T other) {
        number = other.clone();
        active = true;
    }

    public Number<T> read() {
        return number.clone();
    }

    public void add(T other) {
        number = number.add(other);
    }

    public void clear() {
        number = defaultSupplier.get().clone();
        active = false;
    }

    public boolean isActive() {
        return active;
    }

}
