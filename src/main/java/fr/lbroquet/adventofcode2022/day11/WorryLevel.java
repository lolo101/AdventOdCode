package fr.lbroquet.adventofcode2022.day11;

import java.math.BigInteger;

public record WorryLevel(BigInteger value) {
    public WorryLevel(int value) {
        this(BigInteger.valueOf(value));
    }

    public WorryLevel(String operand) {
        this(new BigInteger(operand));
    }

    public WorryLevel plus(WorryLevel other) {
        return new WorryLevel(value.add(other.value));
    }

    public WorryLevel times(WorryLevel other) {
        return new WorryLevel(value.multiply(other.value));
    }

    public boolean divisibleBy(int divisor) {
        return value.divideAndRemainder(BigInteger.valueOf(divisor))[1].equals(BigInteger.ZERO);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
