package ru.artem.entity.polynomial;

import ru.artem.util.SortedArrayList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Polynomial implements Iterable<Monomial> {

    private List<Monomial> monomials = new SortedArrayList<>(Comparator.comparingInt(Monomial::getExp).reversed());

    public Polynomial() {
    }

    public void appendMonomial(Monomial other) {
        addMonomial(other);
    }

    public int getPower() {
        return monomials.stream()
                .filter(m -> m.getBase() != 0)
                .mapToInt(Monomial::getExp).max()
                .orElseThrow(() -> new RuntimeException("No elements with powers"));
    }

    public int getBase(int exp) {
        return monomials.stream().filter(m -> m.getExp() == exp).findAny().map(Monomial::getBase).orElse(0);
    }

    public void clear() {
        monomials.clear();
    }

    public Polynomial add(Polynomial other) {
        var newPolynomial = new Polynomial();
        forEach(newPolynomial::addMonomial);
        other.forEach(newPolynomial::addMonomial);
        return newPolynomial;
    }

    public Polynomial subtract(Polynomial other) {
        var newPolynomial = new Polynomial();
        forEach(newPolynomial::subtractMonomial);
        other.forEach(newPolynomial::subtractMonomial);
        return newPolynomial;
    }

    public Polynomial multiply(Polynomial other) {
        var newPolynomial = new Polynomial();
        forEach(m -> other.forEach(o -> newPolynomial.addMonomial(m.multiply(o))));
        return newPolynomial;
    }

    public Polynomial divide(Polynomial other) {
        var newPolynomial = new Polynomial();
        forEach(m -> other.forEach(o -> newPolynomial.addMonomial(m.divide(o))));
        return newPolynomial;
    }

    public Polynomial derivative() {
        var newPolynomial = new Polynomial();
        newPolynomial.monomials = monomials.stream()
                .map(Monomial::derivative)
                .filter(m -> m.getBase() != 0)
                .collect(Collectors.toList());
        return newPolynomial;
    }

    public int evaluate(int x) {
        return monomials.stream().mapToInt(m -> m.evaluate(x)).sum();
    }

    @Override
    public Iterator<Monomial> iterator() {
        return monomials.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polynomial)) return false;
        Polynomial other = (Polynomial) obj;
        return monomials.equals(other.monomials);
    }

    @Override
    public String toString() {
        return monomials.stream()
                .filter(m -> m.getBase() != 0)
                .map(Monomial::toString)
                .collect(Collectors.joining(" + "));
    }

    private void addMonomial(Monomial other) {
        monomials.stream().filter(m -> m.getExp() == other.getExp()).findAny().ifPresentOrElse(oldMonomial -> {
            monomials.remove(oldMonomial);
            monomials.add(oldMonomial.add(other));
        }, () -> {
            monomials.add(other);
        });
    }

    private void subtractMonomial(Monomial other) {
        monomials.stream().filter(m -> m.getExp() == other.getExp()).findAny().ifPresentOrElse(oldMonomial -> {
            monomials.remove(oldMonomial);
            monomials.add(oldMonomial.subtract(other));
        }, () -> {
            monomials.add(other);
        });
    }

    private void multiplyMonomial(Monomial other) {
        monomials.replaceAll(m -> m.multiply(other));
    }

    private void divideMonomial(Monomial other) {
        monomials.replaceAll(m -> m.divide(other));
    }

}
