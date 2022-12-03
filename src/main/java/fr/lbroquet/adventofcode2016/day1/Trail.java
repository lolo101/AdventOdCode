package fr.lbroquet.adventofcode2016.day1;

import java.util.ArrayList;
import java.util.List;

public class Trail {

    private final List<Segment> segments = new ArrayList<>();

    public Trail() {
        segments.add(new Segment(null, new Position(), Orientation.NORTH, 0));
    }

    public void move(String step) {
        Segment last = segments.get(segments.size() - 1);
        Segment next = last.next(step);
        next.checkIntersect(segments);
        segments.add(next);
    }

    public int getDistance() {
        Segment last = segments.get(segments.size() - 1);
        return last.distance1();
    }
}
