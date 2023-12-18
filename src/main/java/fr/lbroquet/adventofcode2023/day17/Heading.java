package fr.lbroquet.adventofcode2023.day17;

public enum Heading {
    North, East, South, West;

    public Heading turnRight() {
        return switch (this) {
            case North -> East;
            case East -> South;
            case South -> West;
            case West -> North;
        };
    }

    public Heading turnLeft() {
        return switch (this) {
            case North -> West;
            case East -> North;
            case South -> East;
            case West -> South;
        };
    }
}
