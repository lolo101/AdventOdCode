package fr.lbroquet.adventofcode2023.day16;

public record Position(int row, int column) {
    public Position nextPosition(Direction direction) {
        return switch (direction) {
            case Upward -> new Position(row - 1, column);
            case Rightward -> new Position(row, column + 1);
            case Downward -> new Position(row + 1, column);
            case Leftward -> new Position(row, column - 1);
        };
    }

    public boolean insideContraption() {
        return (0 <= row && row < 110) && (0 <= column && column < 110);
    }
}
