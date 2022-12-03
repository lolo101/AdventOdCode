package fr.lbroquet.adventofcode2022.day2;

public enum Outcome {
    LOSE(0),
    DRAW(3),
    WIN(6);

    private final int score;

    Outcome(int score) {
        this.score = score;
    }

    public static Outcome from(char input) {
        return switch (input) {
            case 'X' -> LOSE;
            case 'Y' -> DRAW;
            case 'Z' -> WIN;
            default -> throw new IllegalArgumentException("Unexpected input: " + input);
        };
    }

    public int score() {
        return score;
    }

    public Shape shape(Shape opponentShape) {
        return switch (this) {
            case LOSE -> opponentShape.beats();
            case DRAW -> opponentShape;
            case WIN -> opponentShape.beaten();
        };
    }
}
