package fr.lbroquet.adventofcode2022.day11;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS(Integer::sum),
    TIMES(Math::multiplyExact);

    private final BinaryOperator<Integer> application;

    Operator(BinaryOperator<Integer> application) {
        this.application = application;
    }
    public static Operator of(String symbol) {
        return switch (symbol) {
            case "+" -> PLUS;
            case "*" -> TIMES;
            default -> throw new IllegalArgumentException(symbol);
        };
    }

    public int apply(int oldWorryLevel, int operand) {
        return application.apply(oldWorryLevel, operand);
    }

    @Override
    public String toString() {
        return switch (this) {
            case PLUS -> "increases";
            case TIMES -> "is multiplied";
        };
    }
}
