package fr.lbroquet.adventofcode2023.day11;

import java.util.SortedSet;

import static java.lang.Math.max;
import static java.lang.Math.min;

public record Galaxy(int row, int column) {
    public long distanceFrom(Galaxy other, SortedSet<Integer> expandedRows, SortedSet<Integer> expandedColumns) {
        int minRow = min(row, other.row);
        int maxRow = max(row, other.row);
        int minColumn = min(column, other.column);
        int maxColumn = max(column, other.column);
        int expansions = expandedRows.subSet(minRow, maxRow).size() + expandedColumns.subSet(minColumn, maxColumn).size();
        return (maxRow - minRow) + (maxColumn - minColumn) + (expansions * 999_999L);
    }
}
