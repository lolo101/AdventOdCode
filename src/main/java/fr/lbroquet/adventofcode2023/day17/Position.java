package fr.lbroquet.adventofcode2023.day17;

public record Position(int row, int column) {
    public Position nextPosition(Heading heading) {
        return switch (heading) {
            case North -> new Position(row - 1, column);
            case East -> new Position(row, column + 1);
            case South -> new Position(row + 1, column);
            case West -> new Position(row, column - 1);
        };
    }

    public boolean insideCity() {
        return (0 <= row && row <= 140) && (0 <= column && column <= 140);
    }
}
