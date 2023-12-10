package fr.lbroquet.adventofcode2023.day10;

import java.util.Objects;

public record Node(int row, int column, long distance) {
    @Override
    public boolean equals(Object o) {
        return o instanceof Node other
                && other.row == row
                && other.column == column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
