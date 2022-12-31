package fr.lbroquet.adventofcode2022.day11;

public record WorryLevel(long value) {
    public WorryLevel(String operand) {
        this(Long.parseLong(operand));
    }

    public WorryLevel plus(WorryLevel other) {
        return new WorryLevel(Math.addExact(value, other.value));
    }

    public WorryLevel times(WorryLevel other) {
        return new WorryLevel(Math.multiplyExact(value, other.value));
    }

    public WorryLevel modulo(int divisorsProduct) {
        return new WorryLevel(value % divisorsProduct);
    }

    public boolean divisibleBy(int divisor) {
        return value % divisor == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
