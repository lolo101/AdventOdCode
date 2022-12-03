package fr.lbroquet.adventofcode2016.day1;

public class Position {

    public final int x;
    public final int y;

    Position() {
        this(0, 0);
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance1() {
        return Math.abs(x) + Math.abs(y);
    }
}
