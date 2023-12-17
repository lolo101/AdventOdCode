package fr.lbroquet.adventofcode2023.day16;

import java.util.*;

public class Contraption {
    private final char[][] contraptionArray;
    private final Map<Position, Set<Beam>> visited = new HashMap<>();

    public Contraption(char[][] contraptionArray) {
        this.contraptionArray = contraptionArray;
    }

    private char getTile(Position position) {
        return contraptionArray[position.row()][position.column()];
    }

    public long energizedTiles() {
        Beam beam = new Beam(new Position(0, 0), Direction.Rightward);
        Deque<Beam> toVisit = new LinkedList<>();
        toVisit.add(beam);
        while (!toVisit.isEmpty()) {
            Beam currentBeam = toVisit.removeFirst();
            Set<Beam> tileBeams = visited.computeIfAbsent(currentBeam.position(), unused -> new HashSet<>());
            if (tileBeams.add(currentBeam)) {
                char tile = getTile(currentBeam.position());
                Collection<Beam> nextBeams = currentBeam.nextBeams(tile);
                toVisit.addAll(nextBeams);
            } else {
                System.out.println(STR."Skip cycle @ \{currentBeam}");
            }
        }
        return countEnergizedTiles();
    }

    private long countEnergizedTiles() {
        return visited.size();
    }
}
