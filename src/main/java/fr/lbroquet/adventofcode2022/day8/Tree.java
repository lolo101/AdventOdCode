package fr.lbroquet.adventofcode2022.day8;

import java.util.ArrayList;
import java.util.Collection;

public final class Tree {
    private final int height;
    private boolean visible;
    private final Collection<Integer> scenicDistances = new ArrayList<>(4);

    public Tree(int height) {
        this.height = height;
    }

    public int height() {
        return height;
    }

    public boolean isVisible() {
        return visible;
    }

    public void markVisibleIfHigherThan(int height) {
        visible |= this.height > height;
    }

    public int scenicScore() {
        return scenicDistances.stream().reduce(1, Math::multiplyExact);
    }

    public void scenicDistance(Tree[] treeRow, int column) {
        int scenicDistance = 0;
        while ((column + scenicDistance + 1) < treeRow.length) {
            ++scenicDistance;
            Tree other = treeRow[column + scenicDistance];
            if (other.height >= height) break;
        }
        scenicDistances.add(scenicDistance);
    }
}
