package fr.lbroquet.adventofcode2023.day16;

import java.util.*;

import static java.util.Comparator.naturalOrder;

public class Contraption {
    private final char[][] contraptionArray;
    private final Map<Position, Set<Beam>> visited = new HashMap<>();
    private final Map<Beam, Long> energizations = new HashMap<>();

    public Contraption(char[][] contraptionArray) {
        this.contraptionArray = contraptionArray;
    }

    private char getTile(Position position) {
        return contraptionArray[position.row()][position.column()];
    }

    public long energizedTiles() {
        for (int column = 0; column < 110; ++column) {
            Beam startingBeam = new Beam(new Position(109, column), Direction.Upward);
            energizations.put(startingBeam, energizedTiles(startingBeam));
        }
        for (int row = 0; row < 110; ++row) {
            Beam startingBeam = new Beam(new Position(row, 0), Direction.Rightward);
            energizations.put(startingBeam, energizedTiles(startingBeam));
        }
        for (int column = 0; column < 110; ++column) {
            Beam startingBeam = new Beam(new Position(0, column), Direction.Downward);
            energizations.put(startingBeam, energizedTiles(startingBeam));
        }
        for (int row = 0; row < 110; ++row) {
            Beam startingBeam = new Beam(new Position(row, 109), Direction.Leftward);
            energizations.put(startingBeam, energizedTiles(startingBeam));
        }
        return energizations.values().stream().max(naturalOrder()).orElse(0L);
    }

    public long energizedTiles(Beam startingBeam) {
        Deque<Beam> toVisit = new LinkedList<>();
        toVisit.add(startingBeam);
        visited.clear();
        while (!toVisit.isEmpty()) {
            Beam currentBeam = toVisit.removeFirst();
            Set<Beam> tileBeams = visited.computeIfAbsent(currentBeam.position(), unused -> new HashSet<>());
            if (tileBeams.add(currentBeam)) {
                char tile = getTile(currentBeam.position());
                Collection<Beam> nextBeams = currentBeam.nextBeams(tile);
                toVisit.addAll(nextBeams);
            } else {
//                System.out.println(STR."Skip cycle @ \{currentBeam}");
            }
        }
        return countEnergizedTiles();
    }

    private long countEnergizedTiles() {
        return visited.size();
    }
}
