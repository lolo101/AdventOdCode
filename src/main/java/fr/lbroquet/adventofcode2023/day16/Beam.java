package fr.lbroquet.adventofcode2023.day16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static fr.lbroquet.adventofcode2023.day16.Direction.*;

public record Beam(Position position, Direction direction) {

    public Collection<Beam> nextBeams(char tile) {
        Collection<Direction> nextDirections = nextDirections(tile);
        return nextBeams(nextDirections);
    }

    private Collection<Direction> nextDirections(char tile) {
        if (tile == '\\') {
            return switch (direction) {
                case Upward -> List.of(Leftward);
                case Rightward -> List.of(Downward);
                case Downward -> List.of(Rightward);
                case Leftward -> List.of(Upward);
            };
        }
        if (tile == '/') {
            return switch (direction) {
                case Upward -> List.of(Rightward);
                case Rightward -> List.of(Upward);
                case Downward -> List.of(Leftward);
                case Leftward -> List.of(Downward);
            };
        }
        if (tile == '|') {
            return switch (direction) {
                case Rightward, Leftward -> List.of(Upward, Downward);
                default -> List.of(direction);
            };
        }
        if (tile == '-') {
            return switch (direction) {
                case Upward, Downward -> List.of(Rightward, Leftward);
                default -> List.of(direction);
            };
        }
        return List.of(direction);
    }

    private Collection<Beam> nextBeams(Iterable<Direction> nextDirections) {
        Collection<Beam> beams = new ArrayList<>();
        for (Direction nextDirection : nextDirections) {
            Position nextPosition = position.nextPosition(nextDirection);
            if (nextPosition.insideContraption()) {
                beams.add(new Beam(nextPosition, nextDirection));
            }
        }
        return beams;
    }
}
