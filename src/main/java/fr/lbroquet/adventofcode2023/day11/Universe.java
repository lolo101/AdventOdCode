package fr.lbroquet.adventofcode2023.day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Universe {
    private final char[][] universeArray;

    public Universe(char[][] universeArray) {
        this.universeArray = universeArray;
    }

    public long sumOfDistances() {
        return distances().stream().mapToLong(Long::longValue).sum();
    }

    private Collection<Long> distances() {
        char[][] expandedUniverse = expandUniverse();
        List<Galaxy> galaxies = galaxies(expandedUniverse);
        Collection<Long> distances = new ArrayList<>();
        for (int first = 0; first < galaxies(expandedUniverse).size() - 1; first++) {
            for (int second = first + 1; second < galaxies.size(); second++) {
                Galaxy firstGalaxy = galaxies.get(first);
                Galaxy secondGalaxy = galaxies.get(second);
                distances.add(secondGalaxy.distanceFrom(firstGalaxy));
            }
        }
        return distances;
    }

    private char[][] expandUniverse() {
        char[][] expandedRows = expandRows(universeArray);
        char[][] transposedExpandedRows = transpose(expandedRows);
        char[][] transposedExpandedUniverse = expandRows(transposedExpandedRows);
        return transpose(transposedExpandedUniverse);
    }

    private static char[][] expandRows(char[][] universeArray) {
        Collection<char[]> expandedUniverse = new ArrayList<>();
        for (char[] universeRow : universeArray) {
            expandedUniverse.add(universeRow);
            if (isOnlyVoid(universeRow)) {
                expandedUniverse.add(universeRow);
            }
        }
        return expandedUniverse.toArray(char[][]::new);
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

    private static List<Galaxy> galaxies(char[][] universe) {
        List<Galaxy> galaxies = new ArrayList<>();
        for (int row = 0; row < universe.length; row++) {
            char[] universeRow = universe[row];
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
