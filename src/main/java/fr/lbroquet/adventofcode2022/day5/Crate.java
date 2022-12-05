package fr.lbroquet.adventofcode2022.day5;

public record Crate(int letter) {
    @Override
    public String toString() {
        return Character.toString(letter);
    }
}
