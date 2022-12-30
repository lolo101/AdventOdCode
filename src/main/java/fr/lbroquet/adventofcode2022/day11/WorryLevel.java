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
}
