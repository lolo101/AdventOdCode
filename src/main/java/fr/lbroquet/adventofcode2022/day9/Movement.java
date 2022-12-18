package fr.lbroquet.adventofcode2022.day9;

public record Movement(Direction direction, int length) {

    public static Movement of(String line) {
        String[] movementSpec = line.split(" ");
        return new Movement(
                Direction.from(movementSpec[0]),
                Integer.parseInt(movementSpec[1])
        );
    }

    public Position move(Position position) {
        return direction.move(position, length);
    }
}
