package fr.lbroquet.adventofcode2022.day2;

import static fr.lbroquet.adventofcode2022.day2.Outcome.*;

public enum Shape {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    private final int score;

    Shape(int score) {
        this.score = score;
    }

    public static Shape from(char input) {
        return switch (input) {
            case 'A', 'X' -> ROCK;
            case 'B', 'Y' -> PAPER;
            case 'C', 'Z' -> SCISSOR;
            default -> throw new IllegalArgumentException("Unexpected input: " + input);
        };
    }

    public Outcome outcome(Shape opponentShape) {
        if (this == opponentShape) return DRAW;
        return switch (this) {
            case ROCK -> opponentShape == PAPER ? LOSE : WIN;
            case PAPER -> opponentShape == SCISSOR ? LOSE : WIN;
            case SCISSOR -> opponentShape == ROCK ? LOSE : WIN;
        };
    }

    public int score() {
        return score;
    }
}
