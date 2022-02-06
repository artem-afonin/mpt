package ru.artem.entity.computing;

import ru.artem.entity.number.Number;

import java.util.function.Supplier;

public class CPU<T extends Number<T>> {

    public enum BinaryOperation {
        NONE,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
    }

    public enum UnaryFunction {
        NONE,
        INVERSED,
        SQUARE,
    }

    private final Supplier<T> defaultSupplier;
    private T leftOperand;
    private T rightOperand;
    private BinaryOperation operation;
    private UnaryFunction function;

    public CPU(Supplier<T> defaultValueSupplier) {
        defaultSupplier = defaultValueSupplier;
        reset();
    }

    public void reset() {
        leftOperand = defaultSupplier.get().clone();
        rightOperand = defaultSupplier.get().clone();
        resetOperation();
    }

    public void resetOperation() {
        operation = BinaryOperation.NONE;
        function = UnaryFunction.NONE;
    }

    public void applyOperation() {
        switch (operation) {
            case ADD: {
                leftOperand = leftOperand.add(rightOperand);
                break;
            }
            case SUBTRACT: {
                leftOperand = leftOperand.subtract(rightOperand);
                break;
            }
            case MULTIPLY: {
                leftOperand = leftOperand.multiply(rightOperand);
                break;
            }
            case DIVIDE: {
                leftOperand = leftOperand.divide(rightOperand);
                break;
            }
            default:
                break;
        }
    }

    public void applyFunction() {
        switch (function) {
            case INVERSED: {
                rightOperand = rightOperand.inversed();
                break;
            }
            case SQUARE: {
                rightOperand = rightOperand.square();
                break;
            }
            default:
                break;
        }
    }

    public T getLeftOperand() {
        return leftOperand.clone();
    }

    public void setLeftOperand(T leftOperand) {
        this.leftOperand = leftOperand.clone();
    }

    public T getRightOperand() {
        return rightOperand.clone();
    }

    public void setRightOperand(T rightOperand) {
        this.rightOperand = rightOperand.clone();
    }

    public BinaryOperation getOperation() {
        return operation;
    }

    public void setOperation(BinaryOperation operation) {
        this.operation = operation;
    }

    public UnaryFunction getFunction() {
        return function;
    }

    public void setFunction(UnaryFunction function) {
        this.function = function;
    }

}
