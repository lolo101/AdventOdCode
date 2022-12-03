package fr.lbroquet.adventofcode2016.day1;

import java.util.List;

class Segment {

    private final Position position;
    private final Orientation orientation;
    private final Position destination;
    private final Segment previous;

    Segment(Segment previous, Position position, Orientation orientation, int length) {
        this.position = position;
        this.orientation = orientation;
        this.destination = orientation.advance(position, length);
        this.previous = previous;
    }

    Segment next(String step) {
        char rotation = step.charAt(0);
        int nextLength = Integer.parseInt(step.substring(1));
        return new Segment(this, destination, orientation.rotate(rotation), nextLength);
    }

    public int distance1() {
        return destination.distance1();
    }

    public void checkIntersect(List<Segment> segments) {
        segments.forEach(this::checkIntersect);
    }

    private void checkIntersect(Segment segment) {
        if (segment != previous && perpendicular(segment)) {
            Segment vertical = filterVertical(this, segment);
            Segment horizontal = filterHorizontal(this, segment);
            int vMinY = Math.min(vertical.position.y, vertical.destination.y);
            int vMaxY = Math.max(vertical.position.y, vertical.destination.y);
            int vX = vertical.position.x;
            int hMinX = Math.min(horizontal.position.x, horizontal.destination.x);
            int hMaxX = Math.max(horizontal.position.x, horizontal.destination.x);
            int hY = horizontal.position.y;

            if (hMinX <= vX && vX <= hMaxX && vMinY <= hY && hY <= vMaxY) {
                System.out.println("Intersection @ " + new Position(vX, hY).distance1());
            }
        }
    }

    private boolean perpendicular(Segment segment) {
        return ((orientation == Orientation.NORTH || orientation == Orientation.SOUTH) && (segment.orientation == Orientation.EAST || segment.orientation == Orientation.WEST))
                || ((orientation == Orientation.EAST || orientation == Orientation.WEST) && (segment.orientation == Orientation.NORTH || segment.orientation == Orientation.SOUTH));
    }

    private static Segment filterVertical(Segment s1, Segment s2) {
        return s1.orientation == Orientation.NORTH || s1.orientation == Orientation.SOUTH ? s1 : s2;
    }

    private static Segment filterHorizontal(Segment s1, Segment s2) {
        return s1.orientation == Orientation.EAST || s1.orientation == Orientation.WEST ? s1 : s2;
    }
}
