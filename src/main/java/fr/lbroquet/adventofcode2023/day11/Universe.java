package fr.lbroquet.adventofcode2023.day11;

import java.util.*;

public class Universe {
    private final char[][] universeArray;
    private final SortedSet<Integer> expandedRows = new TreeSet<>();
    private final SortedSet<Integer> expandedColumns = new TreeSet<>();

    public Universe(char[][] universeArray) {
        this.universeArray = universeArray;
    }

    public long sumOfDistances() {
        return distances().stream().mapToLong(Long::longValue).sum();
    }

    private Collection<Long> distances() {
        expandUniverse();
        List<Galaxy> galaxies = galaxies();
        Collection<Long> distances = new ArrayList<>();
        for (int first = 0; first < galaxies.size() - 1; first++) {
            for (int second = first + 1; second < galaxies.size(); second++) {
                Galaxy firstGalaxy = galaxies.get(first);
                Galaxy secondGalaxy = galaxies.get(second);
                distances.add(secondGalaxy.distanceFrom(firstGalaxy, expandedRows, expandedColumns));
            }
        }
        return distances;
    }

    private void expandUniverse() {
        expandedRows.addAll(expandRows(universeArray));
        char[][] transposedUniverse = transpose(universeArray);
        expandedColumns.addAll(expandRows(transposedUniverse));
    }

    private static Collection<Integer> expandRows(char[][] universeArray) {
        Collection<Integer> expandedRows = new ArrayList<>();
        for (int row = 0; row < universeArray.length; row++) {
            if (isOnlyVoid(universeArray[row])) {
                expandedRows.add(row);
            }
        }
        return expandedRows;
    }

    private static boolean isOnlyVoid(char[] universeRow) {
        for (char cell : universeRow) {
            if (cell == '#') return false;
        }
        return true;
    }

    private static char[][] transpose(char[][] original) {
        int originalHeight = original.length;
        int originalWidth = original[0].length;
        char[][] transposed = new char[originalWidth][originalHeight];
        for (int row = 0; row < originalHeight; row++) {
            for (int column = 0; column < originalWidth; column++) {
                transposed[column][row] = original[row][column];
            }
        }
        return transposed;
    }

    private List<Galaxy> galaxies() {
        List<Galaxy> galaxies = new ArrayList<>();
        for (int row = 0; row < universeArray.length; row++) {
            char[] universeRow = universeArray[row];
            for (int column = 0; column < universeRow.length; column++) {
                char universeCell = universeRow[column];
                if (universeCell == '#') {
                    galaxies.add(new Galaxy(row, column));
                }
            }
        }
        return galaxies;
    }
}
