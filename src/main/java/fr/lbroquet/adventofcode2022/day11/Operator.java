package fr.lbroquet.adventofcode2022.day11;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS(WorryLevel::plus),
    TIMES(WorryLevel::times);

    private final BinaryOperator<WorryLevel> application;

    Operator(BinaryOperator<WorryLevel> application) {
        this.application = application;
    }

    public static Operator of(String symbol) {
        return switch (symbol) {
            case "+" -> PLUS;
            case "*" -> TIMES;
            default -> throw new IllegalArgumentException(symbol);
        };
    }

    public WorryLevel apply(WorryLevel oldWorryLevel, WorryLevel operand) {
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
