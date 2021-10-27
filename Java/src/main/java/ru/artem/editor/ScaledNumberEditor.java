package ru.artem.editor;

import org.apache.commons.math3.util.Precision;
import ru.artem.entity.ScaledNumber;

public class ScaledNumberEditor {

    public static final int EDITOR_ACCURACY = 5;

    private StringBuilder stringBuilder;
    private ScaledNumber scaledNumberBuffer;
    private final int base;

    public ScaledNumberEditor(int base) {
        stringBuilder = new StringBuilder();
        scaledNumberBuffer = new ScaledNumber(0.0, base, EDITOR_ACCURACY);
        this.base = base;
    }

    public boolean isZero() {
        commitBuilderToNumber();
        return Precision.equals(0.0, scaledNumberBuffer.getNumber(), 1e-7);
    }

    public void sign() {
        if (stringBuilder.indexOf("-") == -1) {
            stringBuilder.insert(0, "-");
        } else {
            stringBuilder.deleteCharAt(0);
        }
    }

    public void appendDelimiter() {
        stringBuilder.append(".");
    }

    public void appendNumber(String numSymbol) {
        if (!(numSymbol.length() == 1)) {
            throw new RuntimeException("numSymbol length is not 1");
        }
        if (!ScaledNumber.Converter.NUMBER_CHARACTERS.contains(numSymbol)) {
            throw new RuntimeException("unexpected numSymbol \"" + numSymbol + "\"");
        }
        stringBuilder.append(numSymbol);
    }

    public void removeLast() {
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public void clear() {
        stringBuilder = new StringBuilder();
    }

    public void edit(double num) {
        scaledNumberBuffer = new ScaledNumber(num, base, EDITOR_ACCURACY);
        stringBuilder = new StringBuilder(scaledNumberBuffer.toString().replaceAll("\\.?0*$", ""));
    }

    @Override
    public String toString() {
        commitBuilderToNumber();
        stripBuilder();
        return stringBuilder.toString();
    }

    private void stripBuilder() {
        String[] numberParts = stringBuilder.toString().split("\\.");
        if (numberParts.length == 2 && numberParts[1].length() > EDITOR_ACCURACY) {
            stringBuilder = new StringBuilder(scaledNumberBuffer.toString());
        }
    }

    private void commitBuilderToNumber() {
        scaledNumberBuffer = new ScaledNumber(stringBuilder.toString(), base, EDITOR_ACCURACY);
    }
}
