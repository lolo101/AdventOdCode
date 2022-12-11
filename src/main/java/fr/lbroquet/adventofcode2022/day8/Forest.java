package fr.lbroquet.adventofcode2022.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.util.stream.Collectors.joining;

public class Forest {
    private final List<Tree[]> trees = new ArrayList<>();

    public void add(Tree[] treeLine) {
        trees.add(treeLine);
    }

    public void merge(Forest ignored) {}

    public long countVisibleTrees() {
        Tree[][] grid = trees.toArray(Tree[][]::new);
        markVisibleTreesFromTheWest(grid);
        Tree[][] gridRotated90 = rotateCounterClockWise(grid);
        markVisibleTreesFromTheWest(gridRotated90);
        Tree[][] gridRotated180 = rotateCounterClockWise(gridRotated90);
        markVisibleTreesFromTheWest(gridRotated180);
        Tree[][] gridRotated270 = rotateCounterClockWise(gridRotated180);
        markVisibleTreesFromTheWest(gridRotated270);
        return trees.stream()
                .flatMap(Stream::of)
                .filter(Tree::isVisible)
                .count();
    }

    private static void markVisibleTreesFromTheWest(Tree[][] grid) {
        for (Tree[] treeRow : grid) {
            int currentHeight = -1;
            for (Tree tree : treeRow) {
                tree.markVisibleIfHigherThan(currentHeight);
                currentHeight = max(currentHeight, tree.height());
            }
        }
    }

    private static Tree[][] rotateCounterClockWise(Tree[][] grid) {
        Tree[][] target = initTarget(grid);
        int rowLength = grid[0].length;
        for (int row = 0; row < target.length; row++) {
            for (int column = 0; column < target[row].length; column++) {
                target[row][column] = grid[column][rowLength - row - 1];
            }
        }
        return target;
    }

    private static Tree[][] initTarget(Tree[][] grid) {
        int rowLength = grid[0].length;
        Tree[][] target = new Tree[grid.length][];
        for (int row = 0; row < target.length; row++) {
            target[row] = new Tree[rowLength];
        }
        return target;
    }

    public String printVisibleTrees() {
        return trees.stream()
                .map(Forest::printVisibleTreeRow)
                .collect(joining("\n"));
    }

    private static String printVisibleTreeRow(Tree[] row) {
        return Arrays.stream(row).map(tree -> tree.isVisible() ? "\uD83C\uDF32" : "❌").collect(joining());
    }
}
