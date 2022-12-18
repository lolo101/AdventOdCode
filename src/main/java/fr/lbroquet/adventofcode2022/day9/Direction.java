package fr.lbroquet.adventofcode2022.day9;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Direction {
    UP("U", (p, l) -> new Position(p.row() - l, p.column())),
    RIGHT("R", (p, l) -> new Position(p.row(), p.column() + l)),
    DOWN("D", (p, l) -> new Position(p.row() + l, p.column())),
    LEFT("L", (p, l) -> new Position(p.row(), p.column() - l));

    private final String letter;
    private final BiFunction<Position, Integer, Position> toto;

    Direction(String letter, BiFunction<Position, Integer, Position> transformation) {
        this.letter = letter;
        this.toto = transformation;
    }

    public static Direction from(String letter) {
        return Arrays.stream(values())
                .filter(d -> d.letter.equals(letter))
                .findFirst()
                .orElseThrow();
    }

    public Position move(Position position, int length) {
        return toto.apply(position, length);
    }
}
