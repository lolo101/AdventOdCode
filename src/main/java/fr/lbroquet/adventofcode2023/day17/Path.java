package fr.lbroquet.adventofcode2023.day17;

import java.util.ArrayList;
import java.util.Collection;

public record Path(Position position, Heading heading, int straightLine, long totalHeatLoss) {

    private static final int MAXIMUM_STRAIGHT_MOVE = 3;

    public Collection<Path> nextPathes(char[][] heatLossMap) {
        Collection<Path> nextPathes = new ArrayList<>();
        Path forward = forwardPath(heatLossMap);
        if (forward != null) nextPathes.add(forward);
        Path right = rightPath(heatLossMap);
        if (right != null) nextPathes.add(right);
        Path left = leftPath(heatLossMap);
        if (left != null) nextPathes.add(left);
        return nextPathes;
    }

    private Path forwardPath(char[][] heatLossMap) {
        if ((straightLine + 1) < MAXIMUM_STRAIGHT_MOVE) {
            Position nextPosition = position.nextPosition(heading);
            if (nextPosition.insideCity()) {
                int nextHeatLoss = nextHeatLoss(heatLossMap, nextPosition);
                return new Path(nextPosition, heading, straightLine + 1, totalHeatLoss + nextHeatLoss);
            }
        }
        return null;
    }

    private Path rightPath(char[][] heatLossMap) {
        Heading nextHeading = heading.turnRight();
        Position nextPosition = position.nextPosition(nextHeading);
        if (nextPosition.insideCity()) {
            int nextHeatLoss = nextHeatLoss(heatLossMap, nextPosition);
            return new Path(nextPosition, nextHeading, 0, totalHeatLoss + nextHeatLoss);
        }
        return null;
    }

    private Path leftPath(char[][] heatLossMap) {
        Heading nextHeading = heading.turnLeft();
        Position nextPosition = position.nextPosition(nextHeading);
        if (nextPosition.insideCity()) {
            int nextHeatLoss = nextHeatLoss(heatLossMap, nextPosition);
            return new Path(nextPosition, nextHeading, 0, totalHeatLoss + nextHeatLoss);
        }
        return null;
    }

    private static int nextHeatLoss(char[][] heatLossMap, Position nextPosition) {
        return heatLossMap[nextPosition.row()][nextPosition.column()] - '0';
    }
}
