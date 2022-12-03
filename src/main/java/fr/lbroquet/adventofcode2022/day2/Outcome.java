package fr.lbroquet.adventofcode2022.day2;

public enum Outcome {
    LOSE(0),
    DRAW(3),
    WIN(6);

    private final int score;

    Outcome(int score) {
        this.score = score;
    }

    public int score() {
        return score;
    }
}
