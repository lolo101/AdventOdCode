package fr.lbroquet.adventofcode2022.day8;

public final class Tree {
    private final int height;
    private boolean visible;

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
}
