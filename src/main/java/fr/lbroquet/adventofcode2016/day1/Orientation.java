package fr.lbroquet.adventofcode2016.day1;

enum Orientation {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    Orientation rotate(char rotation) {
        switch(rotation) {
            case 'R': return turnRight();
            case 'L': return turnLeft();
            default:
                throw new AssertionError(rotation);
        }
    }

    public Position advance(Position position, int length) {
        switch(this) {
            case NORTH: return new Position(position.x, position.y + length);
            case EAST: return new Position(position.x + length, position.y);
            case SOUTH: return new Position(position.x, position.y - length);
            case WEST: return new Position(position.x - length, position.y);
            default: throw new AssertionError(this);
        }
    }

    private Orientation turnRight() {
        switch(this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: throw new AssertionError(this);
        }
    }

    private Orientation turnLeft() {
        switch(this) {
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: throw new AssertionError(this);
        }
    }
}
