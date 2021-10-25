package ru.artem.entity;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.util.Precision;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScaledNumber implements Cloneable {

    public static final double MAX_DELTA = 6;
    public static final double DELTA = 1e-6;
    private static final Converter CONVERTER = new Converter();

    private double number;
    private int base;
    private int accuracy;

    private String cachedStringValue = null;

    public ScaledNumber(double number, int base, int accuracy) {
        initAttributes(base, accuracy);
        initNumber(number);
    }

    public ScaledNumber(String numberStr, int base, int accuracy) {
        initAttributes(base, accuracy);
        double number = CONVERTER.fromString(numberStr, this.base, this.accuracy);
        initNumber(number);
    }

    public ScaledNumber add(ScaledNumber other) {
        validateEvaluationWith(other);
        return new ScaledNumber(number + other.number, base, accuracy);
    }

    public ScaledNumber subtract(ScaledNumber other) {
        validateEvaluationWith(other);
        return new ScaledNumber(number - other.number, base, accuracy);
    }

    public ScaledNumber multiply(ScaledNumber other) {
        validateEvaluationWith(other);
        return new ScaledNumber(number * other.number, base, accuracy);
    }

    public ScaledNumber divide(ScaledNumber other) {
        validateEvaluationWith(other);
        return new ScaledNumber(number / other.number, base, accuracy);
    }

    public ScaledNumber inversed() {
        if (number != 0) {
            return new ScaledNumber(1 / number, base, accuracy);
        }
        throw new RuntimeException("can not inverse zero");
    }

    public ScaledNumber square() {
        return new ScaledNumber(number * number, base, accuracy);
    }

    @Override
    public ScaledNumber clone() {
        return new ScaledNumber(number, base, accuracy);
    }

    @Override
    public String toString() {
        if (null == cachedStringValue) {
            cachedStringValue = CONVERTER.toString(number, base, accuracy);
        }
        return cachedStringValue;
    }

    private void initAttributes(int base, int accuracy) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("base should be in [2, 16]");
        }
        if (accuracy < 0) {
            throw new IllegalArgumentException("accuracy should be positive number or zero");
        } else if (accuracy > MAX_DELTA) {
            throw new IllegalArgumentException("accuracy is too high");
        }
        this.base = base;
        this.accuracy = accuracy;
    }

    private void initNumber(double number) {
        number = Precision.round(number, accuracy);
        this.number = number;
    }

    private void validateEvaluationWith(ScaledNumber other) {
        if (!isBaseSame(other.base)) {
            throw new IllegalArgumentException("can not evaluate number with different base");
        } else if (!isAccuracySame(other.accuracy)) {
            throw new IllegalArgumentException("can not evaluate number with different accuracy");
        }
    }

    private boolean isBaseSame(int base) {
        return this.base == base;
    }

    private boolean isAccuracySame(int accuracy) {
        return this.accuracy == accuracy;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
        cachedStringValue = null;
    }

    private static class Converter {

        private static final String NUMBER_CHARACTERS = "0123456789ABCDEF";
        private final Pattern SCALED_NUMBER_REGEX = Pattern.compile("\\s*([0-9A-F]+)(\\.([0-9A-F]+))?\\s*");

        public double fromString(String str, int base, int accuracy) {
            Matcher scaledNumberMatcher = SCALED_NUMBER_REGEX.matcher(str.toUpperCase());
            if (!scaledNumberMatcher.matches()) {
                throw new IllegalArgumentException("number string does not match pattern");
            }

            char[] integerPartStr = scaledNumberMatcher.group(1).toCharArray();
            char[] fractionPartStr = Optional.ofNullable(scaledNumberMatcher.group(3)).orElse("").toCharArray();

            int[] integerPartArray = new int[integerPartStr.length];
            int[] fractionPartArray;

            for (int i = 0; i < integerPartStr.length; i++) {
                int temp = NUMBER_CHARACTERS.indexOf(integerPartStr[i]);
                if (temp == -1 || temp >= base) {
                    throw new IllegalArgumentException("char '" + integerPartStr[i] + "' is incorrect value for base " + base);
                }
                integerPartArray[i] = temp;
            }

            double result = 0;
            ArrayUtils.reverse(integerPartArray);
            for (int i = 0; i < integerPartArray.length; i++) {
                result += integerPartArray[i] * Math.pow(base, i);
            }

            if (fractionPartStr.length != 0) {
                fractionPartArray = new int[fractionPartStr.length];

                for (int i = 0; i < fractionPartStr.length; i++) {
                    int temp = NUMBER_CHARACTERS.indexOf(fractionPartStr[i]);
                    if (temp == -1 || temp >= base) {
                        throw new IllegalArgumentException("char '" + integerPartStr[i] + "' is incorrect value for base " + base);
                    }
                    fractionPartArray[i] = temp;
                }

                for (int i = 0; i < fractionPartArray.length; i++) {
                    result += fractionPartArray[i] * Math.pow(base, -i - 1);
                }
            }

            return result;
        }

        public String toString(double num, int base, int accuracy) {
            boolean negativeFlag = num < 0;
            if (negativeFlag) {
                num *= -1;
            }

            int intPart = (int) num;
            double fractionPart = num - intPart;
            List<Integer> intPartList = new LinkedList<>();
            List<Integer> fractionPartList = new LinkedList<>();

            while (intPart > base) {
                intPartList.add(intPart % base);
                intPart /= base;
            }
            if (intPart == base) {
                intPartList.add(0);
                intPartList.add(1);
            } else {
                intPartList.add(intPart);
            }

            int counter = 0;
            while (counter < accuracy) {
                fractionPart *= base;
                intPart = (int) fractionPart;
                fractionPartList.add(intPart);
                fractionPart -= intPart;
                counter += 1;
            }

            StringBuilder resultBuilder = new StringBuilder(intPartList.size() + fractionPartList.size() + 2);
            if (negativeFlag) {
                resultBuilder.append('-');
            }

            Collections.reverse(intPartList);
            intPartList.forEach(index -> resultBuilder.append(NUMBER_CHARACTERS.charAt(index)));

            if (fractionPartList.size() > 0) {
                resultBuilder.append('.');
                fractionPartList.forEach(index -> resultBuilder.append(NUMBER_CHARACTERS.charAt(index)));
            }

            return resultBuilder.toString();
        }

    }
}
