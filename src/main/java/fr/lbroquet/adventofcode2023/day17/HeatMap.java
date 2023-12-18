package fr.lbroquet.adventofcode2023.day17;

import java.util.*;

import static fr.lbroquet.adventofcode2023.day17.Heading.East;
import static java.util.Comparator.comparing;

public class HeatMap {
    private final char[][] mapArray;
    private final SortedMap<Position, Path> visited = new TreeMap<>(comparing(Position::row).thenComparing(Position::column));

    public HeatMap(char[][] mapArray) {
        this.mapArray = mapArray;
    }

    public long leastHeatLoss(Position arrival) {
        Path path = new Path(new Position(0, 0), East, -1, 0);
        SortedSet<Path> toVisit = new TreeSet<>(
                comparing(Path::totalHeatLoss)
                        .thenComparing(p -> p.position().row())
                        .thenComparing(p -> p.position().column())
        );
        toVisit.add(path);

        while (!toVisit.isEmpty()) {
            Path leastLostHeatPath = toVisit.removeFirst();
            visited.put(leastLostHeatPath.position(), leastLostHeatPath);
            if (leastLostHeatPath.position().equals(arrival)) {
                return leastLostHeatPath.totalHeatLoss();
            }
            Collection<Path> nextPathes = leastLostHeatPath.nextPathes(mapArray);

            nextPathes.stream().filter(p -> !visited.containsKey(p.position())).forEach(toVisit::add);
        }
        return -1;
    }

    public String drawMap() {
        StringBuilder map = new StringBuilder();
        for (int row = 0; row < mapArray.length; row++) {
            char[] mapRow = mapArray[row];
            for (int column = 0; column < mapRow.length; column++) {
                Position position = new Position(row, column);
                if (visited.containsKey(position)) {
                    Heading heading = visited.get(position).heading();
                    map.append(STR."\{(char) 27}[31m\{headingChar(heading)}\{(char) 27}[39m");
                } else {
                    map.append(mapRow[column]);
                }
            }
            map.append('\n');
        }
        return map.toString();
    }

    private static char headingChar(Heading heading) {
        return switch (heading) {
            case North -> '^';
            case East -> '>';
            case South -> 'V';
            case West -> '<';
        };
    }
}
