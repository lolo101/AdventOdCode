package fr.lbroquet.adventofcode2023.day11;

import static java.lang.Math.abs;

public record Galaxy(int row, int column) {
    public long distanceFrom(Galaxy other) {
        return abs(row - other.row) + abs(column - other.column);
    }
}
