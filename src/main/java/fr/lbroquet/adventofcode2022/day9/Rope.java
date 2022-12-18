package fr.lbroquet.adventofcode2022.day9;

import java.util.HashSet;
import java.util.Set;

public class Rope {
    private Position head = new Position(0, 0);
    private Position tail = new Position(0, 0);
    public final Set<Position> tailPositions = new HashSet<>();

    public Rope() {
        tailPositions.add(tail);
    }

    public void move(Movement movement) {
        head = movement.move(head);
        while (tail.distance(head) > 1) {
            tail = tail.oneStepToward(head);
            tailPositions.add(tail);
        }
    }
}
