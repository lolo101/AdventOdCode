package fr.lbroquet.adventofcode2023.day13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Math.min;

public class Pattern {
    private final List<String> blockLines = new ArrayList<>();

    public Pattern(Collection<String> blockLines) {
        this.blockLines.addAll(blockLines);
    }

    public long summarize() {
        int rowsAbove = rowsAboveSymetryAxle();
        transpose();
        int columnsLeft = rowsAboveSymetryAxle();

        return 100L * rowsAbove + columnsLeft;
    }

    private void transpose() {
        char[][] blockArray = blockLines.stream().map(String::toCharArray).toArray(char[][]::new);
        char[][] transposed = new char[blockArray[0].length][blockArray.length];
        for (int row = 0; row < blockArray.length; row++) {
            char[] rowArray = blockArray[row];
            for (int column = 0; column < rowArray.length; column++) {
                transposed[column][row] = rowArray[column];
            }
        }
        blockLines.clear();
        for (char[] chars : transposed) {
            blockLines.add(new String(chars));
        }
    }

    private int rowsAboveSymetryAxle() {
        for (int row = 1; row < blockLines.size(); row++) {
            if (symetryAxleAfter(row)) return row;
        }
        return 0;
    }

    private boolean symetryAxleAfter(int row) {
        int rowsToCompare = min(blockLines.size() - row, row);
        for (int offset = 0; offset < rowsToCompare; offset++) {
            String rowAbove = blockLines.get(row - offset - 1);
            String rowUnder = blockLines.get(row + offset);
            if (!rowAbove.equals(rowUnder)) return false;
        }
        return true;
    }
}
