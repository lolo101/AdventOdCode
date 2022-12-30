package fr.lbroquet.adventofcode2022.day11;

public record MonkeyNumber(int value) implements Comparable<MonkeyNumber> {
    @Override
    public int compareTo(MonkeyNumber o) {
        return value - o.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
