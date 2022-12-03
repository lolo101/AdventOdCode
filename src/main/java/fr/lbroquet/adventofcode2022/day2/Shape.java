package fr.lbroquet.adventofcode2022.day2;

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
            case 'A' -> ROCK;
            case 'B' -> PAPER;
            case 'C' -> SCISSOR;
            default -> throw new IllegalArgumentException("Unexpected input: " + input);
        };
    }

    public int score() {
        return score;
    }

    public Shape beats() {
        return switch (this) {
            case ROCK -> SCISSOR;
            case PAPER -> ROCK;
            case SCISSOR -> PAPER;
        };
    }

    public Shape beaten() {
        return switch (this) {
            case ROCK -> PAPER;
            case PAPER -> SCISSOR;
            case SCISSOR -> ROCK;
        };
    }
}
