package fr.lbroquet.adventofcode2022.day9;

import static java.lang.Math.*;

public record Position(int row, int column) {

    public int distance(Position other) {
        return max(abs(row - other.row), abs(column - other.column));
    }

    public Position oneStepToward(Position other) {
        int dRow = other.row - this.row;
        int dColumn = other.column - this.column;
        int normalizedRow = max(-1, min(1, dRow));
        int normalizedColumn = max(-1, min(1, dColumn));
        return new Position(row + normalizedRow, column + normalizedColumn);
    }
}
